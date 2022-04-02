package edu.pe.idat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringBootProyectoFApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProyectoFApplication.class, args);
	}

}
