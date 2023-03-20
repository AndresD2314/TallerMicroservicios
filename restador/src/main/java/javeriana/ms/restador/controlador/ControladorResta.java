package javeriana.ms.restador.controlador;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class ControladorResta {

    @Autowired
    Environment environment;

    @GetMapping("/resta")
    public String resta (@RequestParam(name = "a") int a, @RequestParam(name = "b") int b, @RequestParam(name = "nombre") String nombre) {
        String puerto = environment.getProperty("local.server.port");
        int resultado = a - b;
        String respuesta = "Resultado: " + resultado + " -> Microservicio resta corriendo en el puerto: " + puerto;
        Registro registro = new Registro("Resta de " + a + "-" + b, LocalDate.now().toString(), nombre);
        ListaRegistros.agregarRegistro(registro);
        return respuesta;
    }

    @GetMapping("/resta/registros")
    public String registros() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(ListaRegistros.obtenerRegistros());
        return json;
    }
}
