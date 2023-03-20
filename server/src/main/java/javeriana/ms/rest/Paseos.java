package javeriana.ms.rest;

import java.util.ArrayList;
import java.util.Objects;

public class Paseos implements IOperacionesPaseos {

    private static ArrayList<Trip> listaPaseos;

    public Paseos() {
        listaPaseos = new ArrayList<>();
    }

    @Override
    public ArrayList<Trip> obtener() {
        return listaPaseos;
    }

    @Override
    public boolean eliminar(String id) {
        return listaPaseos.removeIf(t -> Objects.equals(t.getId(), id));
    }

    @Override
    public boolean modificar(String id, String origen, String destino) {
        for (Trip t : listaPaseos) {
            if (Objects.equals(t.getId(), id)) {
                t.setOrigin(origen);
                t.setDestination(destino);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean guardar(Trip nuevo) {
        if (listaPaseos.stream().noneMatch(t -> Objects.equals(t.getId(), nuevo.getId()))){
            listaPaseos.add(nuevo);
            return true;
        }
        return false;
    }
}
