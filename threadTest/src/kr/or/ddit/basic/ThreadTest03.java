package kr.or.ddit.basic;

public class ThreadTest03 {

	public static void main(String[] args) {

		// 쓰레드가 수행되는 시간 체크
		Thread th = new Thread(new MyRunner());
		
		//1970년 1월1일 0시 0분 0초(표준시간)로 부터 경과한 시간을 밀리세컨드 단위로 반환
		long startTime = System.currentTimeMillis();
		
		th.start();
		
		try {
			th.join();  //현재 실행중인 쓰레드(main)에서 대상이되는 쓰레드 (변수 th쓰레드)가 종료될 때까지 기다림
		} catch (InterruptedException e) {
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("경과 시간 : " + (endTime - startTime));
	}

}

class MyRunner implements Runnable{
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = 1; i <= 1000000000L; i++ ){
			sum += i;
		}
		System.out.println("합계 : " + sum);
		
	}
}