package com.cdac.tester;
	
	import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;
import com.cdac.entities.Team;

	import static com.cdac.utils.HibernateUtils.getSessionFactory;


	import java.util.Scanner;

	public class TestRegistration  {

		public static void main(String[] args) {
			try (SessionFactory sf = getSessionFactory();
					Scanner sc=new Scanner(System.in)) {
				//create user dao instance
				TeamDao TeamDao=new TeamDaoimpl();
				System.out.println("Enter team details -  String name, "
						+ "String abbreviation," + "String owner,"+"int max_player_age,"
						+ "double batting_avg," + "int wickets_taken");
								
								
				Team newteam=new Team( sc.next(), sc.next(), sc.next(), sc.nextInt(), 
			           sc.nextDouble(), sc.nextInt());
				System.out.println(TeamDao.signUpteam(newteam));
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	
	


