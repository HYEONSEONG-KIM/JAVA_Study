package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference.Metadata;

import sun.net.www.MeteredStream;

public class JDBC2 {

	public static void main(String[] args) {
		
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC21";
		String password = "java";
	
		
		java.sql.Connection con = null;	//연결된 정보
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		try {
			con = DriverManager.getConnection(url, user, password);
			
			
			
			String sql = "SELECT * FROM CART WHERE CART_MEMBER = ?"; //? -> 동적으로 값을 넣기위해 사용
			ps = con.prepareStatement(sql);
			ps.setString(1, "a001");  //sql ?에 값을 넣어주는 메서드 => 1번째 ?에 a001을 넣음, 타입에 맞게 사용
//			ps.setInt(parameterIndex, x);
//			ps.setDate(parameterIndex, x);
//			ps.setObject(parameterIndex, x);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metadata = rs.getMetaData(); //rs에 있는 데이터에 대한 데이터를 얻어올 수 있음, 몇 컬럼인지 로우인지...등등
			
			int columnCnt = metadata.getColumnCount();
			
			
			while(rs.next()){
				for(int i = 1; i <= columnCnt; i++){ //컬럼은 1부터 시작!!!
					Object value = rs.getObject(i);
					System.out.print(metadata.getColumnName(i)+ " : " +value + "\t");
				}
				System.out.println();
			}
			
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

















