package kr.or.ddit.basic;

public class ThreadTest02 {
	
	//최종적으로 쓰레드 3개(메인, 생성한 쓰레드 2개)
	public static void main(String[] args) {
		
		//멀티 쓰레드 프로그램 => 모든 쓰레드가 끝나야 프로그램이 종료
		
		//Thread를 작성해서 사용하는 방법
		
		//방법1 : Thread클래스를 상속한 class작성한 후 이 class의 인스턴스를 생성한 후
		//		이 인스턴스의 start()메서드를 호출해서 실행
		
		//start()는 main위에 생성후 쓰레드 환경을 만들고(새로운 stack영역생성) 그환경에 run이라는 메서드를 생성 후 사라짐
		MyThread1 th1 = new MyThread1();
		th1.start();
		
		//방법2 : Runnable 인터페이스를 구현한 class를 작성한 후 이 class의 인스턴스를 생성하여 
		//		Thread의 인스턴스를 생성할 때 생성자의 인수값으로 넣어줌
		//		이 때 생성된 Thread의 인스턴스의 start()메서드를 호출해서 실행
		MyThread2 r2 = new MyThread2();
		Thread th2 = new Thread(r2);
		th2.start();
		
		//방법3 : 익명구현체를 이용하는 방법
		Runnable r3 = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 200; i++){
					System.out.print("@");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
					}
				}
			}
		};
		Thread th3 = new Thread(r3);
		th3.start();
		System.out.println("main메서드 끝");
		
		
	}

}

//방법 1 -> Thread를 상속한 class를 작성
class MyThread1 extends Thread{
	
	@Override
	public void run() {
		// 이 run()메서드 안에 쓰레드에서 처리할 내용을 기술
		
		for(int i = 1; i <= 200; i++){
			System.out.print("*");
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				
			}
		}
	}
}

//방법2 -> Runnable 인터페이스를 구현한 class를 작성
class MyThread2 implements Runnable{

	@Override
	public void run() {

		// 이 run()메서드 안에 쓰레드에서 처리할 내용을 기술
		
		for(int i = 1; i <= 200; i++){
			System.out.print("$");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}



























