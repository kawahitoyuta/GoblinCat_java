package model;

import java.util.List;

import dao.RankingDAO;

public class SelectScoreLogic {
	public List<Ranking> execute(){
		RankingDAO dao = new RankingDAO();
		List<Ranking> rankList = dao.selectScore();
		return rankList;
	}
}