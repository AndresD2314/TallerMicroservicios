package javeriana.ms.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.glassfish.jersey.process.internal.RequestScoped;

import java.util.ArrayList;

import static javeriana.ms.rest.Builder.paseos;

@Path("paseos")
public class PaseosREST {

    @GET
    @Path("/listado/all")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Trip> obtenerPaseos () {
        return paseos.obtener();
    }

    @POST
    @Path("/agregar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String agregarPaseo (Trip t) {
        if (paseos.guardar(t)) return "Se ha guardado correctamente el viaje en el servidor!";
        return "No se pudo guardar el viaje!";
    }

    @DELETE
    @Path("/eliminar/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String eliminarPaseo (@PathParam("id") String id) {
        if (paseos.eliminar(id)) {
            return "Se ha eliminado correctamente el viaje!";
        }
        return "No se ha podido eliminar el viaje!";
    }

    @PUT
    @Path("/modificar/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String modificarPaseo (@PathParam("id") String id,
                                  @QueryParam("origen") String origen,
                                  @QueryParam("destino") String destino) {
        System.out.println(origen + " " + destino);
        if (paseos.modificar(id, origen, destino)) return "Se ha modificado el paseo correctamente!";
        return "No se ha podido modificar el paseo!";
    }
}
