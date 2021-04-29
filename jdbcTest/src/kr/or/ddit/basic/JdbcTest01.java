package kr.or.ddit.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC(Java DataBase Connectivity)라이브러리를 이용한 DB자료 처리하기
public class JdbcTest01 {

	/*
	 * 	JDBC를 이용한 데이터베이스 처리 순서
	 * 	1.드라이버 로딩 => 라이브러리를 사용할 수 있게 메모리로 읽어 들이는 작업
	 * 		class.forName("oracle.jdbc.driver.OracleDriver");
	 * 
	 * 	2. DB에 접속하기 => DriverManager.getConnection()메서드 이용
	 * 		=> 접속이 완료되면 Connection객체가 생성되어 반환
	 * 
	 * 	3. 질의 => SQL문장을 DB서버로 보내서 결과를 얻어옴
	 * 		=> statement객체 또는 PrepaerdStatement객체를 이용하여 작업
	 * 
	 * 	4. 결과 처리 => 질의 결과를 받아서 원하는 작업을 수행
	 * 		1) SQL문이 select문일 경우 => select문을 처리한 결과가 ResultSet객체에 저장
	 * 		2) SQL문이 select문이 아닐 경우(insert, update, delete)  => 정수값이 반환됨 
	 * 			=> 정수값이 반환(정수값은 보통 해당 명령을 실행해서 성공한 레코드 수를 의미)
	 * 
	 *	5. 사용한 자원 반납 => close()메서드를 이용
	 */
	
	public static void main(String[] args) {
		
		// DB의 LPROD 테이블의 내용을 가져와 출력
		
		// DB작업에 필요한 변수 선언
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB연결 => Connection객체 생성
			con = DriverManager.getConnection(url, user, password);
			
			// 3. SQL문 작성
			String sql = "SELECT LPROD_ID, LPROD_GU, LPROD_NM as name FROM LPROD";
			
			// 4. Statement객체 생성
			stmt = con.createStatement();
			
			// 5. SQL문장을 DB서버로 보내서 결과를 얻어옴
			// (실행할 SQL문장이 select문이기 때문에 결과가 ResultSet객체에 저장되어 변환)
			rs = stmt.executeQuery(sql);
			
			// 6. 결과 처리하기 => ResultSet에 저장된 데이터를 한 레코드씩 화면에 출력
			//  	ResultSet에 저장된 데이터를 차례로 꺼내오려면 반복문과 next()메서드 이용
			System.out.println("== 쿼리문 처리 결과==");
			
			// rs.next() => ResultSet객체의 데이터를 가리키는 포인터를 다음번째 레코드로 이동시키고
			//				그 곳에 데이터가 있으면 true, 없으면 false
			ResultSetMetaData meta = rs.getMetaData();
			
			while(rs.next()){
				// 현재 포인터가 가리키는 곳의 자료를 가져오는 방법
				// 1) rs.get자료형이름("컬럼명")
				System.out.println("Lprod_ID : " + rs.getInt("lprod_id"));
				
				// 2) rs.get자료형이름(컬럼번호)	=> 컬럼번호는 1번부터
				System.out.println("Lprod_GU : " + rs.getString(2));
				
				// 3) rs.get자료형이름(alias)
				System.out.println("Lprod_NM : " + rs.getString("name"));
				System.out.println("--------------------------------------------");
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(rs != null) try {rs.close();} catch(SQLException e){}
			if(stmt != null) try {stmt.close();} catch(SQLException e){}
			if(con != null) try {con.close();} catch(SQLException e){}
			
		}
		
	}

}





























