package com.cdac.tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class DisplayTeamDetails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(SessionFactory sf=getSessionFactory()){
		
			
	TeamDao teamDao = new TeamDaoimpl();
			teamDao.getAllTeam().forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	}


