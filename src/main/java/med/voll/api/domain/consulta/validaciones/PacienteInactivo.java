package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteInactivo implements ValidadorDeConsultas{
    @Autowired
    private PacienteRepository repository;
    public DatosAgendarConsulta validar(DatosAgendarConsulta datos){
        if(datos.idPaciente()==null){
            return datos;
        }

        var pacienteactivo = repository.findByActivoById(datos.idPaciente());

        if(!pacienteactivo){
            throw new ValidationException("El paciente no se encuentra activo");
        }
        return datos;
    }
}
