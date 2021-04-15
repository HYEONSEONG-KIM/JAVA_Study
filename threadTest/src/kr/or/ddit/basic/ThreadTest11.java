package kr.or.ddit.basic;

/*
 * 	Thread의 stop()메서드를 호출하면 Thread가 바로 멈춤
 * 	이 때 사용하던 자원을 정리하지 못하고 프로그램이 종료되어 나중에 실행되는 프로그램에 영향을 줄 수 잇음
 * 	그래서 stop()메서드는 비사용 권고사항으로 되어있음
 */

public class ThreadTest11 {

	public static void main(String[] args) {
		
	/*	ThreadStopTest1 th1 = new ThreadStopTest1();
		
		th1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th1.setStop(true);
//		th1.stop();
*/		
		ThreadStopTest2 th2 = new ThreadStopTest2();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		th2.interrupt();
	
	}

}


// 쓰레드를 멈추게하는 연습용 쓰레드
class ThreadStopTest1 extends Thread{
	private boolean stop;
	
	public void setStop(boolean stop){
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop){
			System.out.println("쓰레드 실행 중...");
			
		}
		System.out.println("자원 정리...");
		System.out.println("쓰레드 종료...");
	}
}



// interrupt()메서드를 이용하여 쓰레드를 멈추게하는 방법
class ThreadStopTest2 extends Thread{
	
	@Override
	public void run() {
		// 방법1 => interrupt()메서드와 sleep()메서드를 이용하는 방법
		/*try {
			while(true){
				System.out.println("쓰레드 실행 중...");
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
		}*/
		
		// 방법2 
		while(true){
			System.out.println("Thread 실행 중...");
			
			// interrupt()메서드가 호출되었는지 검사
			
			// 검사 방법1 => 쓰레드의 인스턴스 메서드인 isInterrupted()메서드 이용
			//			isInterrupted()메서드는 interrupt()메서드가 호출되면 true 반환
			
			/*if(this.isInterrupted()){
				break;
			}*/
			
			// 검사 방법2 => 쓰레드의 정적(static) 메서드인 interrupted()메서드 이용
			//			이 메서드도 interrupt()메서드가 호출되면 true 반환
			if(Thread.interrupted()){
				break;
			}
		}
		
		System.out.println("자원 정리...");
		System.out.println("쓰레드 종료...");
	}
}






























