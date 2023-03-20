package javeriana.ms.calculadora.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ControladorCalculadora {
    @Autowired
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/calculadora/suma")
    public String calculadoraSuma(@RequestParam int a, @RequestParam int b, @RequestParam String nombre) {
        String respuesta = restTemplate.getForObject("http://sumador/suma?a={a}&b={b}&nombre={nombre}" , String.class, a, b, nombre);
        return respuesta;
    }

    @GetMapping("/calculadora/suma/registros")
    public String registrosSuma () {
        String respuesta = restTemplate.getForObject("http://sumador/suma/registros", String.class);
        return respuesta;
    }

    @GetMapping("/calculadora/resta")
    public String calculadoraResta(@RequestParam int a, @RequestParam int b, @RequestParam String nombre) {
        String respuesta = restTemplate.getForObject("http://restador/resta?a={a}&b={b}&nombre={nombre}" , String.class, a, b, nombre);
        return respuesta;
    }

    @GetMapping("/calculadora/resta/registros")
    public String registrosResta () {
        String respuesta = restTemplate.getForObject("http://restador/resta/registros", String.class);
        return respuesta;
    }

    @GetMapping("/calculadora/multiplicar")
    public String calculadoraMultiplicacion(@RequestParam int a, @RequestParam int b,@RequestParam String nombre ) {
        String respuesta = restTemplate.getForObject("http://multiplicador/multiplicar?a={a}&b={b}&nombre={nombre}" , String.class, a, b, nombre);
        return respuesta;
    }

    @GetMapping("/calculadora/multiplicar/registros")
    public String registrosMultiplicacion () {
        String respuesta = restTemplate.getForObject("http://multiplicador/multiplicar/registros", String.class);
        return respuesta;
    }

    @GetMapping("/calculadora/dividir")
    public String calculadoraDivisor(@RequestParam int a, @RequestParam int b, @RequestParam String nombre) {
        String respuesta = restTemplate.getForObject("http://divisor/dividir?a={a}&b={b}&nombre={nombre}" , String.class, a, b, nombre);
        return respuesta;
    }

    @GetMapping("/calculadora/dividir/registros")
    public String registrosDivision () {
        String respuesta = restTemplate.getForObject("http://divisor/dividir/registros", String.class);
        return respuesta;
    }
}
