package test;

import java.util.ArrayList;
import java.util.List;

import model.Player;
import model.UpdateScoreLogic;

public class ScoreDAOtest {

	public static void main(String[] args) {
//		testCatExecute();
//		testMouseExecute();
		testUpdate();
	}

	public static void testCatExecute() {
		List<Player> win = new ArrayList<>();
		Player player4 = new Player(3,"AAA","BBB","CCC");
		win.add(player4);
		UpdateScoreLogic logic = new UpdateScoreLogic();
		for (Player i : win) {
			boolean b = logic.winCat(i.getId());
			System.out.println(b);
		}

	}
	public static void testMouseExecute() {
		List<Player> win = new ArrayList<>();
		Player player1 = new Player(2,"AAA","BBB","CCC");
		Player player2 = new Player(1,"AAA","BBB","CCC");
		Player player3 = new Player(4,"AAA","BBB","CCC");
		win.add(player1);
		win.add(player2);
		win.add(player3);
		UpdateScoreLogic logic = new UpdateScoreLogic();
		for(Player i : win) {
			boolean b = logic.winMouse(i.getId());
			System.out.println(b);
		}
	}

	public static void testUpdate() {
		List<Player> player = new ArrayList<>();
		Player player0= new Player(6,"AAA","BBB");
		Player player2 = new Player(2,"AAA","bbb");
		Player player3 = new Player(7,"WW","DEDE");
		player.add(player0);
		player.add(player2);
		player.add(player3);

//		List<Player> win = new ArrayList<>();
//		win.addAll(player);
//		win.remove(2);
//		for(Player get : win) {
//			System.out.println(get.getName());
//		}
		UpdateScoreLogic logic =new UpdateScoreLogic();
		for(Player get : player) {
			boolean b =logic.changeScore(get.getId());
			System.out.println(b);
		}
	}
}
