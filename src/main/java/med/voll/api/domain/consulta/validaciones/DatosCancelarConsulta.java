package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.consulta.MotivoCancelamiento;
import med.voll.api.domain.medico.Especialidad;

import java.time.LocalDateTime;

public record DatosCancelarConsulta(Long id, @NotNull Long idPaciente, Long idMedico, @Future LocalDateTime fecha,
                                    MotivoCancelamiento motivocancelamiento) {

    public Long idConsulta() {
        return id;
    }

    public MotivoCancelamiento motivo() {
        return motivocancelamiento;
    }
}
