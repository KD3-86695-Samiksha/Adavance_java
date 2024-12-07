package com.cdac.entities;


import javax.persistence.*;
@Entity //mandatory cls level annoatation
@Table(name = "new_teams") //to customize table name
public class Team {
	
	@Id // PK
	//For auto ID generation using auto increment constraint - 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name="team_id") //column name - team_id
	private Long teamId; // mapped to PK
	@Column(length = 20, name="Name")//varchar(20
	private String name;
	
	@Column(length = 20, unique=true)//varchar(20
	private String abbreviation;
	
	@Column(length = 20, nullable=false)//varchar(20
	private String owner;
	
	@Column(name="maxplayerage")//
	private  int  max_player_age;
	
	@Column(name="battingavg")
	private  double batting_avg;
	
	@Column(name="wickets_taken")
	
	
	private  int wickets_taken;
	
	
	public Long SgetTeamId() {
		return teamId;
	}
	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getMax_player_age() {
		return max_player_age;
	}
	public void setMax_player_age(int max_player_age) {
		this.max_player_age = max_player_age;
	}
	public double getBatting_avg() {
		return batting_avg;
	}
	public void setBatting_avg(double batting_avg) {
		this.batting_avg = batting_avg;
	}
	public int getWickets_taken() {
		return wickets_taken;
	}
	public void setWickets_taken(int wickets_taken) {
		this.wickets_taken = wickets_taken;
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
	@Override
	public String toString() {
		return "team [ name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", max_player_age=" + max_player_age + ", batting_avg=" + batting_avg + ", wickets_taken="
				+ wickets_taken + "]";
	}
	
	
	
}
	
	
	