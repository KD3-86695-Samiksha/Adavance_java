package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class GetTeamDetailsById {
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create team dao instance
			TeamDao teamDao=new TeamDaoimpl();
			System.out.println("Enter Team id ");			
			System.out.println(teamDao.getTeamDetails(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

	
	
	

