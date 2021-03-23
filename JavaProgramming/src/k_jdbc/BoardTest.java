package k_jdbc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtill;

public class BoardTest {
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	List<Object> param;
	Map<String, Object> map;
	public static void main(String[] args) {
		BoardTest board = new BoardTest();
		board.init();
	}

	
	
	private void init() {
		
		label : while(true){
			int sequence = 0;
		String sql = "SELECT BOARD_NO AS \"번호\", TITLE AS \"제목\" ,USER_ID AS \"작성자\" ,REG_DATE AS \"작성일\" "
				+ "FROM TB_JDBC_BOARD ORDER BY 4";
		List<Map<String, Object>> list = jdbc.selectList(sql);
		System.out.println();
		System.out.println("순서\t게시글번호\t제목\t작성자\t작성일");
		System.out.println("---------------------------------------------------------------------");
		for(int i = list.size() - 1; i >= 0; i--){
			sequence++;
			
			Object boardNo = list.get(i).get("번호");
			Object title = list.get(i).get("제목");
			Object user = list.get(i).get("작성자");
			Object date = list.get(i).get("작성일");
			System.out.println(sequence + "\t" + boardNo + "\t" + title + "\t" + user + "\t" + date);
		}
		System.out.println("---------------------------------------------------------------------");
		
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
	}



	private void read() {
		System.out.print("게시글의 번호 입력(처음으로 돌아가려면 0입력)>");
		int input = ScanUtill.nextInt();
		
		if(input == 0){
			return;
		}
		String sql = "SELECT * FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
		param = new ArrayList<>();
		param.add(input);
		map = jdbc.selectOne(sql, param);
		
		System.out.println("==================================================================");
		System.out.println("번호 : " + map.get("BOARD_NO") + " | 작성일 : " + map.get("REG_DATE"));
		System.out.println("제목 : " + map.get("TITLE") + " | 작성자 : " + map.get("USER_ID"));
		System.out.println("내용 : " + map.get("CONTENT"));
		System.out.println("==================================================================");
		
		System.out.print("1.수정\t2.삭제\t0.처음으로");
		int num = ScanUtill.nextInt();
		
		switch(num){
		case 1 :
			update(input);
			break;
		case 2 :
			delete(input);
			break;
		case 0 :
			return;
		}
		
	}



	private void delete(int input) {
		String sql = "DELETE FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
		param = new ArrayList<>();
		param.add(input);
		
		int result = jdbc.update(sql, param);
		
		if(result > 0){
			System.out.println("삭제되었습니다");
		}
	}



	private void update(int input) {
		int result = 0;
		System.out.print("1.제목만 수정\t2.내용만 수정\t3.모두수정");
		int input2 = ScanUtill.nextInt();
		if(input2 == 1){
			String sql = "UPDATE TB_JDBC_BOARD SET TITLE = ? WHERE BOARD_NO = '"
					+ input + "'";
			param = new ArrayList<>();
			System.out.print("제목수정>");
			String title = ScanUtill.nextLine();
			param.add(title);
			result = jdbc.update(sql, param);
		}else if(input2 == 2){
			String sql = "UPDATE TB_JDBC_BOARD SET CONTENT = ? WHERE BOARD_NO = '"
					+ input + "'";
			param = new ArrayList<>();
			System.out.print("내용수정>");
			String content = ScanUtill.nextLine();
			param.add(content);
			result = jdbc.update(sql, param);
		}else if(input2 ==3){
			String sql = "UPDATE TB_JDBC_BOARD SET TITLE = ?,CONTENT = ? WHERE BOARD_NO = '"
					+ input + "'";
			param = new ArrayList<>();
			System.out.print("제목수정>");
			String title = ScanUtill.nextLine();
			System.out.print("내용수정>");
			String content = ScanUtill.nextLine();
			param.add(title);
			param.add(content);
			result = jdbc.update(sql, param);
		}
		
		if(result > 0){
			System.out.println("수정되었습니다");
		}
		
	}



	private void create() {
		String sql = "INSERT INTO TB_JDBC_BOARD(BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE) "
				+ "VALUES((SELECT NVL(MAX(BOARD_NO),0) + 1 FROM TB_JDBC_BOARD),?,?,?,SYSDATE)";
		System.out.print("제목>");
		String title = ScanUtill.nextLine();
		System.out.print("내용>");
		String content = ScanUtill.nextLine();
		System.out.print("작성자>");
		String user = ScanUtill.nextLine();
		
		param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(user);
		
		int result = jdbc.update(sql, param);
		if(result > 0){
			System.out.println("게시물이 등록 되었습니다");
		}
		
	}

}
