package med.voll.api.domain.medico;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import med.voll.api.domain.enuns.Especialidade;

public interface MedicoRepository  extends JpaRepository<Medico,Long>{

    /* Existe duas formas de criar as querys, se o nome do metodo seguir o padrao do 
     * Spring exp: findAllByAtivoTrue, o proprio espring ira fazer fazer a query
     * Se o metodo nao seguir ai é necessario usar a anotaçao @Query
     */
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select m from Medico m
            where m.ativo = 1
            and
            m.especialidade = :especialidade
            and
            m.id not in(
                select c.medico.id from Consulta c
                where c.data = :data
            )
            order by rand()
            limit 1
            """)
    Medico escolherMedicoAleatorioLivreNaData(Especialidade especialidade, LocalDateTime data);

    
    
}
