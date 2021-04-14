package kr.or.ddit.basic;

import java.awt.im.InputContext;

import javax.swing.JOptionPane;

public class ThreadTest06 {

	public static void main(String[] args) {
		
		Thread th1 = new DataInput();
		Thread th2 = new MyCountDown();
		
		th1.start();
		th2.start();
		
	}

}


// 데이터를 입력하는 쓰레드
class DataInput extends Thread{
	//입력 여부를 확인하기 위한 변수
	public static boolean inputcheck = false;
	
	@Override
	public void run() {
		String str = JOptionPane.showInputDialog("아무거나 입력하세요");
		inputcheck = true;
		System.out.println("입력값 : " + str);
	}
}


// 카운트 다운을 진행하는 쓰레드
class MyCountDown extends Thread{
	
	@Override
	public void run() {
		for(int i = 10; i > 0; i--){
			
			if(DataInput.inputcheck){
				return;
			}
			System.out.println(i);
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("10초가 지났습니다. 프로그램을 종료합니다");
		System.exit(0);
	}
}