package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.JDBCUtil;

public class BoardDao {
	
	
	private BoardDao() {}
	
	private static BoardDao instance;
	
	public static BoardDao getInstance() {
		if (instance == null) {
			instance = new BoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> selectBoardList(){
		String	sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.REG_DATE"
				+ " FROM TB_JDBC_BOARD A"
				+ " LEFT OUTER JOIN TB_JDBC_USER B"
				+ " ON A.USER_ID = B.USER_ID"
				+ " ORDER BY A.BOARD_NO DESC";
		
		return jdbc.selectList(sql);
	}

	public Map<String, Object> selectBoardOneList(int boradNo) {
		String	sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.REG_DATE, A.USER_ID"
				+ " FROM TB_JDBC_BOARD A"
				+ " LEFT OUTER JOIN TB_JDBC_USER B"
				+ " ON A.USER_ID = B.USER_ID"
				+ "	WHERE A.BOARD_NO = ?"
				+ " ORDER BY A.BOARD_NO DESC";
		
		List<Object> param = new ArrayList<>();
		param.add(boradNo);
		
		return jdbc.selectOne(sql, param);
	}

	public int boardCreateDao(String title, String content) {
		String sql = "INSERT INTO TB_JDBC_BOARD("
				+ " BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE)"
				+ " VALUES ("
				+ "(SELECT NVL(MAX(BOARD_NO),0) + 1 FROM TB_JDBC_BOARD),"
				+ "?,?,?,SYSDATE)";
		Object user = Controller.LoginUser.get("USER_ID"); //조회시 보드와 유저 테이블 OUTER JOIN하므로 조건에 ID가 같은경우를 조회해서 이름을 출력하므로 USER_ID를 게시판에 저장하는게 맞음
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(user);
		
		int result = jdbc.update(sql, param);
		
		return result;
	}

	public int delete(int boardNo) {
		String sql = "DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(boardNo);
		
		int result = jdbc.update(sql,param);
		
		return result;
	}

	public int update(String title, String content, int boardNo) {
		String sql = "UPDATE TB_JDBC_BOARD SET TITLE = ?,"
				+ " CONTENT = ?"
				+ " WHERE BOARD_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(boardNo);
		
		int result = jdbc.update(sql, param);
		
		return result;
	}
	
}





















