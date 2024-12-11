package com.cdac.dao;



import com.cdac.entities.Player;

public interface PlayerDao {
	 String addplayer(Player player ,Long Team_id);

String  removeplayer(Long teamid , Long playerid);

}
