package com.cdac.tester;

import java.util.Scanner;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;

public class displaySelectedTeamDetailsByAge {

	
	
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			
			TeamDao teamDao=new TeamDaoimpl();
			System.out.println("Enter team  age and batting average");
			teamDao.getselectedTeam(sc.nextInt(),sc.nextDouble()).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
