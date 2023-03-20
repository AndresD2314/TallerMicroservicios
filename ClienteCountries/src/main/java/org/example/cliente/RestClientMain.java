package org.example.cliente;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Scanner;


public class RestClientMain {
    public static final String MY_SERVER_URL = "http://localhost:8080/paseos/";

    //public static final String RESTCOUNTRIES_SERVER_URL="http://localhost:8080/paseos/";
    public static void main(String args[]) throws JsonProcessingException {
        int opcion;
        String id;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--- CONSUMO DE SERVICIOS REST ---");
            System.out.println("URL: " + MY_SERVER_URL);
            System.out.println("\n1. Consultar paseos");
            System.out.println("2. Agregar paseo");
            System.out.println("3. Eliminar paseo");
            System.out.println("4. Modificar paseo");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            System.out.println();
            switch (opcion) {
                case 1:
                    consultarPaseos();
                    break;
                case 2:

                    scanner.nextLine();
                    Trip trip = new Trip();
                    System.out.print("Ingrese el origen: ");
                    trip.setOrigin(scanner.nextLine());
                    System.out.print("Ingrese el destino: ");
                    trip.setDestination(scanner.nextLine());
                    System.out.print("Ingrese la duracion: ");
                    trip.setDuration(scanner.nextDouble());
                    System.out.print("Ingrese el precio: ");
                    trip.setPrice(scanner.nextDouble());
                    System.out.println();
                    agregarPaseo(trip);
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.print("Ingrese el id del paseo a eliminar: ");
                    id = scanner.nextLine();
                    System.out.println();
                    eliminarPaseo(id);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Ingrese el id: ");
                    id = scanner.nextLine();
                    System.out.print("Ingrese el origen: ");
                    String origen = scanner.nextLine();
                    System.out.print("Ingrese el destino: ");
                    String destino = scanner.nextLine();
                    System.out.println();
                    modificarPaseo(id, origen, destino);
                    break;
            }
            System.out.println();
        } while (opcion != 5);
        System.out.println("Hasta luego!");
    }

    public static void consultarPaseos() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget =
                client.target(MY_SERVER_URL);
        WebTarget helloWebTarget = webTarget.path("listado/all");
        Invocation.Builder invocationBuilder =
                helloWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        String respuestaTexto = response.readEntity(String.class);
        System.out.println("RESPONSE FROM SERVER code: " + response.getStatus());
        System.out.println("Media type: " + response.getMediaType().toString());
        System.out.println("Content: " + respuestaTexto);
    }

    public static void agregarPaseo(Trip trip) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(trip);

        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(MY_SERVER_URL);
        WebTarget helloWebTarget = webTarget.path("agregar/");
        Invocation.Builder invocationBuilder =
                helloWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.post(Entity.entity(json,
                MediaType.APPLICATION_JSON));
        String respuestaTexto = response.readEntity(String.class);
        System.out.println("RESPONSE FROM SERVER code: " + response.getStatus());
        System.out.println("Media type: " + response.getMediaType().toString());
        System.out.println("Content: " + respuestaTexto);
    }

    public static void eliminarPaseo(String id) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget =
                client.target(MY_SERVER_URL);
        WebTarget helloWebTarget = webTarget.path("/eliminar/" + id);
        Invocation.Builder invocationBuilder =
                helloWebTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.delete();
        String respuestaTexto = response.readEntity(String.class);
        System.out.println("RESPONSE FROM SERVER code: " + response.getStatus());
        System.out.println("Media type: " + response.getMediaType().toString());
        System.out.println("Content: " + respuestaTexto);
    }

    public static void modificarPaseo(String id, String origen, String destino) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        String json = objectMapper.writeValueAsString(new Trip());

        Client client = ClientBuilder.newClient();
        WebTarget webTarget =
                client.target(MY_SERVER_URL);
        WebTarget helloWebTarget = webTarget.path("/modificar/{id}");
        Invocation.Builder invocationBuilder =
                helloWebTarget.resolveTemplate("id", id)
                        .queryParam("origen", origen)
                        .queryParam("destino", destino)
                        .request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.put(Entity.json(""));
        String respuestaTexto = response.readEntity(String.class);
        System.out.println("RESPONSE FROM SERVER code: " + response.getStatus());
        System.out.println("Media type: " + response.getMediaType().toString());
        System.out.println("Content: " + respuestaTexto);
    }

    public static void consumeRestCountriesQuery() {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget =
                client.target(MY_SERVER_URL);
        WebTarget helloWebTarget = webTarget
                .path("currency/jpy")
                .queryParam("fields", "name", "capital");
        Invocation.Builder invocationBuilder =
                helloWebTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        String respuestaTexto = response.readEntity(String.class);
        System.out.println("Content: " + respuestaTexto);
    }
}