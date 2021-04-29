package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JdbcTest04 {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		Connection con = null;
		Statement stmt = null;
		PreparedStatement ps = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
			
			System.out.println(" === 계좌번호 정보 추가하기 ===");
			System.out.println("계좌번호 : ");
			String bankNo = sc.next();
			
			System.out.println("은 행 명 : ");
			String bankName = sc.next();
			
			System.out.println("예금주명 : ");
			String bankUser = sc.next();
			
			/*// Statement객체 이용하여 데이터 추가
			String sql = "INSERT INTO BANKINFO(BANK_NO, BANK_NAME, BANK_USER_NAME,BANK_DATE)"
					+ " VALUES("+ "'" + bankNo + "' ,'" + bankName + " ','" + bankUser + "', SYSDATE)";
			
			System.out.println(sql);
			
			stmt= con.createStatement();
			
			// executeQuery() 메서드의 반환값 => ResultSet객체
			// executeUpdate() 메서드의 반환값 => 정수값
			
			int result = stmt.executeUpdate(sql);*/
			
			/*if(result > 0)
			System.out.println("등록완료 되었습니다");*/
			
			// PreParedStatment객체를 이용하여 데이터 추가
			
			String sql = "INSERT INTO BANKINFO VALUES(?,?,?,SYSDATE)";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1,bankNo);
			ps.setString(2,bankName);
			ps.setString(3,bankUser);
			
			int result = ps.executeUpdate();
			
			if(result > 0)
				System.out.println("등록완료 되었습니다");
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(stmt != null) try{stmt.close();} catch(SQLException e){}
			if(ps != null) try{ps.close();} catch(SQLException e){}
			if(con != null) try{con.close();} catch(SQLException e){}
			
		}
		
	}

}













