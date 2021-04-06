package kr.or.ddit.basic;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {

		//객체 생성
		Vector v1 = new Vector<>();
		
		System.out.println("처음 크기: " + v1.size());
		
		//데이터 추가1 => add(추가할 데이터)
		//반환타입 => boolean
		v1.add("aaaaa");
		//자동으로 데이터를 객체화 -> AutoBoxing
		v1.add(123);
		v1.add('a');
		v1.add(true);
		boolean r = v1.add(3.14);
		
		System.out.println(r);
		System.out.println("현재 크기 : " + v1.size());
		
		//데이터 추가2 => addElmenemt(추가할 데이터)
		//이전 버전의 프로그램도 사용할 수 있도록 하기 위해 남아 있는 메서드
		v1.addElement("ccc");
		
		System.out.println("v1 = " + v1);
		
		//데이터 추가3 => add(index, 데이터) -> 반환값 x
		v1.add(1,"kkk");
		
		System.out.println("v1 = " + v1);
		
		//데이터 수정 => set(index, 새로운데이터) -> 반환값 : 이전 데이터
		Object ob = v1.set(0, "zzzzz");
		System.out.println("v1 = " + v1);
		System.out.println(ob);
		
		//데이터 삭제1 => remove(index) -> 반환값 :삭제된 데이터
		Object ob2 = v1.remove(1);
		System.out.println("v1 = " + v1);
		System.out.println(ob2);
		
		//데이터 삭제2 => remove(삭제할 데이터) -> 반환값 : boolean
		//삭제할 데이터가 여러개이면 앞에서 부터 검사하여 삭제
		v1.remove("ccc");
		System.out.println("v1 = " + v1);

		//정수형 데이터 혹은 char형 일 경우 삭제시 오토박싱x(index로 인식) => 직접 객체화 하여 사용
		v1.remove(new Integer(123));
		System.out.println("v1 = " + v1);
		
		v1.remove(new Character('a'));
		System.out.println("v1 = " + v1);
		
		//데이터 꺼내오기 : get(index)
		double data = (double)v1.get(2);
		System.out.println(data);
		
		/*
		 * 제네릭 타입(Generic type)
		 * - 객체를 선언할 때 < >안에 그 객체가 사용할 데이터의 타입을 정해주는 것을 의미
		 * - 생성된 객체에는 제네릭타입으로 지정한 데이터 이외의 데이터르 저장할 수 없음
		 * - 제네릭으로 선언될 수 있는 데이터 타입은 클래스 형
		 * - 데이터를 꺼내올 때 별도의 형변환이 필요하지 않음
		 */
		
		Vector<String> v2 = new Vector<>();
		Vector<Integer> v3 = new Vector<>();
		
		v2.add("안녕하세요");
		System.out.println("v2 = " + v2);
		v3.add(123);
		
		String temp = v2.get(0);
		System.out.println(temp);
		
		Vector<Vector> vv = new Vector<>();
		Vector<Vector<Vector>> vvv = new Vector<>();
		
		//전체 데이터 삭제 : clear()
		v2.clear();
		System.out.println("v2의 사이즈 = " + v2.size());
		
		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		Vector<String> v4 = new Vector<>();
		v4.add("BBBB");
		v4.add("EEEE");
		
		System.out.println("v2 = " + v2);
		System.out.println("v4 = " + v4);
		
		//데이터 삭제 : removeAll(Collection객체), collection 객체가 가지고 있는 데이터를 모두 삭제 -> 반환값 : boolean
		v2.removeAll(v4);
		System.out.println("v2 = " + v2);
		
		v2.clear();

		v2.add("AAAA");
		v2.add("BBBB");
		v2.add("CCCC");
		v2.add("DDDD");
		v2.add("EEEE");
		
		//Vector의 데이터를 순서대로 모두 가져와 사용할시 반복문 사용
		
		for(int i = 0; i < v2.size(); i++){
			System.out.println(i + "번째 인덱스 : " + v2.get(i));
		}
		System.out.println("---------------------------------------");
		
		//향상된 for문
		for(String str : v2){
			System.out.println(str);
		}
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
