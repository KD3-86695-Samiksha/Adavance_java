package com.cdac.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;


import static com.cdac.utils.HibernateUtils.getSessionFactory;
import com.cdac.dao.PlayerDao;
import com.cdac.dao.PlayerDaoimpl;
import com.cdac.entities.Player;



public class AddNewPlayer {

	public static void main(String[] args) {

		try (SessionFactory sf = getSessionFactory(); 
				Scanner sc = new Scanner(System.in)) {
			// create dao instance
			PlayerDao playerDao = new PlayerDaoimpl();
			System.out.println("enter the team id");
			Long Team_id=sc.nextLong();
			System.out.println("Enter player -Firstname,lastname, dob, batting_avg, wickets_taken");
			Player playernew=new Player(sc.next(), sc.next(), LocalDate.parse(sc.next()), sc.nextDouble(), sc.nextInt());
			
			
		System.out.println(playerDao.addplayer(playernew,Team_id));
		} // JVM - sf.close() => DBCP is cleaned up !
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}


