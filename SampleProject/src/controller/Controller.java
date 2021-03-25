package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtill;
import util.View;

public class Controller {

	public static void main(String[] args) {
		/*
		 * 발표 순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연 > 소감 
		 * 발표 인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 
		 * Controller : 화면 이동
		 * Service : 화면 기능
		 * Dao(Data Access Object) : 쿼리 작성
		 */
		
		new Controller().start();
		
	}
	
	public static Map<String, Object> LoginUser;
	private BoardService boardService = BoardService.getInstance();
	
	private UserService userService = UserService.getInstance();
	
	
	
	//return 받은 값을 이용하여 화면이동
	private void start() {
		int view = View.HOME;
		
		while(true){
			switch(view){
			case View.HOME : view = home(); break;
			
			case View.LOGIN : view = userService.login(); break;
			
			case View.JOIN : view = userService.join(); break;
			
			case View.BOARD_LIST : view = boardService.boardList(); break;
			
			}
		
		}
		
		
	}

	private int home() {
		System.out.println("-----------------------------");
		System.out.println("1.로그인\t2.회원가입\t0.프로그램 종료");
		System.out.println("-----------------------------");
		System.out.print("번호 입력>");
		
		int input = ScanUtill.nextInt();
		
		switch (input) {
		case 1 : //로그인
			return View.LOGIN;
		case 2 : //회원가입
			return View.JOIN;
		case 0 : //프로그램 종료
			System.out.println("프로그램이 종료되었습니다");
			System.exit(0);
		}
		return View.HOME; // 1, 2, 0 이외에 다른 숫자 입력시 다시 돌아오게 설정
	}

	
	
}





















