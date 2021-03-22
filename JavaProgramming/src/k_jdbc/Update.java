package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
	public static void main(String[] args) {
		
	
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "PC21";
	String password = "java";

	
	java.sql.Connection con = null;	//연결된 정보
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	try {
		con = DriverManager.getConnection(url, user, password);
		
		String sql = "UPDATE MEMBER SET MEM_HP = ?" + 
					", MEM_MAIL = ?" +
				" WHERE MEM_ID = ?";
		ps = con.prepareStatement(sql);
		ps.setObject(1, "010-0101-0202");
		ps.setObject(2, "something@naver.com");
		ps.setObject(3, "a001");
		
		int result = ps.executeUpdate();
		System.out.println(result);
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		//닫을때는 연것의 역순으로
		if(rs != null) try{ rs.close(); } catch(Exception e){}
		if(ps != null) try{ ps.close(); } catch(Exception e){}
		if(con != null) try{ con.close(); } catch(Exception e){}
	}
	
	}
}