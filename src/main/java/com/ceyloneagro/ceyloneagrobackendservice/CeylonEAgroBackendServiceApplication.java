package com.ceyloneagro.ceyloneagrobackendservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties

public class CeylonEAgroBackendServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CeylonEAgroBackendServiceApplication.class, args);
	}

}
