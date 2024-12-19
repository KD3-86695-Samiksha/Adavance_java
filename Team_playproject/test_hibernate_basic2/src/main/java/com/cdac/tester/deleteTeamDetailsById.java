package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import static com.cdac.utils.HibernateUtils.getSessionFactory;
import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;

public class deleteTeamDetailsById {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
		
			//create team dao instance
			TeamDao teamDao=new TeamDaoimpl();
			
			
			System.out.println("Enter user id ");			
			System.out.println(teamDao.deleteTeamDetails(sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	
}
}
