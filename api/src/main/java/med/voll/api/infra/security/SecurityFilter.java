package med.voll.api.infra.security;

import java.io.IOException;
import java.security.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.usuario.UsuarioRepository;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) {

        var tokenJWT = recuperarTokenJWT(request);

        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = repository.findByLogin(subject);
            var autentication = new  UsernamePasswordAuthenticationToken(usuario, null,usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(autentication);
        }

        try {
            filterChain.doFilter(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    private String recuperarTokenJWT(HttpServletRequest request) {

        var autorizationHeader = request.getHeader("Authorization");

        if (autorizationHeader != null && autorizationHeader.startsWith("Bearer ")) {
            return autorizationHeader.replace("Bearer ", "");
        }
    
        return null;
    }

}
