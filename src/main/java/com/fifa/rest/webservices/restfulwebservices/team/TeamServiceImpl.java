package com.fifa.rest.webservices.restfulwebservices.team;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements ITeamService{

	@Autowired
	private TeamRepository repository;
	
	@Override
	public List<Team> ListAll(){
		List<Team> teams = new ArrayList<>();
		
		repository.findAll().forEach(teams::add);
		return teams;
	}
	

	
	@Override
	public boolean saveTeam(Team t) {
		
		Team team = repository.save(t);
		return (team!=null)?true:false;
	}
	
}
