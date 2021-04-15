package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 	10마리의 말들이 경주하는 프로그램 작성
 * 
 * 	말은 Horse라는 이름으로 쓰레드 클래스로 작성하는데, 
 * 	이 클래스는 말이름(String), 현재위치(int), 등수(int)를 멤버변수로 갖음
 * 
 * 	그리고, 이 클래스에는 등수를 오름차순으로 처리할 수 있는 내부 정렬 기준이 있음(Comparable 인터페이스 구현)
 * 
 * 	경기 구간은 1 ~ 50 구간으로 되어 있음
 * 
 * 	경기 중간 중간에 각 말들의 위치를 아래와 같이 나타냄
 * 	ex)
 * 	01번말 : --->--------------------
 * 	02번말 : ------->----------------
 * 	03번말 : ----->------------------
 * 	04번말 : ------------>-----------
 * 	....
 * 	10번말 : --------->--------------
 * 
 * 	경기가 끝나면 등수 순으로 출력
 */

public class ThreadTest13 {

	public static void main(String[] args) {
		
		/*List<Horse> horseList = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++){
			String name = i + "번말";
			horseList.add(new Horse(name));
		}
		*/
		Horse[] horse = new Horse[]{
			new	Horse("1번말"),
			new	Horse("2번말"),
			new	Horse("3번말"),
			new	Horse("4번말"),
			new	Horse("5번말"),
			new	Horse("6번말"),
			new	Horse("7번말"),
			new	Horse("8번말"),
			new	Horse("9번말"),
			new	Horse("10번말")
		};
		
		print p = new print(horse);
		
		for(Horse h : horse){
			h.start();
		}
		p.start();
		
		for(Horse h : horse){
			try {
				h.join();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		Horse.check = true;
		
		Arrays.sort(horse);
		System.out.println("==========결 과==========");
		for(int i = 0; i < horse.length; i++){
			System.out.println((i+1)  + "등 : " + horse[i].name);
		}
		
	}

}


class Horse extends Thread implements Comparable<Horse>{
	
	public static boolean check = false;
	public static int allRank = 1;
	int rank;
	String name;
	int now;
	


	public Horse(String name) {
		this.name = name;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 50; i++){
			now = i;
			int ran = (int)(Math.random() * 500);
			
			try {
				Thread.sleep(ran);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rank = allRank;
		allRank++;
	}
	
	
	@Override
	public int compareTo(Horse o) {
		if(rank > o.rank){
			return 1;
		}else
		return -1;
	}
	
}


class print extends Thread{
	
	Horse[] horse;
	
	public print(Horse[] horse){
		this.horse = horse;
	}
	
	@Override
	public void run() {
		
		while(true){
			
			System.out.println("*********현재 진행 상황************");
			for(int i = 0; i < horse.length; i++){
				int now = 0;
				System.out.print(horse[i].name + " : ");
				for(int j = 1; j <= 50; j ++){
					now = horse[i].now;
					if(now == j){
						System.out.print(">");
					}else{
						System.out.print("-");
					}
				}
				if(horse[i].rank == 0){
				System.out.print(" " +horse[i].now + "구간 통과중");
				System.out.println();
				}else{
					System.out.print(" " +horse[i].now + "구간 통과중, " + horse[i].rank + "등");
					System.out.println();
				}
				
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			if(Horse.check)
				break;
			System.out.println();
			System.out.println("===========================================");
			System.out.println();
		}
	}
	
}












