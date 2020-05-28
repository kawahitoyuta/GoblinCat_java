package main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class main {

	public static void main(String[] args) {

		//変数定義
		Connection conn = null;
		PreparedStatement ps = null;

		//DB接続情報を設定する
		final String JDBC_URL = "jdbc:mysql://localhost:3306/goblincat?characterEncoding=UTF-8&serverTimezone=JST";
		final String DB_USER= "root";
		final String DB_PASS = "root";


		try {

			//JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");
			//DBへのコネクションを作成する
			conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
			conn.setAutoCommit(false);//オートコミットはオフ

		}catch(Exception e) {
			e.printStackTrace();
		}






		//ファイル読み込みで使用する３つのクラス
		  FileInputStream fi = null;
		  InputStreamReader is = null;
		  BufferedReader br = null;

		  try {

		    //読み込みファイルのインスタンス生成
		    //ファイル名を指定する
		    fi = new FileInputStream("C:\\Users\\S3-20\\Desktop\\tema.csv");
		    is = new InputStreamReader(fi);
		    br = new BufferedReader(is);

		    //読み込み行
		    String line;

		    //読み込み行数の管理
		    int i = 0;


		    //1行ずつ読み込みを行う
		    while ((line = br.readLine()) != null) {

		        //データ内容をコンソールに表示する
		        System.out.println("-------------------------------");

		        //カンマで分割した内容を配列に格納する
		        String[] data = line.split(",");

		        //sql文を定義する
				String sql = "INSERT INTO word values(?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setInt(1, Integer.parseInt(data[0]));
				ps.setString(2, data[1]);
		        ps.setString(3, data[2]);

		        int num = ps.executeUpdate();
		        //処理件数を表示する
		        System.out.println("結果" + num);
		        //コミット
		        conn.commit();


		        //配列の中身を順位表示する。列数(=列名を格納した配列の要素数)分繰り返す

		        for (String parm : data) {

		          System.out.println(parm);
		        }

		      }

		      //行数のインクリメント




		  } catch (Exception e) {
		    e.printStackTrace();
		  } finally {
		    try {
		      br.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }

		}
	}




