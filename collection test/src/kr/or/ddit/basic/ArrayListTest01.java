package kr.or.ddit.basic;

import java.util.ArrayList;

public class ArrayListTest01 {

	public static void main(String[] args) {
		
		//ArrayList는 기본적인 사용법이 Vector와 같음
		
		ArrayList list1 = new ArrayList<>();
		
		//add()메서드로 데이터를 추가
		list1.add("aaa");
		list1.add(123);
		list1.add('k');
		list1.add(false);
		list1.add(123.45);
		list1.add("bbb");
		
		System.out.println("list1 => " + list1);
		System.out.println("size => " + list1.size());
		
		//get() 메서드로 데이터 가져옴
		System.out.println("1번째 자료 : " + list1.get(1));
		
		//데이터 끼어 넣어도 같음
		list1.add(3, "zzz");
		System.out.println("list1 => " + list1);
		
		//데이터 변경하기
		String temp = (String)list1.set(3, "YYY");
		System.out.println("list1 => " + list1);
		System.out.println(temp);
		
		//삭제
		temp = (String)list1.remove(3);
		System.out.println("list1 => " + list1);
		System.out.println(temp);
		
		list1.remove("bbb");
		System.out.println("list1 => " + list1);

		System.out.println("-----------------------------------------");
		//제네릭 사용가능
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("aaaa");
		list2.add("bbbb");
		list2.add("cccc");
		list2.add("dddd");
		list2.add("eeee");
		
		for(int i = 0; i < list2.size(); i++){
			System.out.println(list2.get(i));
		}
		
		System.out.println("-----------------------------------------");
		for(String str : list2){
			System.out.println(str);
		}
		System.out.println("-----------------------------------------");

		//contains(비교데이터) -> List에 '비교데이터'가 있으면 true, 없으면 false 반환
		System.out.println("dddd값 : " + list2.contains("dddd"));
		System.out.println("ffff값 : " + list2.contains("ffff"));
		
		//indexOf(비교데이터) -> List에 비교데이터가 있으면 비교데이터가 있는 인덱스 반환, 없으면 -1 반환
		System.out.println("dddd값 : " + list2.indexOf("dddd"));
		System.out.println("ffff값 : " + list2.indexOf("ffff"));
		
		//toArray() -> List안의 데이터를 배열로 변화하여 반환 , 기본적으로 Object형 배열로 반환
		//toArray(new 제네릭타입[0]) -> 제네릭타입의 배열로 변환
		Object[] str = list2.toArray();
		System.out.println("str의 갯수 : " + str.length);
		
		for(int i = 0; i < str.length; i++){
			System.out.println(str[i]);
		}
		
		String[] str2 = list2.toArray(new String[0]);
		
		
		for(String str3 : str2){
			System.out.println(str3);
		}
		
		
	}

}













