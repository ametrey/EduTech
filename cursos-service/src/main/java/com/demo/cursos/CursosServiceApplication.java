package com.demo.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.demo.cursos.controller", "com.demo.cursos.service"})
@EntityScan("com.demo.cursos.entity")
@EnableJpaRepositories("com.demo.cursos.repository")
public class CursosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosServiceApplication.class, args);
	}

}
