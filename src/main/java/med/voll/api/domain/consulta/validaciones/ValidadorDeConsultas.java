package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.consulta.DatosAgendarConsulta;

public interface ValidadorDeConsultas{
    public DatosAgendarConsulta validar(DatosAgendarConsulta datos);
}
