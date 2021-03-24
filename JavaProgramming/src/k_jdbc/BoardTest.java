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
	List<Map<String, Object>> list;
	public static void main(String[] args) {
		BoardTest board = new BoardTest();
		board.init();
	}
/*
	SELECT  A.BOARD_NO,
    A.TITLE,
    A.USER_ID,
    A.REG_DATE,
    COUNT(B.COM_BOARDNO) AS "댓글수"
FROM    TB_JDBC_BOARD A LEFT OUTER JOIN BOARD_COMMENT B ON (A.BOARD_NO = B.COM_BOARDNO)
GROUP BY    A.BOARD_NO, A.TITLE, A.USER_ID,A.REG_DATE;*/
	
	private void init() {
		
		label : while(true){
			int sequence = 0;
		String sql = "SELECT A.BOARD_NO AS \"번호\", A.TITLE AS \"제목\" , A.USER_ID AS \"작성자\" , A.REG_DATE AS \"작성일\", "
				+ "COUNT(B.COM_BOARDNO) AS \"댓글수\" "
				+ "FROM TB_JDBC_BOARD A LEFT OUTER JOIN BOARD_COMMENT B ON (A.BOARD_NO = B.COM_BOARDNO) "
				+ "GROUP BY A.BOARD_NO, A.TITLE, A.USER_ID, A.REG_DATE ORDER BY 4";
		list = new ArrayList<>(); 
		list = jdbc.selectList(sql);
		System.out.println();
		System.out.println("순서\t게시글번호\t제목\t작성자\t댓글수\t작성일");
		System.out.println("---------------------------------------------------------------------");
		for(int i = list.size() - 1; i >= 0; i--){
			sequence++;
			Object commentCnt = list.get(i).get("댓글수");
			Object boardNo = list.get(i).get("번호");
			Object title = list.get(i).get("제목");
			Object user = list.get(i).get("작성자");
			Object date = list.get(i).get("작성일");
			System.out.println(sequence + "\t" + boardNo + "\t" + title + "\t" + user + "\t" + commentCnt + "\t"+ date);
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
		label : while(true){
		String sql = "SELECT * FROM TB_JDBC_BOARD WHERE BOARD_NO = ?";
		param = new ArrayList<>();
		param.add(input);
		map = jdbc.selectOne(sql, param);
		
		if(map == null){
			System.out.println("해당 게시물이 존재하지 않습니다");
			return;
		}else{
		System.out.println("==================================================================");
		System.out.println("번호 : " + map.get("BOARD_NO") + " | 작성일 : " + map.get("REG_DATE"));
		System.out.println("제목 : " + map.get("TITLE") + " | 작성자 : " + map.get("USER_ID"));
		System.out.println("내용 : " + map.get("CONTENT"));
		}
		
		int sequence = 0;
		sql = "SELECT COM_USER, COM_CONTENT, COM_NO FROM BOARD_COMMENT WHERE COM_BOARDNO = ?";
		list = new ArrayList<>();
		list = jdbc.selectList(sql,param);
		System.out.println("--------------------------------댓글--------------------------------");
		System.out.println("순서\t댓글코드\t작성자\t내용");
		System.out.println("-------------------------------------------------------------------");
		if(list.size() > 0){
			for(int i = 0; i < list.size(); i++){
				sequence ++;
				Object code = list.get(i).get("COM_NO");
				Object user = list.get(i).get("COM_USER");
				Object content = list.get(i).get("COM_CONTENT");
				
				System.out.println(sequence + "\t" + code + "\t" + user + "\t" + content);
			}
		}else{
			System.out.println("게시글에 작성된 댓글이 없습니다");
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.println("==================================================================");
		
		
			System.out.print("1.수정\t2.삭제\t3.댓글작성\t4.댓글삭제\t0.처음으로>");
			int num = ScanUtill.nextInt();
			
			switch(num){
			case 1 :
				update(input);
				break;
			case 2 :
				delete(input);
				break label;
			case 3 :
				comment(input);
				break;
			case 4 :
				commentDelete(input);
				break;
			case 0 :
				break label;
			
		}
		}
	}

	private void commentDelete(int input) {
		System.out.print("삭제하고자 하는 댓글의 코드입력>");
		int delete = ScanUtill.nextInt();
		
		String sql = "DELETE FROM BOARD_COMMENT WHERE COM_NO = ? ";
		param = new ArrayList<>();
		param.add(delete);
		
		int result = jdbc.update(sql, param);
		
		if(result > 0){
			System.out.println("댓글이 삭제 되었습니다");
		}else{
			System.out.println("해당 댓글이 존재하지 않습니다");
		}
	}



	private void comment(int input) {
		String sql = "INSERT INTO BOARD_COMMENT VALUES("
				+ "(SELECT NVL(MAX(COM_NO),0) + 1 FROM BOARD_COMMENT)"
				+ ",?,?,?,SYSDATE)";
		param = new ArrayList<>();
		System.out.print("댓글내용>");
		String content = ScanUtill.nextLine();
		System.out.print("작성자>");
		String user = ScanUtill.nextLine();
		
		param.add(input);
		param.add(content);
		param.add(user);
		
		int result = jdbc.update(sql, param);
		
		if(result > 0){
			System.out.println("댓글이 입력 되었습니다");
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
		System.out.print("1.제목만 수정\t2.내용만 수정\t3.모두수정>");
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
