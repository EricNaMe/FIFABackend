package com.fifa.rest.webservices.restfulwebservices.team;

import java.util.List;
import org.springframework.data.repository.Repository;

public interface ITeamService {
	public boolean saveTeam(Team t);
	public List<Team> ListAll();

}
