package com.fifa.rest.webservices.restfulwebservices.team;

import java.util.List;

public interface ITeamService {
	public boolean saveTeam(Team t);
	public List<Team> ListAll();

}
