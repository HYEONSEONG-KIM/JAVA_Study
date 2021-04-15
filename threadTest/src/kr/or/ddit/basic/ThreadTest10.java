package kr.or.ddit.basic;

/*
 * yield()메서드 연습
 */
public class ThreadTest10 {

	public static void main(String[] args) {
		
		YieldThread th1 = new YieldThread("1번 쓰레드");
		YieldThread th2 = new YieldThread("2번 쓰레드");
		
		th1.start();
		th2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("--------------------------------1111111111111111");
		
		th1.work = false;
	
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("-----------------------------------------222222222222222222");
		th1.work = true;

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		System.out.println("-----------------------------------------333333333333333333333333333");
		th1.stop = true;
		th2.stop = true;
	
	}

}

//yield()메서드 연습용 쓰레드
class YieldThread extends Thread{
	
	public boolean stop = false;	// 쓰레드의 종료여부를 나타내는 변수
	public boolean work = true;		// 작업의 처리 여부를 나타내는 변수
	
	public YieldThread(String name) {
		super(name);	// 쓰레드의 이름을 설정
	}
	
	@Override
	public void run() {
		while(!stop){	// stop이 true가 되면 반복문이 종료
			if(work){
				// getName() => 쓰레드에 설정된 쓰레드의 이름을 반환
				System.out.println(getName() + "작업 중...");
			}else{
				System.out.println(getName() + "양보...");
				Thread.yield();
			}
		}
		System.out.println(getName() + "쓰레드 종료...");
	}
	
}












