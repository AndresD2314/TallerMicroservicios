package javeriana.ms.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("restapp")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }

    // 1 http://localhost:8080/restapp/hello?name=Carlos
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloQuery(@QueryParam("name") String name) {
        return "Hello " + name;
    }

    // 2 http://localhost:8080/restapp/hello/Carlos
    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloPath(@PathParam("name") String name) {
        return "Hello " + name;
    }

    // 4 http://localhost:8080/restapp/hellohtml?name=Carlos
    @GET
    @Path("hellohtml")
    @Produces(MediaType.TEXT_HTML)
    public String helloHtml(@QueryParam("name") String name) {
        return "<html>" +
                "<head><title>REST SERVER</title></head>" +
                "<body><p> Hello: " + name + "</p></body>" +
                "</html>";
    }

    // http://localhost:8080/restapp/multip/5?qParam=2
    @GET
    @Path("multip/{pParam}")
    @Produces(MediaType.TEXT_HTML)
    public String helloHtml(@QueryParam("qParam") int paramOne, @PathParam("pParam") String paramTwo) {
        double result = paramOne * Double.valueOf(paramTwo);
        return String.valueOf(result);
    }

    // http://localhost:8080/restapp/trip
    @GET
    @Path("trip")
    @Produces(MediaType.APPLICATION_XML)
    public Trip tripJson() {
        return new Trip("Bogota", "Cartagena", 10, 50000);
    }

}
