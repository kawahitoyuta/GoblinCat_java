package model;

import java.util.List;

import dao.PlayerDAO;

public class SelectCharcterLogic {
	public List<Player> execute(){
		PlayerDAO dao = new PlayerDAO();
		List<Player> playerList = dao.SelectCharacter();
		return playerList;
	}
}
