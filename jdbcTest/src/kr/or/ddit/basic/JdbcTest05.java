package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import kr.or.ddit.util.DBUtil;

/*
 * 	LPROD테이블에 새로운 데이터를 추가하는 프로그래을 작성
 * 	
 * 	lprod_gu 와 lprod_nm은 직접 입력받아서 처리
 * 	lprod_id는 현재의 lprod_id 값들 중에서 제일 큰 값보다 1크게
 * 
 * 	입력받은 lprod_gu가 이미 등록되어 있으면 다시 입력 받아서 처리
 * 
 */


public class JdbcTest05 {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";
		
		
		
		try {
			/*Class.forName("oracle.jdbc.driver.OracleDriver");
			
			con = DriverManager.getConnection(url, user, password);
			*/
			con = DBUtil.getConnection();
			
			String sql = "SELECT lprod_gu FROM LPROD";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			
			
			
			String lprod_gu;
			
			List<String> guList = new ArrayList<>();
			
			while(rs.next()){
				guList.add(rs.getString(1));
			}
			
			System.out.println("코드입력");
			while(true){
				
				boolean flag = false;
				
				lprod_gu = sc.next();
				
				
			
				for(int i = 0; i < guList.size(); i++){
					
					if(guList.get(i).equals(lprod_gu)){
						flag = true;
						System.out.println("입력하신 코드는 이미 존재합니다. 다시 입력하여 주세요");
						break;
					}
				}
				
				if(!flag){
					break;
				}
			}
			
			System.out.println("이름 입력");
			String name = sc.next();
			
			
			sql = "INSERT INTO LPROD VALUES("
					+ " (SELECT NVL(MAX(LPROD_ID),0) + 1 FROM LPROD), ?, ?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, lprod_gu);
			ps.setString(2, name);
			
			int result = ps.executeUpdate();
			
			if(result > 0){
				System.out.println("등록되었습니다");
			}
			
		}catch(SQLException e){
			
		} /*catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/finally{
			
			if(ps != null) try{ps.close();} catch(SQLException e){}
			if(rs != null) try{rs.close();} catch(SQLException e){}
			if(con != null) try{con.close();} catch(SQLException e){}
		}
		
	}

}
