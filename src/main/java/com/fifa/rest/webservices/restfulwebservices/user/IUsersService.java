package com.fifa.rest.webservices.restfulwebservices.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



public interface IUsersService {
	public Users save(Users usr);
	public Optional <Users> findOne(Long id);
	public List<Users> findAll();
	public boolean delete(Integer id);
	

}
