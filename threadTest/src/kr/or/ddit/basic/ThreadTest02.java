package kr.or.ddit.basic;

public class ThreadTest02 {
	
	//최종적으로 쓰레드 3개(메인, 생성한 쓰레드 2개)
	public static void main(String[] args) {
		
		//멀티 쓰레드 프로그램 => 모든 쓰레드가 끝나야 프로그램이 종료
		
		/*
		 * 	- 프로세스에서 쓰레드가 실행되고 소멸하는 과정
		 *	생성(New) -> 실행대기(Runnable) -> 실행 -> (일시정지(Waiting, Blocked)) -> 소멸
		 *	=> 멀티쓰레드의 의미는 동시에 쓰레드가 실행하다는 의미가 아닌 하나의 프로세스에서 여러개의 쓰레드가 생성되고 소멸된다는 의미
		 *	=> 실제 실행은 한개의 쓰레드만 실행이 되며  각 쓰레드 마다 일정 시간을 주어 실행 되도록 처리, 해당 쓰레드의 run 메서드 실행이 끝나지 않았어도
		 *		일정 시간이 되면 해당 쓰레드는 일시정지 -> 대기 상태로 넘어가며, 다음 쓰레드가 실행(cpu의 속도는 상당히 빠르므로 여러개의 쓰레드가 동시에 일어나는 것 처럼 보임)  
		 */
		
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



























