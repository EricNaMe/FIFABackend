package com.fifa.rest.webservices.restfulwebservices;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fifa.rest.webservices.restfulwebservices.team.ITeamService;
import com.fifa.rest.webservices.restfulwebservices.team.Team;
import com.fifa.rest.webservices.restfulwebservices.team.TeamServiceImpl;

@SpringBootApplication
public class RestfulWebServicesApplication {


	public static void main(String[] args) {
	SpringApplication.run(RestfulWebServicesApplication.class, args);
	

	
}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/users").allowedOrigins("http://localhost:4200");
			}
		};
	}
	
}
