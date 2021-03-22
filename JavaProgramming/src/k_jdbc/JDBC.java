package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sun.jndi.ldap.Connection;

public class JDBC {

	public static void main(String[] args) {
		
		/*
		 * JDBC(Java Database Connectivity)
		 * - 자바의 데이터이스를 연결해주는 라이브러리
		 * - ojdbc : 오라클 JDBC
		 * 
		 * JDBC 작성단계
		 * 1. Connection 생성(DB연결)
		 * 2. Statement 생성(쿼리생성)
		 * 3. Query 실행
		 * 4. ResultSet 에서 결과 추출(select인 경우)
		 * 5. ResultSet, Statement, Connection 닫기
		 * 
		 * 프로젝트 우클릭 -> Build Path -> Configure build path -> Libraries 
		 * -> Add External jars ->ojdbc6.jar 가져오기
		 */
		
		
		//데이터베이스 접속 정보
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";

		
		java.sql.Connection con = null;	//연결된 정보
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			//DB와 연결
			con = DriverManager.getConnection(url, user, password);
			
			//sql작성
			String sql = "SELECT * FROM MEMBER";
			//쿼리를 날리고 결과값 받기
			ps = con.prepareStatement(sql);
			
			//select
			rs = ps.executeQuery();
			
			//insert, update, delete
//			int result = ps.executeUpdate();	//영향받은 행의 개수 리턴
			
			//select인 경우에만 ResultSet에서 결과 추출
			 while(rs.next()){	//다음 행을 바라보면서 다음 행이 존재하는지 여부 리턴
				 String memId = rs.getString(1); //컬럼의 인덱스를 가져오기
				 String memPass = rs.getString("MEM_PASS"); //컬럼명을 통해서 가져오기
				 System.out.println("MEM_ID : " + memId + "/ MEM_PASS :" + memPass );
			 }
			
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			//닫을때는 연것의 역순으로
			if(rs != null) try{ rs.close(); } catch(Exception e){}
			if(ps != null) try{ ps.close(); } catch(Exception e){}
			if(con != null) try{ con.close(); } catch(Exception e){}
		}
		
		
		
	}

}




















