package service;

import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtill;
import util.View;
import dao.BoardDao;

public class BoardService {
	
	private BoardService(){}
	private static BoardService instance;
	public static BoardService getInstance(){
		
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}
	
	private BoardDao boardDao = BoardDao.getInstance();
	
	
	public int boardList(){
		List<Map<String, Object>> boardList = boardDao.selectBoardList();
		
		System.out.println("\n=======================================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("---------------------------------------");
		for(Map<String, Object> board : boardList){
			System.out.println(board.get("BOARD_NO")
					+ "\t" + board.get("TITLE")
					+ "\t" + board.get("USER_NAME")
					+ "\t" + board.get("REG_DATE"));
		}
		System.out.println("=======================================");
		System.out.println("1.조회\t2.등록\t0.로그아웃");
		System.out.print("입력>");
		int input = ScanUtill.nextInt();
		
		switch(input){
		case 1 : //조회
			return boardOneList();
		case 2 : //등록
			return boardCreate();
		case 0 : //로그아웃
			Controller.LoginUser = null;
			return View.HOME;
		}
		return View.BOARD_LIST;
	}


	private int boardCreate() {
		
		System.out.print("제목>");
		String title = ScanUtill.nextLine();
		System.out.print("내용>");
		String content = ScanUtill.nextLine();
		
		int result = boardDao.boardCreateDao(title,content);
		
		if(result > 0){
			System.out.println("게시물이 등록 되었습니다.");
		}else{
			System.out.println("게시물 등록에 실패하였습니다");
		}
		
		return View.BOARD_LIST;
		
	}


	private int boardOneList() {
		System.out.print("게시물의 번호를 입력>");
		int boardNo = ScanUtill.nextInt();
		
		Map<String, Object> board = boardDao.selectBoardOneList(boardNo);
		
		if(board == null){
			System.out.println("해당 게시물은 존재하지 않습니다");
			return View.BOARD_LIST;
		}
		
			Object num = board.get("BOARD_NO");
			Object title = board.get("TITLE");
			Object content = board.get("CONTENT");
			Object user = board.get("USER_ID");
			Object date = board.get("REG_DATE");
			
			System.out.println("\n========================================================");
			System.out.println("번호 : " + num + " | 작성일 : " + date);
			System.out.println("제목 : " + title + " | 작성자 : " + user);
			System.out.println("내용 : " + content);
			System.out.println("========================================================\n");
			
			String boardUser = (String)board.get("USER_ID");
			String nowUser = (String)Controller.LoginUser.get("USER_ID");
			
			if(boardUser.equals(nowUser)){
			label : while(true){
				
				System.out.print("1.수정\t2.삭제\t\0.처음으로");
				int input = ScanUtill.nextInt();
				
				switch(input){
				case 1 : 
					update(boardNo);
					return View.BOARD_LIST; 
				case 2 :
					delete(boardNo);
					break label;
				case 0 :
					return View.BOARD_LIST;
				}
				
			}
			}
			
			
			return View.BOARD_LIST;
		
	}


	private void update(int boardNo) {
		System.out.print("제목>");
		String title = ScanUtill.nextLine();
		System.out.print("내용>");
		String content = ScanUtill.nextLine();
		int result = boardDao.update(title,content,boardNo);
		if(result > 0){
			System.out.println("게시물이 수정 되었습니다");
		}else{
			System.out.println("수정에 실패하였습니다");
		}
	}


	
	private void delete(int boardNo) {
		
		int result = boardDao.delete(boardNo);
		
		if(result > 0){
			System.out.println("삭제되었습니다");
		}else{
			System.out.println("삭제되지 않았습니다");
		}
	}
	
	
	
}





















