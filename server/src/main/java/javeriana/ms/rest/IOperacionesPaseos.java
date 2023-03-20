package javeriana.ms.rest;

import java.util.ArrayList;

public interface IOperacionesPaseos {
    public ArrayList<Trip> obtener ();
    public boolean eliminar (String id);
    public boolean modificar (String id, String origen, String destino);
    public boolean guardar (Trip nuevo);
}
