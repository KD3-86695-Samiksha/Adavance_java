package com.cdac.dao;
import static com.cdac.utils.HibernateUtils.getSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cdac.entities.Player;
import com.cdac.entities.Team;


public class PlayerDaoimpl implements PlayerDao  {

	@Override
	public String addplayer(Player player, Long team_id) {
	
		String mesg="adding player failed!";
		// 1. get session from SF (getCurrentSession)
		Session session = getSessionFactory().getCurrentSession();
		
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		
		try {
			Team team =session.get(Team.class,team_id);
			
		
			if (team != null)
				//tx.rollback();
				team.Addplayer(player);
			session.persist(player);
			
			tx.commit();
	mesg="player add ! , ID "+player.getId();
	}catch (RuntimeException e) {
			// re throw the same exception to the caller
			throw e;
		}
		return mesg;
	}
	
	
	
	@Override
	public String removeplayer(Long teamid , Long playerid) {
  
		
		String mesg="removing team failed ";
		// 1. get session from SF (getCurrentSession)
		Session session=getSessionFactory().getCurrentSession();
		
		// 2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			
			//3. get Team from its id
			
			Team team=session.get(Team.class,teamid);
			//4. get player from its id
			Player player=session.get(Player.class, playerid);
			//null checking
			if(team != null && player!= null)
			{
				//team, player - persistent
				team.removeTeamplayer(player);
				mesg="deleted Team Player";
				
			}
			tx.commit();//
		} catch (RuntimeException e) {
			if(tx !=null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

			

}

	


