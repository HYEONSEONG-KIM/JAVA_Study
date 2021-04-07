package kr.or.ddit.basic;

import java.util.LinkedList;

public class StackTest {

	public static void main(String[] args) {
		
		Browser b = new Browser();
		
		b.goURL("1. 네이버");
		b.goURL("2. 야후");
		b.goURL("3. 구글");
		b.goURL("4. 다음");
		
		b.history();
		
		System.out.println("앞으로 가기 후...");
		b.goFoward();
		b.history();
		
		System.out.println("뒤로가기 후...");
		b.goBack();
		b.history();
		
		b.goBack();
		b.history();
		
		System.out.println("새로운 사이트 접속 후...");
		b.goURL("5. 네이트");
		b.history();
	
		b.goFoward();
		b.history();
	}

}


// 웹 브라우저의 앞으로 가기, 뒤로 가기 기능 구현

class Browser{
	private LinkedList<String> back;		// 이전 방문 내역이 저장될 스택
	private LinkedList<String> foward;		// 다음 방문 내열이 저장될 스택
	private String currentURL;				// 현재 페이지

	public Browser(){
		back = new LinkedList<>();
		foward = new LinkedList<>();
		
		currentURL = "";
	}
	
	// 사이트 방문하는 메서드 => 매개변수에는 방문할 URL이 저장
	public void goURL(String url){
		
		System.out.println(url + "사이트에 접속합니다");

		if(currentURL != null && !"".equals(currentURL)){ // 현재 페이지가 있으면...
			back.push(currentURL);	// 현재 페이지를 back스택에 추가
		}
		
		currentURL = url;
	}
	
	
	// 뒤로 가기 기능 구현할 메서드
	public void goBack(){
		// List가 비었는지 검사 => isEmpty() -> 리스트가 비어 있으면 true반환
		if(!back.isEmpty()){
			foward.push(currentURL);	// 현재 페이지를 foward스택에 추가
			currentURL = back.pop();	// back스택에서 1개의 요소를 꺼내와 현재 페이지로 지정
		}
		
	}
	
	// 앞으로 가기 기능 구현할 메서드
	public void goFoward(){
		if(!foward.isEmpty()){
			back.push(currentURL);
			currentURL = foward.pop();
		}
	}
	
	// 방문 기록 확인하기
	public void history(){
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println("        방    문    기    록                  ");
		System.out.println("-----------------------------");
		System.out.println("back => " + back);
		System.out.println("현재 => " + currentURL);
		System.out.println("foward => " + foward);
		System.out.println("-----------------------------");
		System.out.println();
	
	}
	
}














