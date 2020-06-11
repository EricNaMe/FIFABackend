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
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fifa.rest.webservices.authentication.CorsFilter;
import com.fifa.rest.webservices.authentication.JWTAuthorizationFilter;
import com.fifa.rest.webservices.restfulwebservices.team.ITeamService;
import com.fifa.rest.webservices.restfulwebservices.team.Team;
import com.fifa.rest.webservices.restfulwebservices.team.TeamServiceImpl;

@SpringBootApplication
public class RestfulWebServicesApplication {


	public static void main(String[] args) {
	SpringApplication.run(RestfulWebServicesApplication.class, args);
	

	
}
	
}
