package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListSortTest01 {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");

		System.out.println("정렬 전 : " + list);
		
		// 정렬(sort)은 collections.sort() 메서드를 이용하여 정렬
		// Collections.sort() 메서드는 기본적으로 내부 정렬 기준으로 정렬
		// 문자열은 내부 정렬 기준이 오름차순
		Collections.sort(list);
		System.out.println("정렬 후 : " + list);
		
		Collections.shuffle(list);
		System.out.println("셔플 후 : " + list);
		
		// 외부 정렬 기준을 지정해서 정렬
		Collections.sort(list, new Desc());	//외부 정렬 기준 클래스의 인스턴스를 인수 값으로 넣어 줌
		System.out.println("내림차순 정렬 후 : " + list);
		
		
	}

}

/*
 * 	정렬과 관련된 interface는 Comparable, Comparator 두 가지
 * - Comparable => Collection에 추가되는 데이터 자체에 정렬 기준을 넣고 싶을 때(내부 정렬 기준) 구현하는 인터페이스
 * - Comparator => 외부에 별도로 정렬 기준을 구현하고 싶을 때(외부 정렬 기준) 구현하는 인터페이스
 * - Comparable에서는 compareTo() 메서드를 재정의
 * - Comparator에서는 compare() 메서드를 재정의
 * 
 * - String클래스, Wrapper클래스, Date클래스, File클래스에는 내부 정렬 기준이 구현
 * 	(내부 정렬 기준은 기본적으로 오름차순으로 처리되도록 구현)
 * 
 */


//정렬 방식을 정해주는 class 작성(외부 정렬 기준 클래스) => Comparator 인터페이스 구현해서 작성
class Desc implements Comparator<String>{

	//compare() 메서드를 이용해서 정렬하고자 하는 기준을 정함 -> 매개변수는 서로 인접한 데이터라고 생각하면 됨
	//반환값  0(두 값이 같음), 양수(앞, 뒤 값의 순서를 바꿈), 음수(앞 뒤값 순서를 바꾸지 않음)
	
	//ex) 오름차순일 경우 => 앞의 값이 크면 양수를, 같으면0, 앞의 값이 작으면 음수를 반환
	@Override
	public int compare(String str1, String str2) {
		//내림차순으로 정렬되도록 구현
		//String 내부 정렬 기준으로 앞 뒤 값 비교 후 앞의 값이 더 크면 양수를 반환 (앞의 값이 크다는 의미는 내림차순의 의미와 일맥상통)
		if(str1.compareTo(str2) > 0){
			return -1;
		}else if(str1.compareTo(str2) < 0){
			return 1;
		}else{
			return 0;
		}
	}
	
}










