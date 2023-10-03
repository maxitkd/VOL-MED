package med.voll.api.domain.medico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface MedicoRepository extends JpaRepository<Medico, Long> {


    Page<Medico> findByActivoTrue(Pageable paginacion);

    @Query("""
            select m from medico m
            where m.activo=true 
            and
            m.especialidad=:especialidad 
            and
            m.id =: idMedico and
                m.id not in(
                    select c.medico.id from consulta c
                    where c.fecha=:fecha
                    )
            order by rand() limit 1
            """)
     Medico seleccionarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);



        @Query("""
               SELECT m.activo
               from medico m 
               WHERE m.id=: idMedico
                    """)
        Boolean findByActivoById(Long idMedico);







}
