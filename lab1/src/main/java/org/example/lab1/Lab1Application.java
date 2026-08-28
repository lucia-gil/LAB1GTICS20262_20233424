package org.example.lab1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// esta es la clase principal, de aca arranca toda la aplicacion
@SpringBootApplication
public class Lab1Application {
    public static void main(String[] args) {
        // esto levanta el servidor embebido y cargara todo el conetxto del spring
        SpringApplication.run(Lab1Application.class, args);
    }
}
