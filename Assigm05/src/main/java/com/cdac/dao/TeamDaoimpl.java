package com.cdac.dao;

import com.cdac.entities.Team;
import org.hibernate.*;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;

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

}

	
	

