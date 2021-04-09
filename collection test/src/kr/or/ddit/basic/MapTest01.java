package kr.or.ddit.basic;

import java.awt.RenderingHints.Key;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapTest01 {
	
	public static void main(String[] args) {
		/*
		 * 	Map : key값, value값을 한 쌍으로 관리하는 객체
		 * 	- key값은 중복을 허용하지 않고, 순서가 없음(Set의 특징)
		 * 	- value값은 중복을 허용
		 */
		
		HashMap<String, String> map = new HashMap<>();
		
		//자료 추가 : put(key, value)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map : " + map);
		
		// 자료 수정 : 데이터를 추가할 때 key이 값으면 나중에 입력한 값으로 덮어 써줌
		map.put("addr", "서울");
		System.out.println("map : " + map);
		
		//자료 삭제 : remove(key값) -> 반환값 : 삭제된 자료의 value값
		/*String temp = map.remove("tel");
		System.out.println("삭제 후 map : " + map);
		System.out.println(temp);
		*/
		
		// 자료 읽기 : get(key값) -> key값이 없으면 null 반환
		System.out.println("이름 : " + map.get("name"));
		System.out.println("나이 : " + map.get("age"));
		System.out.println();
		
		// key값이 Map에 존재하는지 여부를 나타내는 메서드 : containsKey(Key값) -> 반환값 : boolean
		System.out.println("tel 키값의 존재여부 : " + map.containsKey("tel"));
		System.out.println("age 키값의 존재여부 : " + map.containsKey("age"));
		System.out.println("-------------------------------------------------------");
		System.out.println();
		
		
		// Map에 저장된 모든 데이터를 차례로 가져와 처리하는 방법
		
		// 방법1 : Map에 저장된 모든 Key값을 읽어와 처리하기 -> KeySet()메서드 이용 => Map의 모든 Key값들을 읽어와 Set형으로 반환
		Set<String> KeySet = map.keySet();
		
		// 방법 1-1 : Iterator 이용
		Iterator<String> KeyIt = KeySet.iterator();
		
		while(KeyIt.hasNext()){
			String Key = KeyIt.next();
			String value = map.get(Key);
			System.out.println(Key + " : " + value);
		}
		System.out.println("==============================================================");
		
		//방법 1-2 : 향상된 for문
		for(String key : KeySet){
			String value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("==============================================================");
		//방법2 : value값만 읽어와 처리 => Values() 메서드 이용
		for(String value : map.values()){
			System.out.println(value);
		}
		System.out.println("==============================================================");
		
		
		//	Map에는 Entry라는 내부 class가 만들어져 있음 -> Entry 클래스는 Key변수와 Value변수로 구성
		//	Map에서는 Entry클래스의 인스턴스에 데이터를 저장하고 이 Entry인스턴스를 Set형식으로 저장하여 관리
		
		// 방법3 : Map의 내부에 있는 Entry객체 전체를 가져와 처리, EntrySet()메서드를 이용
		//		가져온 Entry들은 Set형
		
		// Entry라는 내부객체 전체 가져오기
		Set<Map.Entry<String, String>> mapSet = map.entrySet();
		
		Iterator<Map.Entry<String, String>> entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()){
			Map.Entry<String, String> entry = entryIt.next();
			System.out.println("Key값 :" + entry.getKey());
			System.out.println("value값 :" + entry.getValue());
			System.out.println();
		}
		
		
		
	}
}















































