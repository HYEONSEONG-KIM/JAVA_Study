package kr.or.ddit.basic;


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


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadHorse {

	public static void main(String[] args) {
		
		List<Horse2> horse = new ArrayList<>();
		
		for(int i = 1; i <= 20; i++){
			String name = i + "번마";
			horse.add(new Horse2(name));
		}
		
		PrintNow print = new PrintNow(horse);
		
		for(Horse2 hs : horse){
			hs.start();
		}
		
		print.start();
		
		for(Horse2 hs : horse){
			try {
				hs.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Horse2.flag = true;
		
		print.rankCheck();
		
		
	}

}


class Horse2 extends Thread implements Comparable<Horse2>{
	
	public static boolean flag = false;
	public static int allRank = 1;
	private String hName;
	private int rank;
	private int now;
	
	public Horse2(String hName){
		this.hName = hName;
	}
	
	
	@Override
	public void run() {
		
		for(int i = 1; i <= 50; i++){
			now = i;
			int ran = (int)(Math.random() * 1000);
			try {
				Thread.sleep(ran);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		rank = allRank;
		allRank++;
	}
	
	
	
	
	public static int getAllRank() {
		return allRank;
	}
	public static void setAllRank(int allRank) {
		Horse2.allRank = allRank;
	}
	public String getHName() {
		return hName;
	}
	public void setHName(String name) {
		this.hName = hName;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getNow() {
		return now;
	}
	public void setNow(int now) {
		this.now = now;
	}


	@Override
	public int compareTo(Horse2 o) {
		if(rank > o.rank){
			return 1;
		}else
		return -1;
	}
	
	
}




class PrintNow extends Thread{
	
	List<Horse2> horse;
	
	public PrintNow(List<Horse2> horse) {
		this.horse = horse;
	}
	
	@Override
	public void run() {
		
		while(!Horse2.flag){
			System.out.println("************현재 상황************");
			for(int i = 0; i < horse.size(); i++){
				System.out.print(horse.get(i).getHName() + "\t: ");
				for(int j = 1; j <= 50; j++){
					if(horse.get(i).getNow() == j)
						System.out.print("🐴");
					else
						System.out.print("-");
				}
				if(horse.get(i).getRank() == 0)
					System.out.println(" 현재 위치 : " + horse.get(i).getNow());
				else
					System.out.println(" 현재 위치 : " + horse.get(i).getNow() + " 등수 : " + horse.get(i).getRank());
					
			}
			System.out.println();
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void rankCheck(){
		
		Collections.sort(horse);
		
		for(int i = 0; i < horse.size(); i++){
			System.out.println((i+1) + "등 : " + horse.get(i).getHName());
		}
		
	}
	
	
}















