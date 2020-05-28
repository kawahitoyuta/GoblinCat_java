package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Word;

public class WordDAO {

	public Word findByWord(int wordId) {

		final String JDBC_URL = "jdbc:mysql://localhost:3306/goblincat?characterEncoding=UTF-8&serverTimezone=JST";
		final String DB_USER = "root";
		final String DB_PASS = "root";

		Word word = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		}catch(Exception e) {
			e.printStackTrace();
		}
		try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
			//SQL
			String sql = "select * from word where id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, wordId);
			//実行
			ResultSet rs = pStmt.executeQuery();

			while(rs.next()){
				int id = rs.getInt("id");
				String wordA = rs.getString("wordA");
				String wordB = rs.getString("wordB");
				word = new Word(id, wordA, wordB);
			}

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return word;
	}

}
