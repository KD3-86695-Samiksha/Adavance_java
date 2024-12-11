package com.cdac.dao;

import com.cdac.entities.Player;
import com.cdac.entities.Team;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

public class TeamDaoimpl implements TeamDao {

	@Override
	public String signUpteam(Team team) {
		String mesg="Team registration failed!!!!!!!!!!";
		// 1. Get Session from SessionFactory
		/*
		 * Method of SessionFactory public Session getCurrentSession() throws
		 * HibernateException
		 */
		Session session = getSessionFactory().getCurrentSession();
		// 2 . Begin a Transaction
		/*
		 * Method of Session 
		 * public Transaction beginTransaction() throws
		 * HibernateException
		 */
		Transaction tx=session.beginTransaction();
		try {
			/*
			 * Session API
			 * public Serializable save(Object transientEntity) throws  HibernateException
			 */
			Serializable teamId = session.save(team);
			//=> success
			tx.commit();
			mesg="team signed up ! , ID "+teamId;
		} catch (RuntimeException e) {
			// => failure -> rollback the Tx
			if(tx != null)
				tx.rollback();
			//re throw the same exception to the caller
			throw e;
		}
		return mesg;
	}

	@Override
	public Team getTeamDetails(Long teamid) {
		Team team=null;
		
		// 1. get Session from SessionFactory
				Session session = getSessionFactory().getCurrentSession();
				// 2. Begin Tx
				Transaction tx = session.beginTransaction();
				try {
					team = session.get(Team.class, teamid);// select
//					user=session.get(User.class, userid);
//					user=session.get(User.class, userid);
//					//in case of valid id , user - persistent (exsists in L1 cache , exists in DB)
					tx.commit(); // session.flush() - no DMLs , session.close(); -
				} catch (RuntimeException e) {
					// roll back the tx
					if (tx != null)
						tx.rollback();
					// re throw the same exception to the caller
					throw e;
				}
				return team;// user - Detached (from L1 cache)
			
	}

	@Override
	public List<Team> getAllTeam() {
		String jpql="select t from Team t";
		List<Team> teams = null;
		// 1. get Session from SessionFactory
		Session session = getSessionFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			// teams - list of persistent entities.
			tx.commit();
		} catch (RuntimeException e) {
			// roll back the tx
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}

		return teams;// teams - list of deatched entities.
	
	}

	@Override
	public List<Team> getselectedTeam(int max_player_age,double batting_avg) {
		// TODO Auto-generated method stub
		List<Team> teams=null;
		
		String jpql ="select t from Team t where t.max_player_age<:age and t.batting_avg> :avg";
		// 1. get Session from SessionFactory
				Session session = getSessionFactory().getCurrentSession();
				// 2. Begin Tx
				Transaction tx = session.beginTransaction();
				
				try {
					teams = session.createQuery(jpql, Team.class)
							.setParameter("age", max_player_age)
							.setParameter("avg", batting_avg)
							.getResultList();
		
					tx.commit();
				} catch (RuntimeException e) {
					// roll back the tx
					if (tx != null)
						tx.rollback();
					// re throw the same exception to the caller
					throw e;
				}
		return teams;
	}

	@Override
	public List<Team> getselectedTeamowner(int max_player_age, double batting_avg) {
	
		
List<Team> teams=null;
		
		String jpql ="select new com.cdac.entities.Team(owner,abbreviation) from Team t where t.max_player_age<:age and t.batting_avg> :avg" ;
		// 1. get Session from SessionFactory
				Session session = getSessionFactory().getCurrentSession();
				// 2. Begin Tx
				Transaction tx = session.beginTransaction();
				
				try {
					teams = session.createQuery(jpql, Team.class)
							.setParameter("age", max_player_age)
							.setParameter("avg", batting_avg)
							.getResultList();
		
					tx.commit();
				} catch (RuntimeException e) {
					// roll back the tx
					if (tx != null)
						tx.rollback();
					// re throw the same exception to the caller
					throw e;
				}
		return teams;
	}

	@Override
	public String deleteTeamDetails(Long nextLong) {
		
		
		String mesg="delete failed!!!!!!";
		Team team=null;
		// 1. get Session from SessionFactory
				Session session=getSessionFactory().getCurrentSession();
				//2. Begin Tx
				Transaction tx=session.beginTransaction();
				
				try {
					//get 
					team=session.get(Team.class,nextLong);
					if(team != null)
					{
						//user - persistent
						session.delete(team);
						mesg="deleted sucess!";
					}
					tx.commit();
				} catch (RuntimeException e) {
					//roll back the tx
					if(tx != null)
						tx.rollback();
					//re throw the same exception to the caller
					throw e;
				}
			
				return mesg;
			}

	@Override
	public Team getDisplayTeamPlayer(Long id) {
		Team team = null;
		
		//String jpql = "select t from Team t where t.id = :id";
		String jpql = "select t from Team t left join fetch t.player where t.id =:id";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		try {
			
			team=session.createQuery(jpql,Team.class)
					.setParameter("id", id)
					.getSingleResult();
			//team = session.get(Team.class, id);
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return team;
	}

	

}
	
	
	
	
	





	
	

