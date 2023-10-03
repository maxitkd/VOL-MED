package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class HorarioDeAnticipacion implements ValidadorDeConsultas{

    public DatosAgendarConsulta validar(DatosAgendarConsulta datos){
        var ahora = LocalDateTime.now();
        var horaConsulta = datos.fecha();

        var diferencia = Duration.between(ahora,horaConsulta).toMinutes()<30;

        if (diferencia){
            throw new ValidationException("La consulta debe tener al menos media hora de anticipacion");
        }
        return datos;
    }
}
