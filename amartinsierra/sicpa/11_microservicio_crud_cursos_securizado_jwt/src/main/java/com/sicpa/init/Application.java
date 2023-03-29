package com.sicpa.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sicpa.controller","com.sicpa.service","com.sicpa.init"})
@EnableJpaRepositories(basePackages = {"com.sicpa.dao"})
@EntityScan(basePackages = {"com.sicpa.model"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
