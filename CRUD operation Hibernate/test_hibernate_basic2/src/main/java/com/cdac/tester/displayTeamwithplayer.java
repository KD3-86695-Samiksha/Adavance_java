package com.cdac.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;
import com.cdac.entities.Team;

import static com.cdac.utils.HibernateUtils.getSessionFactory;

public class displayTeamwithplayer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Team team = null;
		try(SessionFactory sf=getSessionFactory();
				Scanner sc=new Scanner(System.in))
				{
				TeamDao teamDao=new TeamDaoimpl();
				System.out.println("enter team id ");

				team=teamDao.getDisplayTeamPlayer(sc.nextLong());
				System.out.println(team);
				System.out.println("Team player :- ");
				team.getPlayer().forEach(System.out::println);
	}catch (Exception e) {
		e.printStackTrace();
	}

}}
