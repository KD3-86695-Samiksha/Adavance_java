package com.cdac.tester;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.cdac.dao.PlayerDao;
import com.cdac.dao.PlayerDaoimpl;



public class deleteplayerfromteam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			PlayerDao dao=new PlayerDaoimpl();
			System.out.println("Enter team id n player id");			
			System.out.println(dao.removeplayer(sc.nextLong(),sc.nextLong()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	}


