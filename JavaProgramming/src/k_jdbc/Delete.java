package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";

		
		java.sql.Connection con = null;	//연결된 정보
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(url, user, password);
			
			//? 값에 테이블명과 속성명은 기재 할수 없고 값만 가능
			String sql = "DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setObject(1,1);
			
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
