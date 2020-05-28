package test;

import java.util.List;

import dao.RankingDAO;
import model.Ranking;

public class RankingDAOtest {

	public static void main(String[] args) {
		RankingDAO dao = new RankingDAO();
		List<Ranking>rankList = dao.selectScore();

		for(Ranking rank : rankList) {
			System.out.print("ID:"+rank.getId()+" ");
			System.out.print("名前:"+rank.getName()+" ");
			System.out.print("スコア:"+rank.getScore()+" ");
			System.out.print("勝率:"+rank.getWinper()+" ");
			System.out.print("プレイ回数:"+rank.getPlayCount()+" ");
			System.out.println("勝数:"+rank.getWinCount());
		}
	}
}
