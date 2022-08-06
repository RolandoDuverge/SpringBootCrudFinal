package com.app.web;

import com.app.web.entidad.Carros;
import com.app.web.repositorio.CarrosRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

@SpringBootApplication
public class  CrudSpringBootApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CrudSpringBootApplication.class, args);
    }

    @Autowired
    private CarrosRepositorio repositorio;

    @Override
    public void run(String... args) throws Exception {
        //Carros Carros1 = new Carros("Kia", "Picanto", "Nuevo", "Gasolina", "2020", "A213213213", "2321323", "Sport");
        //repositorio.save(Carros1);

    }
}
