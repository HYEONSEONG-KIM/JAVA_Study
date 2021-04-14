package kr.or.ddit.basic;

/*
 *	1 ~ 20억까지의 합계를 구하는 프로그램은 하나의 쓰레드가 단독으로 처리할 때와 
 *	여러개의 쓰레드가 협력해서 처리할 때의 경과 시간을 비교 
 */
public class ThreadTest04 {

	public static void main(String[] args) {
		// 단독으로 처리하는 쓰레드
		SumThread sm = new SumThread(1L, 2_000_000_000L);
		
		//여럿이 협력해서 처리하는 쓰레드
		SumThread[] sumTh = new SumThread[]{
				new SumThread(1L, 500_000_000L),
				new SumThread(500_000_001L, 1_000_000_000L),
				new SumThread(1_000_000_001L, 1_500_000_000L),
				new SumThread(1_500_000_001L, 2_000_000_000L)
		};
		
		//단독으로 처리하는 쓰레드 실행
		long startTime = System.currentTimeMillis();
		sm.start();
		try {
			sm.join();
			
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단독으로 처리했을 때 경과 시간 : " + (endTime - startTime));
		
		System.out.println();
		System.out.println();
		
		//여러개의 쓰레드가 협력해서 처리하는 경우
		startTime = System.currentTimeMillis();
		
		for(int i = 0; i < sumTh.length; i++){
			sumTh[i].start();
			
		}
		
		for(SumThread sth : sumTh){
			try {
				sth.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("여러개의 쓰레드가 협력해서 처리했을 때 경과 시간 : " + (endTime - startTime));
	}

}


class SumThread extends Thread{
	// 합계를 구할 영역의 시작값과 종료값이 저장될 변수 선언
	private long start , end;
	
	// 생성자에서 시작값과 종료값 초기화
	public SumThread(long start, long end){
		this.start = start;
		this.end = end;
	}
	
	@Override
	public void run() {
		long sum = 0L;
		for(long i = start; i <= end; i++){
			sum += i;
		}
		
		System.out.println( start + " ~ " + end + " 까지의 합계 : " + sum);
	}
	
}