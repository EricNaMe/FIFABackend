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
	
	   @Bean
	    CorsFilter corsFilter() {
	        CorsFilter filter = new CorsFilter();
	        return filter;
	    }
	   

	   
	
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterBefore(corsFilter(),SessionManagementFilter.class)
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)				
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.GET, "/users").permitAll()				
				.anyRequest().authenticated();
		}
	}
	
	/*@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {			
				  registry.addMapping("/*").allowedOrigins("*").allowedMethods("GET", "POST", "OPTIONS", "PUT")
	                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
	                        "Access-Control-Request-Headers")
	                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials");
			}
		};
	}*/
	
}
