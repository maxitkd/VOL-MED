package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.consulta.DatosCancelamientoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component("ValidadorHorarioDeAntecedenciaCancelamiento")
public class ValidadorHorarioAntecedencia implements ValidadorCancelarConsultas{

    @Autowired
    private ConsultaRepository repository;

    
    public void validar(DatosCancelarConsulta datos){
        var consulta = repository.getReferenceById(datos.idConsulta());
        var ahora = LocalDateTime.now();
        var diferenciaEntreHoras= Duration.between(ahora,consulta.getFecha()).toHours();

        if (diferenciaEntreHoras<24){
            throw new ValidationException("Solo se puede cancelar 24 horas antes de la cita");
        }
    }

}
