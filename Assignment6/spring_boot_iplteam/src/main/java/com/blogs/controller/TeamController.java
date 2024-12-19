package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.pojos.Team;
import com.blogs.service.TeamService;



@RestController

@RequestMapping("/team")

@CrossOrigin(origins = "http://localhost:3000")

public class TeamController {
	
	
	@Autowired
	private TeamService teamservice;
	
	public TeamController () {
		System.out.println("in ctor "+getClass());
	}
	
	
	
	
	@GetMapping
	public ResponseEntity<?> getTeam() {
		System.out.println("get all");
		List<Team> team= teamservice.getAllTeam();
		if (team.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(team);
	}
	
	
	
	
	@PostMapping
	public ResponseEntity<?> addNewTeam(@RequestBody 
			Team team) {
		System.out.println("in add team " + team);//transient category
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(teamservice.addNewTeam(team));
	}
}
