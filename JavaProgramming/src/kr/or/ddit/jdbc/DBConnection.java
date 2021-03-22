package kr.or.ddit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	private Connection con;
	
	public DBConnection(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "PC21", "java");
			System.out.println("연결성공");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getCont(){
		return con;
	}
	
	
}
