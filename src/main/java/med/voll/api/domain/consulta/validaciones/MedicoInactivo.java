package med.voll.api.domain.consulta.validaciones;

import jakarta.validation.ValidationException;
import med.voll.api.domain.consulta.DatosAgendarConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicoInactivo implements ValidadorDeConsultas{

    @Autowired
    private MedicoRepository repository;
    public DatosAgendarConsulta validar(DatosAgendarConsulta datos){
        if(datos.idMedico()==null){
            return datos;
        }

        var MedicoActivo = repository.findByActivoById(datos.idMedico());

        if(!MedicoActivo){
            throw new ValidationException("El paciente no se encuentra activo");
        }
        return datos;
    }
}
