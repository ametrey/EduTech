package com.demo.edutech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EdutechEServer {

	public static void main(String[] args) {
		SpringApplication.run(EdutechEServer.class, args);
	}

}
