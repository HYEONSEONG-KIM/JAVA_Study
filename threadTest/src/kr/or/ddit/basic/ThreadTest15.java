package kr.or.ddit.basic;

public class ThreadTest15 {
	
	public static void main(String[] args) {
		
		ShareObject sObj = new ShareObject();
		TestThread th1 = new TestThread("test1", sObj);
		TestThread th2 = new TestThread("test2", sObj);
	
		
		th1.start();
	
		th2.start();

	}
	
}


class ShareObject{
	
	private int sum = 0;
	
	
	//public synchronized void add(){	// 동기화 처리 방법1 => 메서드에 동기화 설정을 함
	public void add(){
		
		synchronized (this) {	// 동기화 처리 방법2 => 동기화 블럭으로 설정
			int n = sum;
			
			n += 10;
			
			sum = n;
			
			System.out.println(Thread.currentThread().getName() + " 합계 : " + sum );	
		}
		
	}
	
	
}

class TestThread extends Thread{
	
	private ShareObject sObj;
	
	public TestThread(String name, ShareObject sObj) {
		super(name); //쓰레드 이름 설정
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			sObj.add();
			
		}
	}
	
}

















