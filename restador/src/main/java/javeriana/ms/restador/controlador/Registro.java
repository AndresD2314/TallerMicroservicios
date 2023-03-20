package javeriana.ms.restador.controlador;

import lombok.Data;

@Data
public class Registro {
    private String invocacion;
    private String fecha;
    private String nombre;

    public Registro(String invocacion, String fecha, String nombre) {
        this.invocacion = invocacion;
        this.fecha = fecha;
        this.nombre = nombre;
    }
}
