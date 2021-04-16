package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/*
 *	Vector, Hashtable등의 예전부터 존재하던 Collection객체들은 내부에 동기화 처리가 되어 있음
 *
 * 	하지만, 새로 구성된 다른 Collection객체들은 동기화 처리가 되어 있지 않음
 * 	그래서, 동기화가 필요한 프로그램에서는 이런 Collection 객체들을 사용하려면 동기화 처리를 한 후에 사용해야 함
 */

public class ThreadTest18 {

	private static Vector<Integer> vec = new Vector<>();
	
	// 동기화 처리를 하지 않은 경우
	private static List<Integer> list1 = new ArrayList<>();
	// 동기화 처리를 하는 경우
	private static List<Integer> list2 = 
			Collections.synchronizedList(new ArrayList<Integer>());
	
	
	
	public static void main(String[] args) {
		// 익명 구현체로 쓰레드 구현
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10000; i++){
//					vec.add(i);
//					list1.add(i);
					list2.add(i);
				}
			}
		};
		
		Thread[] ths = new Thread[]{
			new Thread(r),	
			new Thread(r),	
			new Thread(r),	
			new Thread(r),	
			new Thread(r)
		};
		
		for(Thread th : ths){
			th.start();
		}
		
		for(Thread th : ths){
			try {
				th.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
//		System.out.println("vec의 개수 : " + vec.size());
		System.out.println("list의 개수 : " + list2.size());
		
	}

}














