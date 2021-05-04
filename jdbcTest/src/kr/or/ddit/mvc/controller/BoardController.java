package kr.or.ddit.mvc.controller;

import java.util.List;
import java.util.Scanner;

import kr.or.ddit.mvc.service.BoardServiceImpl;
import kr.or.ddit.mvc.service.IBoardService;
import kr.or.ddit.mvc.vo.BoardVO;

public class BoardController {

	private IBoardService service;
	Scanner sc = null;
	boolean flag = true;
	
	public BoardController() {
		service = new BoardServiceImpl();
		sc = new Scanner(System.in);
	}

	
	public static void main(String[] args) {
		new BoardController().start();
	}

	private void start() {
		selectMenu();
	}


	private void selectMenu() {
		
		while(true){
			
			if(flag)
				showAllBoard();
			
			flag = true;
			
			System.out.println("메뉴 : 1. 새글작성   2. 게시글보기   3. 검색   0. 작업끝");
			System.out.print(">>");
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input){
				case 1 : insertBoard();
					break;
				case 2 : selectBoard();
					break;
				case 3 : searchTitle();
					break;
				case 0 : System.out.println("프로그램 종료...");
					System.exit(0);
			}
			
		}
	}
	
	// 원하는 게시글 번호 조회
	private void selectBoard() {
		System.out.println();
		System.out.print("보기를 원하는 게시물 번호 입력>>");
		int boardNo = Integer.parseInt(sc.nextLine());
		
		BoardVO boardVo = service.showBoard(boardNo);
		
		System.out.println(boardNo + "번글 내용");
		System.out.println("----------------------------------------------------");
		System.out.println("제 목   : " + boardVo.getBoard_title());
		System.out.println("작성자 : " + boardVo.getBoard_writer());
		System.out.println("내  용  : " + boardVo.getBoard_content());
		System.out.println("작성일 : " + boardVo.getBoard_date());
		System.out.println("조회수 : " + boardVo.getBoard_cnt());
		System.out.println("----------------------------------------------------");
		System.out.println("메뉴 : 1. 수정   2. 삭제   3.리스트로 가기");
		System.out.print("작업선택>>");
		int input = Integer.parseInt(sc.nextLine());

		switch(input){
			case 1 :
				break;
			case 2 :
				break;
			case 3 :
				return;
		}
		
	}


	//제목을 입력하여 검색하는 메서드
	private void searchTitle() {
		System.out.println("검색 작업");
		System.out.println("-------------------------------");
		System.out.print("검색할 제목 입력>>");
		String title = sc.nextLine();
		
		List<BoardVO> board = service.titleSearch(title);
		
		if(board.size() > 0){
			
			System.out.println("=======================================================");
			System.out.printf("%s\t%-10s\t%s\t%s","NO","제 목", "작성자", "조회수");
			System.out.println();
			System.out.println("=======================================================");
			for(int i = 0 ; i < board.size();i++){
				System.out.printf("%s\t",board.get(i).getBoard_no());
				System.out.printf("%s\t",board.get(i).getBoard_title());
				System.out.printf("%s\t",board.get(i).getBoard_writer());
				System.out.printf("%s\t",board.get(i).getBoard_cnt());
				System.out.println();
				System.out.println("--------------------------------------------------------");
			}
			flag = false;
		
		}else{
			System.out.println("입력하신 내용의 게시글은 존재하지 않습니다");
			
		}
		
		
	}


	//게시물 작성하는 메서드
	private void insertBoard() {
		System.out.println();
		System.out.println("새글 작성하기");
		System.out.println("-------------------------------");
		System.out.print("제  목 : ");
		String title = sc.nextLine();
		System.out.print("작 성 자 : ");
		String writer = sc.nextLine();
		System.out.print("내  용 : ");
		String content = sc.nextLine();
		
		BoardVO boardVo = new BoardVO();
		boardVo.setBoard_title(title);
		boardVo.setBoard_writer(writer);
		boardVo.setBoard_content(content);
		
		int result = service.insertBoard(boardVo);
		
		if(result > 0){
			System.out.println("새글이 추가 되었습니다\n");
		}else{
			System.out.println("새글 등록에 실패하였습니다\n");
		}
	}


	private void showAllBoard() {
		
		List<BoardVO> board = service.getAllBoard();
		
		System.out.println("=======================================================");
		System.out.printf("%s\t%-10s\t%s\t%s","NO","제 목", "작성자", "조회수");
		System.out.println();
		System.out.println("=======================================================");
		for(int i = 0 ; i < board.size();i++){
			System.out.printf("%s\t",board.get(i).getBoard_no());
			System.out.printf("%s\t",board.get(i).getBoard_title());
			System.out.printf("%s\t",board.get(i).getBoard_writer());
			System.out.printf("%s\t",board.get(i).getBoard_cnt());
			System.out.println();
			System.out.println("--------------------------------------------------------");
		}
		
		
	}

}
