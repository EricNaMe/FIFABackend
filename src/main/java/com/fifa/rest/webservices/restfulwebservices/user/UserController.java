package com.fifa.rest.webservices.restfulwebservices.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/gato")
	public List <Users> holaGato() {
		return service.findAll();
	}
	
	
	@GetMapping(path = "/users")
	public List <Users> retrieveAllUsers() {
		return service.findAll();
	}

}
