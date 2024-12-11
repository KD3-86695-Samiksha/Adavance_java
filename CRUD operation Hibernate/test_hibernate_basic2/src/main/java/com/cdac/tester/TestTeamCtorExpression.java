package com.cdac.tester;

import java.util.Scanner;
import static com.cdac.utils.HibernateUtils.getSessionFactory;
import org.hibernate.SessionFactory;

import com.cdac.dao.TeamDao;
import com.cdac.dao.TeamDaoimpl;

public class TestTeamCtorExpression {

	
	public static void main(String[] args) {
		try (SessionFactory sf = getSessionFactory();
				Scanner sc=new Scanner(System.in)) {
			//create Team dao instance
		TeamDao teamDao=new TeamDaoimpl();
			System.out.println("Enter team  age and batting average");
					teamDao.getselectedTeamowner(sc.nextInt(),sc.nextDouble()).forEach(team->System.out.println(team.getOwner()+" "+team.getAbbreviation()));
			
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
			
			
			
}
