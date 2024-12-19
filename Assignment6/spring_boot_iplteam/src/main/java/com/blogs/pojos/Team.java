package com.blogs.pojos;








import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@ToString(callSuper = true)
public class Team extends BaseEntity {
	
	
	
	@Column(length = 20, name="Name")//varchar(20)
	private String name;
	
	@Column(length = 20, unique=true)//varchar(25) , unique constraint
	private String abbreviation;
	
	@Column(name="maxplayerage")//
	private  int  max_player_age;
	
	@Column(name="battingavg")
	private  double batting_avg;
	
	@Column(name="wickets_taken")
	
	
	private  int wickets_taken;
	
	
	
	
	public Team( String name, String abbreviation, int max_player_age, double batting_avg,
			int wickets_taken) {
		super();
		
		this.name = name;
		this.abbreviation = abbreviation;
		
		this.max_player_age = max_player_age;
		this.batting_avg = batting_avg;
		this.wickets_taken = wickets_taken;
		
		
	}
	
	
}
	
	
	