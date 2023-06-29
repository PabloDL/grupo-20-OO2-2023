package com.UNLa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication//(exclude = {SecurityAutoConfiguration.class})
public class Grupo20Oo22023Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo20Oo22023Application.class, args);
	}

}
