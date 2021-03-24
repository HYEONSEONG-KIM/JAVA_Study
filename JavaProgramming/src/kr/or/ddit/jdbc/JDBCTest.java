package kr.or.ddit.jdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {

	
	public JDBCTest(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이브 로드 성공");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		

		/*
		 * 1.jdbc 로드
		 * 
		 * 2. url, user, pass - DB객체
		 * 
		 * 3. sql 문장
		 * 
		 * 4.실행 객체
		 * 
		 * 5.실행
		 */
		
		JDBCTest jtest = new JDBCTest();
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String user = "PC21";
		String password = "java";
		
		
		try {
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");
			
			String sql = "SELECT * FROM MEMBER ?";
			
			//실행객체
			Statement stmt = con.createStatement();
			
			//실행 select
			ResultSet rs = stmt.executeQuery(sql);
			
			ResultSetMetaData meta = rs.getMetaData();
			int cnt = meta.getColumnCount();
			
			while(rs.next()){
				
				String id = rs.getString("MEM_ID");
				String name = rs.getString("MEM_NAME");
				String tel = rs.getString("MEM_HP");
				
				System.out.print(id + " " + name + " " + tel);
				System.out.println();
				/*for(int i = 1; i <= cnt; i++ ){
				System.out.print(rs.getObject(i) + "\t");
				}
				System.out.println();*/
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
