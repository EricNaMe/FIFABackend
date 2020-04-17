package com.fifa.rest.webservices.restfulwebservices;


import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fifa.rest.webservices.restfulwebservices.user.ITeamService;
import com.fifa.rest.webservices.restfulwebservices.user.Team;
import com.fifa.rest.webservices.restfulwebservices.user.TeamServiceImpl;

@SpringBootApplication
public class RestfulWebServicesApplication implements CommandLineRunner {
	
	@Autowired
	DataSource dataSource;
	

	public static void main(String[] args) {
	ApplicationContext ac =	SpringApplication.run(RestfulWebServicesApplication.class, args);
	
	
	ITeamService service = ac.getBean(TeamServiceImpl.class);
	Team team = new Team();
	for(int i = 0; i<service.ListAll().size(); i++) {
		System.out.println("Equipos:"+service.ListAll().get(i).getTeamName());
	}
/*	team.setTeamName("U de G");
	team.setCountry("Mexico");
	
	boolean status = service.saveTeam(team);
	if(status)
		System.out.println("Data Inserted");
	else
		System.out.println("Valio Pito");
	
*/

	System.out.println("Pitoooo5");	
	
	
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Datasource: "+ dataSource.getConnection().getSchema());
	}

}
