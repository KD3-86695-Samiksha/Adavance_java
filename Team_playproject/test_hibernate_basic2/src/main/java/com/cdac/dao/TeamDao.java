package com.cdac.dao;

import java.util.List;

import com.cdac.entities.Player;
import com.cdac.entities.Team;

public interface TeamDao {
	
	String signUpteam(Team Team);
	//add a method to get user details by id
	
	
	List<Team>getAllTeam();
	
	List<Team> getselectedTeam(int max_player_age, double batting_avg);
	List<Team>getselectedTeamowner(int max_player_age, double batting_avg);
	Team getTeamDetails(Long teamId);
	String deleteTeamDetails(Long teamId);
	Team getDisplayTeamPlayer(Long id);


	
	
}
