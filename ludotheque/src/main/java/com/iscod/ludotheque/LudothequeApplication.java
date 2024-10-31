package com.iscod.ludotheque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LudothequeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LudothequeApplication.class, args);
	}

}
