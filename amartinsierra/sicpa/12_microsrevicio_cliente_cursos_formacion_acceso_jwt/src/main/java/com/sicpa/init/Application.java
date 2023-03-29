package com.sicpa.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.sicpa.controller","com.sicpa.service","com.sicpa.init"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public RestTemplate template() {
		//return new RestTemplate();
		BasicAuthenticationInterceptor iterceptor=new BasicAuthenticationInterceptor("admin", "admin");
		RestTemplate template=new RestTemplate();
		template.getInterceptors().add(iterceptor);
		return template;
	}

}
