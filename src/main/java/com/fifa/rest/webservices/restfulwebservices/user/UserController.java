package com.fifa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/users")
	public ResponseEntity<Object> save(@RequestBody Users user) {
		Users savedUser = service.save(user);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();	
		return ResponseEntity.created(location).build();
	}

}
