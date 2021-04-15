package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThreadHorse {

	public static void main(String[] args) {
		
		List<Horse2> horse = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++){
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
		
		for(int i = 0; i < 50; i++){
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
				System.out.print(horse.get(i).getHName() + " : ");
				for(int j = 0; j < 50; j++){
					if(horse.get(i).getNow() == j)
						System.out.print(">");
					else
						System.out.print("-");
				}
				if(horse.get(i).getRank() == 0)
					System.out.println(" 현재 위치 : " + horse.get(i).getNow());
				else
					System.out.println(" 현재 위치 : " + horse.get(i).getNow() + " 등수 : " + horse.get(i).getRank());
					
				System.out.println();
			}
			
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















