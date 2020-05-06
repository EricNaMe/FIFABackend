package com.fifa.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fifa.rest.webservices.restfulwebservices.exceptions.UserNotFoundException;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {
	
	@Autowired
	private UserDaoService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/gato")
	public List <Users> holaGato() {
		return service.findAll();
	}	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(path = "/login")
	public Users retrieveUserByEmail(@RequestBody Users usr) {
		System.out.println("usr.getEmail"+usr.getEmail());
		if(service.findByEmail(usr.getEmail()) == null) throw new UserNotFoundException();
		Users user = service.findByEmail(usr.getEmail());
		if(user.getPassword().equals(usr.getPassword())) {
		String token = getJWTToken(user.getEmail());		
		user.setToken(token);		
		return user;
		} else {
			throw new UserNotFoundException();
		}		
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/users")
	public List <Users> retrieveAllUsers() {
		System.out.println("en users/");
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
	
	/*@PostMapping("user")
	public Users login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		
		String token = getJWTToken(username);
		Users user = new Users();
		user.setName(username);
		user.setToken(token);		
		return user;
		
	}*/

	private String getJWTToken(String username) {
		String secretKey = "6w9z$C&F)J@NcRfUjXnZr4u7x!A%D*G-KaPdSgVkYp3s5v8y/B?E(H+MbQeThWmZ";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))				
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

}
