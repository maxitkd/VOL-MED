package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicoConConsulta implements ValidadorDeConsultas{

    @Autowired
    private ConsultaRepository repository;
    public DatosAgendarConsulta validar(DatosAgendarConsulta datos){

        var medicoConConsulta = repository.existsByMedicoIdAndFecha(datos.idMedico(),datos.fecha());

        if(datos.idMedico()==null){
            return datos;
        }

        if (medicoConConsulta){
            throw new ValidationException("El medico ya tiene una consulta en ese horario");
        }
        return datos;
    }
}
