package com.blogs.service;

import java.util.List;

import com.blogs.pojos.Team;

public interface TeamService {
List<Team> getAllTeam();

String addNewTeam(Team team);
	
	
}
