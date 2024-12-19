package com.cdac.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity //mandatory cls level annoatation
@Table(name = "new_teams")
//to customize table name

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude ="player")//same
public class Team extends BaseEntity {
	
	
	
	@Column(length = 20, name="Name")//varchar(20)
	private String name;
	
	@Column(length = 20, unique=true)//varchar(25) , unique constraint
	private String abbreviation;
	
	@Column(length = 20, nullable=false)//NOT NULL constraint
	private String owner;
	
	@Column(name="maxplayerage")//
	private  int  max_player_age;
	
	@Column(name="battingavg")
	private  double batting_avg;
	
	@Column(name="wickets_taken")
	
	
	private  int wickets_taken;
	//yacha used delete krayche asel tr and update sati hoto
	@OneToMany(mappedBy = "team",cascade = CascadeType.ALL,
			orphanRemoval = true ,fetch=FetchType.EAGER )
	//@OneToMany (mappedBy="team", fetch = FetchType.EAGER)//player madhil team used kele ahe eth
	private List<Player> player =new ArrayList<>();//same
	
	
	public Team(String abbreviation, String owner) {
		super();
		this.abbreviation = abbreviation;
		this.owner = owner;
	}
	public Team( String name, String abbreviation, String owner, int max_player_age, double batting_avg,
			int wickets_taken) {
		super();
		
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.max_player_age = max_player_age;
		this.batting_avg = batting_avg;
		this.wickets_taken = wickets_taken;
		
		
	}
	
	
	public void Addplayer(Player player) {//ha player query madhe used kele ahe
		this.player .add(player);//same 3 position player
		player.setTeam(this);
		
	}
	
	public void removeTeamplayer(Player player) {
		this.player.remove(player);
	 player.setTeam(null);
		
	}
}
	
	
	