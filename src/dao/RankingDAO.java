package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Ranking;

public class RankingDAO {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/goblincat?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<Ranking> selectScore(){
		List<Ranking> rankList = new ArrayList<>();

		//DriverLoad
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "select score.id,score,playcount,wincount,floor(wincount/playcount*100)as winper,player.name "
						+ "from score left join player on score.id = player.id order by winper desc,wincount desc;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int score = rs.getInt("score");
				int winper = rs.getInt("winper");
				int playcount = rs.getInt("playcount");
				int wincount = rs.getInt("wincount");
				String name = rs.getString("name");
				Ranking ranking = new Ranking(id, name, score, winper, playcount, wincount);
				rankList.add(ranking);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return rankList;
	}
	
	public  int resetRanking() {
		int i = 0;
		final String JDBC_URL = "jdbc:mysql://localhost:3306/goblincat?characterEncoding=UTF-8&serverTimezone=JST";
		final String DB_USER = "root";
		final String DB_PASS = "root";
		//DriverLoad
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "update score set score = 0, playcount = 0, wincount = 0;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			i= pStmt.executeUpdate();

		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		return i;
	}
}