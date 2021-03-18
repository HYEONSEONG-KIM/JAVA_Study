package j_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

public class HashMapClass {

	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환
		 * Set ketSet() : 저장된 모든 키를 Set으로 반환
		 */
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("a", 10);
		map.put("b", "홍길동");
		map.put("c", new Date());
		
		System.out.println(map);
		
		map.put("b", "이순신");
		
		System.out.println(map);
		
		map.remove("a");
		
		System.out.println(map);
		
		Object object = map.get("b");
		System.out.println(object);
		
		String value2 = (String)map.get("b");
		
		Set<String> keys = map.keySet();
		
		for(String key : keys){
			System.out.println(key + " : " + map.get(key));
		} // :을 기준으로 오른쪽은 꺼낼값, 왼쪽은 담을 값 
		//Set으로 map에 저장된 키값이 저장된 keys -> keys을 하나씩 key에 저장(keys가 없을때까지 반복)
		
		System.out.println(keys);
		
		
		
		//회원 테이블
		//아이디, 비밀번호, 이름, 전화번호
		HashMap<String,String> user = new HashMap<>();
		user.put("id","admin");
		user.put("password","admin123");
		user.put("name", "관리자");
		user.put("tel", "010-1234-1234");
		
		System.out.println(user);
		
		//회원 1명의 데이터가 담긴 HashMap을 하나 더 생성
		HashMap<String,String> user2 = new HashMap<>();
		user2.put("id","asdf");
		user2.put("password","asdf123");
		user2.put("name", "qwe");
		user2.put("tel", "010-5678-1234");
		
		ArrayList<HashMap<String, String>> table = new ArrayList<>();
		
		table.add(user);
		table.add(user2);
		System.out.println(table);
		
		/*HashMap<String,Object> users = new HashMap<>();
		users.put("회원1", user);
		users.put("회원2", user2);
		
		System.out.println(users);*/
		
		
		//ArrayListd와 HashMap을 사용해 데이터베이스에 있는 임의의 테이블을 저장
		ArrayList<HashMap<String,String>> student = new ArrayList<>();
		
		HashMap<String,String> std = new HashMap<>();
		std.put("STUD_NO", "2021020001");
		std.put("STUD_NAME", "홍길동");
		std.put("STUD_DEP", "404");
		student.add(std);
		
		std = new HashMap<>();
		std.put("STUD_NO", "2021020002");
		std.put("STUD_NAME", "이순신");
		std.put("STUD_DEP", "402");
		student.add(std);
		
		std = new HashMap<>();
		std.put("STUD_NO", "2021020003");
		std.put("STUD_NAME", "김유신");
		std.put("STUD_DEP", "401");
		student.add(std);
		
		System.out.println(student);
		
		keys = student.get(1).keySet();
		System.out.println(keys);
		System.out.println(student.get(1).get("STUD_NO"));
		
	}

}


































