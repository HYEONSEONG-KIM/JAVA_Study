package e_oop;

public class ClassMaker {

	//Q.전역변수 하나를 선언 및 초기화
	
	int a = 10;
	
	/*
	 * Q.리턴타입과 파라미터가 없는 메서드 하나를 만들기
	 * 메서드 안에서 전역변수 출력
	 */
	void method(){
		System.out.println("전역변수 : " + a);
	}
	
	
	/*
	 * Q.전역변수와 동일한 타입의 리턴타입이 있고 파라미터는 없는 메서드 하나만들기
	 * 메서드 안에서 전역변수를 리턴
	 */	
	int method2(){
		return a;
	}
	
	/*
	 * Q.리턴타입은 없고 파라미터가 있는 메서드 하나 생성
	 * 메서드 안에서 파라미터 출력
	 */
	
	void method3(int b){
		System.out.println(b);
	}
	
	
	/*
	 * Q.int타입의 리턴타입과 int타입의 파라미터 두 개가 있는 메서드 하나 생성
	 * 메서드 안에서 두 파라미터를 곱한 결과 리턴
	 */
	
	int mul(int a, int b){
		return a * b;
	}
	
	
	
	
}
