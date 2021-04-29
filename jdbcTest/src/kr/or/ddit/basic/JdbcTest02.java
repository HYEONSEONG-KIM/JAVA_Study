package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// Q) 사용자로 부터 Lprod_id값을 입력 받아 입력값 보다 lprod_id가 큰 자료들은 출력
public class JdbcTest02 {
	
	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "SELECT LPROD_ID, LPROD_GU, LPROD_NM FROM LPROD WHERE LPROD_ID > ?";
			ps = con.prepareStatement(sql);
			
			System.out.print("값 입력 >>");
			int input = Integer.parseInt(sc.nextLine());
			
			ps.setInt(1,input);
			
			rs = ps.executeQuery();
			
			System.out.println("==== 쿼리문 처리 결과 ====");
			while(rs.next()){
				
				System.out.println("LPROD_ID : " + rs.getInt(1));
				System.out.println("LPROD_GU : " + rs.getString(2));
				System.out.println("LPROD_NM : " + rs.getString(3));
				System.out.println("---------------------------------------");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
