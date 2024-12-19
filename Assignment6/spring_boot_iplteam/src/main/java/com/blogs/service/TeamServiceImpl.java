package com.blogs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.dao.TeamDao;
import com.blogs.pojos.Team;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class TeamServiceImpl  implements  TeamService{

	@Autowired
	private TeamDao teamDao;
	
	@Override
	public List<Team> getAllTeam() {
		
		return teamDao.findAll();
	}

	@Override
	public String addNewTeam(Team team) {
		// TODO Auto-generated method stub
		
		Team persistentteam=teamDao.save(team);
		return "Added new category with ID="+persistentteam.getId();
	}

	
	
}
