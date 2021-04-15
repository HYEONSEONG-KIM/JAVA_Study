package kr.or.ddit.basic;

/*
 * 쓰레드의 상태를 출력하는 예제
 */

public class ThreadTest09 {

	public static void main(String[] args) {

		StatePrintThread th = new StatePrintThread(new TargerThread());
	
		th.start();
	}

}

// 쓰레드 상태의 검사 대상이 되는 쓰레드
class TargerThread extends Thread{
	
	@Override
	public void run() {
		for(long i = 1L; i <= 20_000_000_000L; i++){} // 시간 지연용
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
			
			}
		for(long i = 1L; i <= 20_000_000_000L; i++){} // 시간 지연용
	}
}


// 검사 대상의 쓰레드의 상태를 출력하는 쓰레드
class StatePrintThread extends Thread{
	private TargerThread target;
	
	// 생성자
	public StatePrintThread(TargerThread target){
		this.target = target;
	}
	
	@Override
	public void run() {
		while(true){
			
			// 쓰레드의 현재 상태값 구하기
			Thread.State state = target.getState();
			System.out.println("TargetThread의 현재 상태값 : " + state);
			
			if(state == Thread.State.NEW){
				target.start();
			}
			
			if(state == Thread.State.TERMINATED){
				break;
			}
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}










