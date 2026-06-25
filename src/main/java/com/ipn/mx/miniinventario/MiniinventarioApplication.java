package com.ipn.mx.miniinventario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MiniinventarioApplication {

    public static void main(String[] args) {
        // Esta sola línea enciende Apache Tomcat, lee las configuraciones
        // y prepara tu API REST.
        SpringApplication.run(MiniinventarioApplication.class, args);
    }

}