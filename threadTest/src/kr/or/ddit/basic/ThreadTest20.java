package kr.or.ddit.basic;

public class ThreadTest20 {

	public static void main(String[] args) {
		
		DataBox databox = new DataBox();
		
		InputThread th1 = new InputThread(databox);
		OutputThread th2 = new OutputThread(databox);
		
		th1.start();
		th2.start();
		
	}

}


// 공통 클래스
class DataBox{
	
	private String data;
	
	// 데이터를 가져가는 메서드
	// => data변수의 값이 null이면 data변수에 문자열이 채워질때까지 기다리고,
	//	data변수에 값이 있으면 해당 문자열을 반환
	//	data변수 값을 반환했으면 변수값을 null로 초기화
	public synchronized String getDate(){
		
		if(data == null){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		String returnData = data;
		System.out.println("쓰레드가 읽은 데이터 : " + returnData);
	
		data = null;
		
		notify();
		return returnData;
	}
	
	// 데이터를 셋팅하는 메서드
	// this.data변수에 값이 있으면 this.data변수값이 null이 될때까지 기다림
	// this.data변수 값이 null이 되면 새로운 값을 this.data변수에 저장
	public synchronized void setData(String data){ //매개변수 data에는 새롭게 셋팅할 문자열이 들어있음
		if(this.data != null){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// this.data변수 값이 null이 되면 실행되는 구간
		this.data = data;
		System.out.println("Thread에서 새롭게 저장한 데이터 : " + data);
		
		notify();
	}
	
}

// 데이터를 넣어주는 쓰레드
class InputThread extends Thread{
	private DataBox databox;
	
	public InputThread(DataBox databox){
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <=3; i++){
			databox.setData("공급 데이터 " + i);
		}
	}
	
}

// 데이터를 꺼내서 사용하는 쓰레드
class OutputThread extends Thread{
	private DataBox databox;
	
	public OutputThread(DataBox databox){
		this.databox = databox;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 3; i++){
			String data = databox.getDate();
			// 이 부분에 가져온 데이터를 사용하는 코드를 기술
		}
	}
	
}




















