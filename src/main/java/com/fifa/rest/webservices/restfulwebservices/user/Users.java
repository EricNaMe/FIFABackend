package com.fifa.rest.webservices.restfulwebservices.user;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String alias;
	private String country;
	private Integer age;
	private Date birthDate;
	private String email;
	private String password;
	private String token;
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
		
	protected Users() {}
	
	public Users(Integer id, String name, String alias, String country, Integer age, Date birthDate, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.country = country;
		this.age = age;
		this.birthDate = birthDate;
		this.email = email;
		this.password = password;
		
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", alias=" + alias + ", country=" + country + ", age=" + age
				+ ", birthDate=" + birthDate + "]";
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	

}