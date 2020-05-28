package test;
import java.util.List;

import dao.PlayerDAO;
import model.Player;


public class PlayerDAOtest {
	public static void main(String[] args) {
		PlayerDAO dao = new PlayerDAO();
		List<Player>playerList = dao.SelectCharacter();

		for(Player player : playerList) {
			System.out.print("ID:"+player.getId());
			System.out.print("名前:"+player.getName());
			System.out.println("image:"+player.getImage());
		}
	}
}