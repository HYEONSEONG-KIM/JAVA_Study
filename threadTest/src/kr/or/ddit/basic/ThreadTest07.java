package kr.or.ddit.basic;

import javax.swing.JOptionPane;

/*
 * 	컴퓨터와 가위 바위 보를 진행하는 프로그램 작성
 * 
 * 	컴퓨터의 가위 바위 보는 난수를 이용하여 구하고
 *	사용자의 입력은 showInputDialog()메서드를 이용해서 입력
 *	입력 시간은 5초로 제한, 카운트 다운을 진핸
 *	5초 동안 입력이 없으면 게임에 진것으로 처리
 *	5초 안에 입력이 완료되면 승패를 구해서 결과를 출력
 *
 *	결과 예시) 
 *	- 5초 안에 입력을 못했을 경우
 *	-- 결 과 --
 *	시간초과로 당신이 졌습니다.
 *
 *	- 5초안에 입력을 했을 경우
 *	-- 결  과 --
 *	컴퓨터 : 가위
 *	사용자 : 바위
 *	결 과   : 당신이 이겼습니다. 		
 *		
 * 
 */
public class ThreadTest07 {
	
	public static String comRPS  = "";
	public static String  myRPS = "";

	
	public static void main(String[] args) {
		
		ThreadTest07 th = new ThreadTest07();
		th.start();
	}

	
	private void start() {
		
		Thread input = new inputRPS();
		Thread count = new CountDown();
		
		setRPS();
		input.start();
	
		count.start();
		
		try {
			input.join();
			count.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		check();
	}

	//승패여부
	private void check() {
		
		 String result = "";
		
		if(comRPS.equals(myRPS)){
			result= "비겼습니다";
		}else if(comRPS.equals("바위")){
			
			if(myRPS.equals("가위")){
				result = "당신이 졌습니다";
			}else if(myRPS.equals("보")){
				result = "당신이 이겼습니다";
			}
			
		}else if(comRPS.equals("가위")){
			
			if(myRPS.equals("보")){
				result = "당신이 졌습니다";
			}else if(myRPS.equals("바위")){
				result = "당신이 이겼습니다";
			}
			
		}else if(comRPS.equals("보")){
			
			if(myRPS.equals("바위")){
				result = "당신이 졌습니다";
			}else if(myRPS.equals("가위")){
				result = "당신이 이겼습니다";
			}
			
		}
		
		System.out.println("------- 결 과 -------");
		System.out.println("컴퓨터 : " + comRPS);
		System.out.println("사용자 : " + myRPS);
		System.out.println("결  과  : " + result);
		
	}
	
	//컴퓨터 가위 바위 보 생성
	private void setRPS() {
		
		String[] ran = new String[]{"가위","바위","보"};
		
		int ranNum = (int)(Math.random() * 3);
		comRPS = ran[ranNum];
	}

}

//입력 받는 쓰레드
class inputRPS extends Thread{
	
	public static boolean flag = false;
	
	
	@Override
	public void run() {
		String input = "";
		do{
			input = JOptionPane.showInputDialog("가위 바위 보!!!");
		}
		while(input == null ||!input.equals("바위") && !input.endsWith("가위") && !input.equals("보") );
		
		flag = true;
		ThreadTest07.myRPS = input;
	}
	
}

//카운트 다운 쓰레드
class CountDown extends Thread{
	
	@Override
	public void run() {
		
		for(int i = 5; i > 0; i--){
			
			if(inputRPS.flag){
				return;
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("시간초과로 당신이 졌습니다");
		System.exit(0);
	}
	
}











