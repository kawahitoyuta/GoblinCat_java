package dao;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ScoreDAO implements Serializable {
	private final String JDBC_URL =
			"jdbc:mysql://localhost:3306/goblincat?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "root";

	public boolean updateScore(int player) {
		//DriverLoad
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			String sql = "update score set playcount = playcount+1 where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, player);
			//実行
			int result = pStmt.executeUpdate();
			if(result == 0) {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateCat(int win){
		//DriverLoad
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SQL
			String sql = "update score set score = score + 2, wincount = wincount + 1 where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, win);
			//実行
			int num = pStmt.executeUpdate();
			if(num==0) {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean updateMouse(int win) {
		//DriverLoad
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SQL
			String sql = "update score set score = score + 1, wincount = wincount + 1 where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, win);
			//実行
			int num = pStmt.executeUpdate();
			if(num==0) {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
