package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;


public class UserDao {
	
	private UserDao(){}
	private static UserDao instance;
	
	public static UserDao getInstance(){
		if(instance == null){
			instance = new UserDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int insertUser(Map<String, Object> param){
		String sql = "INSERT INTO TB_JDBC_USER (USER_ID, PASSWORD, USER_NAME)"
				+ " VALUES (?, ? ,?)";
		
		/*컬럼의 개수가 많아지면 오류가 생길 확률이 높아지므로 
		Map형태로 키-값 형태로 담은후 List로 변환*/
		
		List<Object> p = new ArrayList<>();
		p.add(param.get("USER_ID"));
		p.add(param.get("PASSWORD"));
		p.add(param.get("USER_NAME"));
		
		
		return jdbc.update(sql, p);
	}

	public Map<String, Object> selectUser(String userId, String password) {
		String sql = "SELECT USER_ID, PASSWORD, USER_NAME"
				+ " FROM TB_JDBC_USER"
				+ " WHERE USER_ID = ?"
				+ " AND PASSWORD = ?";
		
		List<Object> param = new ArrayList<>();
		param.add(userId);
		param.add(password);
		
		return jdbc.selectOne(sql, param);
	}

	public List<Map<String,Object>> checkIdDao() {
		String sql = "SELECT USER_ID FROM TB_JDBC_USER";
		
		List<Map<String,Object>> id = jdbc.selectList(sql);
		
		return id;
	}

	
	
	
	
}























