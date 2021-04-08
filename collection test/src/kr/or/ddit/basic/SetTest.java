package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SetTest {

	public static void main(String[] args) {
		/*
		 * 	List와 Set의 차이점
		 * 
		 * ● List
		 * 	- 데이터의 순서가 있음
		 * 	- 중복되는 데이터를 저장할 수 있음
		 * 
		 * ● Set
		 * 	- 데이터의 순서가 없음
		 * 	- 중복되는 데이터를 저장할 수 없음
		 */
			
		HashSet hs1 = new HashSet();
		
		//set에 데이터 추가 : add()
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("set의 데이터 개수 : " + hs1.size());
		System.out.println("set의 데이터 : " + hs1);
		
		// set에 중복되는 데이터를 추가하면 false 반환, 데이터는 추가 되지 않음
		boolean isAdd = hs1.add("FF");
		System.out.println("중복 되지 않을 때 : " + isAdd);
		System.out.println("set의 데이터 : " + hs1);
		isAdd = hs1.add("FF");
		System.out.println("중복 될 때 : " + isAdd);
		System.out.println("set의 데이터 : " + hs1);
		
		// set의 데이터를 수정하려면 수정하는 명령이 없으므로 해당 자료를 삭제한 후 새로운 데이터 추가

		// 삭제하는 메서드 : remove(삭제할 자료) => 반환값 : boolean
		// 전체 데이터 삭제 : clear()
		
		//"FF" 데이터를 "EE"로 변경하기
		
		hs1.remove("FF");
		hs1.add("EE");
		System.out.println("set의 데이터 : " + hs1);

//		hs1.clear();
//		System.out.println("set의 데이터 : " + hs1);
		
		/*
		 *  - set의 데이터는 순서가 없으므로 List처럼 index로 데이터를 하나씩 불러올 수 없음
		 *  - 데이터를 하나씩 얻기 위해서는 Iterator형 객체로 변환해야 함
		 *  - set형의 데이터를 Iterator형의 객체로 변환하는 메서드 => iterator()
		 */

		Iterator it = hs1.iterator();	//set데이터를 Iterator로 변환
		
		//Iterator의 hasNext()메서드 => Iterator에서 데이터를 가리키는 포인터가 현재 가리키는 곳의 다음 번째에 데이터가 잇으면 true반환, 없으면 false
		while(it.hasNext()){
			//Iterator의 next()메서드 => Iterator의 데이터를 가리키는 포인터를 다음 번째 위치로 이동시키고, 데이터를 가져옴
			System.out.println(it.next());
		}
		
		//향상된 for문
		for(Object ob : hs1){
			System.out.println(ob);
		}
		
		System.out.println("---------------------------------------------------------");
		System.out.println();
		
		// 우리반 학생들의 번호를 이용해서 추첨하는 프로그램을 작성
		// 번호는 1~22번 까지, 추첨할 인원은 3명
		// 당첨자를 출력(단, 중복 추첨은 안됨)
		
		// 최솟값 ~ 최댓값 사이의 난수
		// (int)(Math.random() * (최댓값 - 최솟값 + 1) + 최솟값)
		
		HashSet<Integer> testSet = new HashSet<>();
		
		while(testSet.size() < 3){
			int ran = (int)(Math.random() * 22) + 1;
			testSet.add(ran);
		}
		
		System.out.println(testSet);
		
		// Set 유형의 자료를 List형으로 변환
		ArrayList<Integer> testList = new ArrayList<>(testSet);
		System.out.println("List 데이터 : " + testList);
	}

}





















