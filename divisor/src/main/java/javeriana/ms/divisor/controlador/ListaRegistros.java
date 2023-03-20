package javeriana.ms.divisor.controlador;

import java.util.ArrayList;

public class ListaRegistros {
    private static ArrayList<Registro> registros = new ArrayList<>();

    public static void agregarRegistro (Registro registro) {
        registros.add(registro);
    }

    public static ArrayList<Registro> obtenerRegistros () {
        return registros;
    }
}
