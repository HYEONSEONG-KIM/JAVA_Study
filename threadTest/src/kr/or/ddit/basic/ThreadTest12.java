package kr.or.ddit.basic;

/*
 *  3개의 쓰레드가 각각 알파벳을 A~Z까지 출력하는데, 출력을 끝낸 순서대로 결과를 나타내는 프로그램 작성
 */
public class ThreadTest12 {

	public static void main(String[] args) {
		
		DisplayCharacter[] threads = new DisplayCharacter[]{
			new DisplayCharacter("홍길동"),	
			new DisplayCharacter("이순신"),	
			new DisplayCharacter("강감찬")
		};
		
		for(DisplayCharacter th : threads){
			th.start();
		}
		
		for(DisplayCharacter th : threads){
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		System.out.println();
		System.out.println("경기 끝...");
		System.out.println("순위 : " + DisplayCharacter.rank);
	}

}


// A ~ Z까지 출력하는 쓰레드
class DisplayCharacter extends Thread{
	
	public static String rank = ""; //출력을 마친 순서대로 저장할 변수
	private String name;
	
	// 생성자
	public DisplayCharacter(String name){
		this.name = name;
	}
	
	@Override
	public void run() {
		for(char c = 'A'; c <= 'Z'; c++){
			System.out.println(name + "의 출력 문자 : " + c);
			int ran = (int)(Math.random()*300) + 201;
			try {
				Thread.sleep(ran);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name + " 출력 끝...");

		//출력을 끝낸 순서대로 이름을 배치
		DisplayCharacter.rank += name + "   ";
	}
	
}























