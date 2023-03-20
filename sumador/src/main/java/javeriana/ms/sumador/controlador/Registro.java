package javeriana.ms.sumador.controlador;

import lombok.Data;

import java.text.DateFormat;
import java.util.ArrayList;
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
