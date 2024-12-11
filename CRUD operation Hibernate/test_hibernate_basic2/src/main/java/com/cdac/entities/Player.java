package com.cdac.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Table(name="player")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude ="team")

public class Player extends BaseEntity {

	
	
	
	@Column(length=20,name="first_name")//varchar(20)
	private String first_name;
	
	@Column(length=20,name="last_name")//varchar(20)
	private String last_name;
	
	private LocalDate dob;//column type - date
	
	
	@Column(name="batting_avg")
	private double batting_avg;
	
	
	@Column(name="wickets_taken")
	private int wickets_taken;
	
	//Player *---->1Team
	@ManyToOne//mandatory
	@JoinColumn(name="player")
	
	private Team team;//Team madhe he team used kele ahe

	public Player(String first_name, String last_name, LocalDate dob, double batting_avg, int wickets_taken) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.batting_avg = batting_avg;
		this.wickets_taken = wickets_taken;
	}
	
	
	
	
	
	
}
