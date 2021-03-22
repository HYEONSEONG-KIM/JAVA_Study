package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import e_oop.ScanUtill;

public class JDBCBoard {

	public static void main(String[] args) {

		/*
		 * TB_JDBC_BOARD 테이블을 사용해 게시판 프로그램 만들기
		 */
		JDBCBoard board = new JDBCBoard();
		board.init();
	}
	
	

	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "PC21";
	String password = "java";

	
	java.sql.Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	
	private void init() {
		try {
			con = DriverManager.getConnection(url, user, password);
			
			
		label :while(true){
			String sql = "SELECT BOARD_NO AS \"번호\", TITLE AS \"제목\" ,USER_ID AS \"작성자\" ,REG_DATE AS \"작성일\" "
					+ "FROM TB_JDBC_BOARD";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			ResultSetMetaData metadata = rs.getMetaData();
			
			int columnCnt = metadata.getColumnCount();
			
			System.out.println();
			for(int i = 1; i <= columnCnt; i++){
				System.out.print(metadata.getColumnName(i) + "\t");
			}
			System.out.println();
			System.out.println("---------------------------------------------------");
			while(rs.next()){
				for(int i = 1; i <= columnCnt; i++){
				Object value = rs.getObject(i);
				System.out.print(value + " \t");
				}
				System.out.println();
			}
			
			System.out.println("---------------------------------------------------");
			
			
			System.out.print("1.조회\t2.등록\t0.종료>");
			int input = ScanUtill.nextInt();

			
			
			switch(input){
				case 1 :
					read();
					break;
				case 2 :
					create();
					break;
				case 0 :
					System.out.println("종료되었습니다");
					break label;
			}
			
		}
			} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	private void read() {
		try {
//			con = DriverManager.getConnection(url, user, password);
			
		
				
				String sql = "SELECT BOARD_NO AS \"번호\","
						+ " TITLE AS \"제목\" ,"
						+ " CONTENT AS \"내용\","
						+ " USER_ID AS \"작성자\","
						+ " REG_DATE AS \"작성일\" "
						+ "FROM TB_JDBC_BOARD";
				
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				ResultSetMetaData metadata = rs.getMetaData();
				
				int columnCnt = metadata.getColumnCount();
				System.out.print("게시물 번호를 입력해주세요(이전으로 돌아가려면 0 입력)>");
				int input = ScanUtill.nextInt();
				if(input == 0){
					return;
				}
				System.out.println("=========================================");
				while(rs.next()){
					int check = rs.getInt("번호");
					if(input == check){
						for(int i = 1; i <= columnCnt; i++){
							Object value = rs.getObject(i);
							System.out.println(metadata.getColumnName(i) + " : " + value);
						}
					}
				}
				System.out.println("=========================================");
				
				System.out.print("1.수정\t2.삭제\t0.처음으로>");
				int input2 = ScanUtill.nextInt();
				
				switch(input2){
				case 1 :
					update(input);
					break;
				case 2 :
					delete(input);
					break;
				case 0 :
					return;
				
				}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}





	private void delete(int input) {
		
		 try {
			 String sql = "SELECT BOARD_NO FROM TB_JDBC_BOARD";
			 ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				int check = rs.getInt("BOARD_NO");
				 if(check == input){
					 sql = "DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
					 ps = con.prepareStatement(sql);
					 ps.setObject(1, input);
					 
					 int result = ps.executeUpdate();
					 if(result == 1){
						 System.out.println("게시물이 삭제되었습니다");
					 }
				 }
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private void update(int input) {
		 try {
			 String sql = "SELECT * FROM TB_JDBC_BOARD";
			 ps = con.prepareStatement(sql);
			 rs = ps.executeQuery();
			 
			 while(rs.next()){
			 int check = rs.getInt("BOARD_NO");
			 if(check == input){
				 sql = "UPDATE TB_JDBC_BOARD SET TITLE = ?,"
				 		+ " CONTENT = ?"
				 		+ " WHERE BOARD_NO = '"
				 		+ input +"'";
				 ps = con.prepareStatement(sql);
				 System.out.print("제목 >");
				 String title = ScanUtill.nextLine();
				 System.out.println("내용 >");
				 String content = ScanUtill.nextLine();
				 
				 ps.setObject(1, title);
				 ps.setObject(2, content);
			
				 
				 int result = ps.executeUpdate();
				if(result == 1){
					System.out.println("게시물이 수정되었습니다");
				}
				 
			 }
			 }
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}


	private void create() {
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "INSERT INTO TB_JDBC_BOARD (BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE)"
					+ "VALUES(("
					+ "SELECT NVL(MAX(BOARD_NO),0) + 1 FROM TB_JDBC_BOARD"
					+ "),?,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			System.out.print("제목>");
			String title = ScanUtill.nextLine();
			
			System.out.print("내용>");
			String content = ScanUtill.nextLine();
			
			System.out.print("작성자>");
			String user = ScanUtill.nextLine();
			ps.setObject(1, title);
			ps.setObject(2, content);
			ps.setObject(3, user);
			
			int result = ps.executeUpdate();
			if(result == 1){
				System.out.println("게시글이 등록 되었습니다");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
