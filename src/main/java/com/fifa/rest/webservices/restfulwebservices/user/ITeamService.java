package com.fifa.rest.webservices.restfulwebservices.user;

import java.util.List;

public interface ITeamService {
	public boolean saveTeam(Team t);
	public List<Team> ListAll();

}
