package med.voll.api.domain.medico;

import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRespuestaMedico(Long id, String nombre, String email, String telefono,
                                   String documento, DatosDireccion direccion) {

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String email() {
        return email;
    }

    @Override
    public String telefono() {
        return telefono;
    }

    @Override
    public String documento() {
        return documento;
    }

    @Override
    public DatosDireccion direccion() {
        return direccion;
    }
}
