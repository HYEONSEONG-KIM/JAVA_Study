package kr.or.ddit.basic;

/*
 *	wait()메서드와 notify()메서드를 이용해서 두 쓰레드가 번갈아 한번씩 실행되는 예제
 *	-> wait(), notify(), notufyAll() 메서드는 동기화 영역에서만 사용 가능 
 */

public class ThreadTest19 {

	public static void main(String[] args) {

		WorkObject workObj = new WorkObject();
		ThreadA th1 = new ThreadA(workObj);
		ThreadB th2 = new ThreadB(workObj);
		
		th1.start();
		th2.start();
	}

}



// 공통으로 사용할 객체
class WorkObject{
	
	public synchronized void testMethod1(){
		System.out.println("testMethod1()메서드에서 실행중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
	}
	
	public synchronized void testMethod2(){
		System.out.println("testMethod2()메서드에서 실행중...");
		
		notify();
		
		try {
			wait();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
	}
}


// WorkObject의 testMethod1()메서드만 호출하는 쓰레드
class ThreadA extends Thread{
	
	private WorkObject workObj;
	
	public ThreadA(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++){
			workObj.testMethod1();
		}
		
		synchronized (workObj) {
			workObj.notify();
		}
	}
}

// WorkObject의 testMethod2()메서드만 호출하는 쓰레드
class ThreadB extends Thread{
	
	private WorkObject workObj;
	
	public ThreadB(WorkObject workObj) {
		this.workObj = workObj;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++){
			workObj.testMethod2();
		}
		synchronized (workObj) {
			workObj.notify();
		}
	}
}













