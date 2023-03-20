package javeriana.ms.divisor.controlador;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ControladorDivision {

    @Autowired
    Environment environment;

    @GetMapping("/dividir")
    public String division (@RequestParam(name = "a") int a, @RequestParam(name = "b") int b, @RequestParam(name = "nombre") String nombre) {
        String respuesta = "";
        try {
            String puerto = environment.getProperty("local.server.port");
            int resultado = a / b;
            respuesta = "Resultado: " + resultado + " -> Microservicio division corriendo en el puerto: " + puerto;
            Registro registro = new Registro("Division de " + a + "/" + b, LocalDate.now().toString(), nombre);
            ListaRegistros.agregarRegistro(registro);

        } catch (ArithmeticException e) {
            respuesta = "No se puede dividir por 0!";
        }

        return respuesta;
    }

    @GetMapping("/dividir/registros")
    public String registros() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(ListaRegistros.obtenerRegistros());
        return json;
    }
}
