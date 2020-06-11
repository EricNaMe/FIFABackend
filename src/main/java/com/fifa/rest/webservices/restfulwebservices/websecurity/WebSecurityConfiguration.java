package com.fifa.rest.webservices.restfulwebservices.websecurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.fifa.rest.webservices.authentication.JWTAuthorizationFilter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfiguration  extends WebSecurityConfigurerAdapter{	

	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			System.out.println("enConfigure");
			http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
			http.csrf().disable()				
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)				
				.authorizeRequests()	
				.antMatchers(HttpMethod.POST, "/users").permitAll()
				.antMatchers(HttpMethod.PATCH, "/users/update/{id}").permitAll()
				.antMatchers(HttpMethod.DELETE,"/users/delete/{id}").permitAll()
				.antMatchers(HttpMethod.GET,"/users/{id}").permitAll()
				.antMatchers(HttpMethod.POST, "/login").permitAll()
				.antMatchers(HttpMethod.GET, "/users").permitAll()
				.anyRequest().authenticated();
		}
		

}
