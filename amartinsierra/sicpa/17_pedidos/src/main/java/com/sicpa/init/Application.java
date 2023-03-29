package com.sicpa.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;


@EntityScan(basePackages = "com.sicpa.model")
@EnableJpaRepositories(basePackages = "com.sicpa.dao")
@SpringBootApplication(scanBasePackages = {"com.sicpa.controller","com.sicpa.service"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}

}
