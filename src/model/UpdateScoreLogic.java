package model;

import dao.ScoreDAO;

public class UpdateScoreLogic {

	public boolean changeScore(int player){
		ScoreDAO dao = new ScoreDAO();
		boolean b = dao.updateScore(player);
		return b;
	}

	public boolean winMouse(int win) {
		ScoreDAO dao = new ScoreDAO();
		boolean b = dao.updateMouse(win);
		return b;
	}

	public boolean winCat(int win) {
		ScoreDAO dao = new ScoreDAO();
		boolean b = dao.updateCat(win);
		return b;
	}
}
