package com.cdac.tester;

import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;
public class DisplayTeamOwnername {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
				try(SessionFactory sf=getSessionFactory();
				Scanner sc=new Scanner(System.in)){
				
					
			TeamDao teamDao = new TeamDaoimpl();
			System.out.println("Enter team  age and batting average");
			teamDao.getselectedTeamowner(sc.nextInt(),sc.nextDouble()).forEach(System.out::println);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			}



		

