package kr.or.ddit.basic;

/*
 * 	은행의 입출금을 쓰레드로 처리하는 예제
 * 	(synchronized를 이용한 동기화 처리 예제)
 */

public class ThreadTest16 {

	private int balance;	//잔액
	
	public void setBalance(int balance){
		this.balance = balance;
	}
	
	public synchronized int getBalance(){
		return balance;
	}
	
	// 입금하는 메서드
	public synchronized void deposit(int money){
		balance += money;
	}
	
	// 출금하는 메서드(출금 성공하면 true반환, 실패하면 false반환)
	// 동기화 영역에서 호출하는 메서드도 동기화 처리를 해주어야 함
	public synchronized boolean withdraw(int money){
		
		if(balance >= money){
			for(int i = 1; i <= 10000000; i++){} //시간 지연용
			balance -= money;
			System.out.println("메서드 안에서 balance = " + balance);
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		final ThreadTest16 acount = new ThreadTest16();
		acount.setBalance(10000); //잔액 10000원으로 초기화
		
		// 익명 구현체로 쓰레드 구현
		
		Runnable test = new Runnable() {
			
			@Override
			public void run() {
				boolean result = acount.withdraw(6000);	//6000원 출금
				System.out.println("쓰레드에서 출금여부result = " + result + ", balance = " + acount.getBalance());
				
			}
		};
		//---------------------------------
		Thread th1 = new Thread(test);
		Thread th2 = new Thread(test);
		
		th1.start();
		th2.start();
	}

}


















