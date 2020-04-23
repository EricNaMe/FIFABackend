package com.fifa.rest.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserDaoService {
	
	@Autowired
	private UserRepository repository;
	
	
	public List<Users> findAll() {
		List<Users> users = new ArrayList<>();		
		repository.findAll().forEach(users::add);
		return users;						
	}
	
	
	public Optional <Users> findOne(Long id) {
		return repository.findById(id);
	}

}