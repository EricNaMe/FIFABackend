package com.fifa.rest.webservices.restfulwebservices.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Integer> {
	public void deleteById(Integer id);
	public Users findByEmail(String email);
	
}
