package k_jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Select {

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
			
			String sql = "SELECT MEM_ID AS \"회원ID\", MEM_NAME AS \"회원명\", SUM(CART_QTY) AS \"합계\" FROM MEMBER INNER JOIN CART ON(MEM_ID = CART_MEMBER)"
					+ " GROUP BY MEM_ID, MEM_NAME";
			ps = con.prepareStatement(sql);
//			ps.setInt(parameterIndex, x);
//			ps.setDate(parameterIndex, x);
//			ps.setObject(parameterIndex, x);
			
			rs = ps.executeQuery();
			
			ResultSetMetaData metadata = rs.getMetaData(); //rs에 있는 데이터에 대한 데이터를 얻어올 수 있음, 몇 컬럼인지 로우인지...등등
			
			int columnCnt = metadata.getColumnCount();
			
			for(int i = 1 ; i <= columnCnt; i++){
				System.out.print(metadata.getColumnName(i) + "\t");
			}
			System.out.println("\n-----------------------");
			while(rs.next()){
				for(int i = 1; i <= columnCnt; i++){ //컬럼은 1부터 시작!!!
					Object value = rs.getObject(i);
					System.out.print(value + "\t");
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
