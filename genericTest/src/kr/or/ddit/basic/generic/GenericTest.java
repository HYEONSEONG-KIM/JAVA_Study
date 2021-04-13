package kr.or.ddit.basic.generic;

/*
 * 	제네릭(Generic) : 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 의미
 * 
 *	제네릭 클래스를 만드는 방법
 *	형식)
 *		class 클래스명<제네릭타입글자>{
 *			
 *			제네릭타입글자 변수명;	//변수 선언 할 때 제네릭을 사용할 경우
 *			...
 *		
 *			제네릭타입글자 메서드명(매개변수들...){		//메서드의 반환값으로 제네릭을 사용할 경우
 *				...
 *				return 값
 *			}
 *		
 *			메서드명(제네릭타입글자 변수명, ...){	//매개변수를 지정할 때 제네릭을 사용할 경우
 *			
 *			}
 *			
 * 		}
 * 
 * 	- 제네릭타입 글자 (영어대문자 1글자 사용)
 * 	T -> Type
 * 	K -> Key
 * 	V -> Value
 * 	E -> Element
 */


//제네릭을 사용하지 않을 경우
class NonGeneric{
	private Object value;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
	
	
}

//제네릭을 사용하는 클래스
class MyGeneric<T>{
	
	private T value;
	
	
	public void setValue(T value){
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
	
	
	
	
}

public class GenericTest {

	public static void main(String[] args) {
		
		NonGeneric non1 = new NonGeneric();
		non1.setValue("안녕하세요");
		
		NonGeneric non2 = new NonGeneric();
		non2.setValue(123);
		
		String rtn1 = (String)non1.getValue();
		System.out.println("문자열 반환값 : " + rtn1);
		
		int rtn2 = (int)non2.getValue();
		System.out.println("정수형 반환값 : " + rtn2);
		
		System.out.println("-----------------------------------------");
		
		MyGeneric<String> my1 = new MyGeneric<>();
		my1.setValue("우리나라");
		
		MyGeneric<Integer> my2 = new MyGeneric<>();
		my2.setValue(500);
		
		String myRtn1 = my1.getValue();
		System.out.println("제네릭의 문자열 반환값 : " + myRtn1);
		
		int myRtn2 = my2.getValue();
		System.out.println("제네릭의 정수형 반환값 : " + myRtn2);
		
		
	}

}

















