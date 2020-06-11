package com.fifa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fifa.rest.webservices.restfulwebservices.exceptions.user.UserNotFoundException;


@Service
public class UserDaoService  {
	
	@Autowired
	private UsersRepository repository;

	public List<Users> findAll() {
		List<Users> users = new ArrayList<>();		
		repository.findAll().forEach(users::add);
		
		return users;						
	}
	
	
	public Optional <Users> findOne(Integer id) {
		return repository.findById(id);
	}
		
	
	public Users save(Users usr) {		
		Users savedUser = repository.save(usr);		
		return savedUser;
	}	
	
	public boolean delete(Integer id) throws UserNotFoundException {
		
		repository.deleteById(id);			
		return true;		
	}
	
	public Users update(Integer id, Users user) {
		System.out.println("User con cambios user:" + user.toString());
		user.setId(id);
		Users updatedUser = repository.save(user);		
		System.out.println("User UpdatedUser: " + updatedUser.toString());
		return updatedUser;

	}
	
	public Users findByEmail(String email) {
		return repository.findByEmail(email);
	}

}