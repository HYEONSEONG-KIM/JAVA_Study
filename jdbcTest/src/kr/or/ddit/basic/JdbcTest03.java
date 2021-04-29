package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

// Q) Lprod_id값을 2개를 차례로 입력받아 두 값중 작은 값부터 큰 값까지의 자료들을 출력
public class JdbcTest03 {

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
			
			String sql = "SELECT LPROD_ID, LPROD_GU, LPROD_NM FROM LPROD WHERE LPROD_ID >= ? and LPROD_ID <= ?  ";
			ps = con.prepareStatement(sql);
			
			System.out.print("값1 입력 >>");
			int input1 = Integer.parseInt(sc.nextLine());
			System.out.print("값1 입력 >>");
			int input2 = Integer.parseInt(sc.nextLine());
			
			if(input1 > input2){
				int temp = input2;
				input2 = input1;
				input1 = temp;
			}
			
			ps.setInt(1, input1);
			ps.setInt(2, input2);
			
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
