package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {

	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";

		
		java.sql.Connection con = null;	//연결된 정보
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			String sql = "INSERT INTO TB_JDBC_BOARD (BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE)"
					+ "VALUES(("
					+ "SELECT NVL(MAX(BOARD_NO),0) + 1 FROM TB_JDBC_BOARD"
					+ "),?,?,?,SYSDATE)";
			ps = con.prepareStatement(sql);
			ps.setObject(1, "제목입니다");
			ps.setObject(2, "내용입니다");
			ps.setObject(3, "a001");
			
			int result = ps.executeUpdate();
			System.out.println(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//닫을때는 연것의 역순으로
			if(rs != null) try{ rs.close(); } catch(Exception e){}
			if(ps != null) try{ ps.close(); } catch(Exception e){}
			if(con != null) try{ con.close(); } catch(Exception e){}
		}
		
	}
	
	
	
}



