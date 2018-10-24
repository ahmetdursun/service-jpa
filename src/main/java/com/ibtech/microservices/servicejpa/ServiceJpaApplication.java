package com.ibtech.microservices.servicejpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class ServiceJpaApplication{

/*	@Bean
	public CommandLineRunner exampleQuery(CarRepository repository) {
		return args -> repository.findByMakeIgnoringCase("HONDA")
				.forEach(System.err::println);
	}*/

	public static void main(String[] args) {
		SpringApplication.run(ServiceJpaApplication.class, args);
	}
}
