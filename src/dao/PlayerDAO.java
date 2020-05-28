package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Player;

public class PlayerDAO implements Serializable {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/goblincat?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public List<Player> SelectCharacter(){
		List<Player> playerList = new ArrayList<>();

		//DriverLoad
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "select * from player";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String image = rs.getString("image");
				Player player = new Player(id, name, image);
				playerList.add(player);
			}

		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		return playerList;
	}
}
