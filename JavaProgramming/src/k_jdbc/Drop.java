package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Drop {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";
	
		
		java.sql.Connection con = null;	//연결된 정보
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			con = DriverManager.getConnection(url, user, password);
			Insert insert = new Insert();
			
			String sql = "DROP TABLE TEST";
			ps = con.prepareStatement(sql);
		
			boolean test = ps.execute();
		System.out.println(test);
			
			
			
			
			
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
