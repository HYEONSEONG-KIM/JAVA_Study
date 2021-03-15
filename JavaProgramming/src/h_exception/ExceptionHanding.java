package h_exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExceptionHanding {

	public static void main(String[] args) {
		/*
		 * 에러
		 * - 컴파일 에러 : 컴파일 시에 발생되는 에러(빨간줄)
		 * - 논리적 에러 : 실행은 되지만, 의도와 다르게 동작하는 것(버그)
		 * - 런타임 에러 : 실행 시에 발생되는 에러
		 * 
		 * 런타임 에러
		 * - 런타임 에러 발생시 발생한 위치에서 프로그램이 비정상적으로 종료
		 * - 에러 : 프로그램 코드에 의해 수습될 수 없는 심각한 오류(처리 불가)
		 * - 예외 : 프로그램 모드에 의해서 수습될 수 있는 다소 미약한 오류(처리 가능)
		 * 
		 * 예외
		 * - 모든 예외는 Exception 클래스의 자식 클래스
		 * - RuntimeExcetion 클래스와 그 자식들은 예외처리가 강제되지 않음
		 * - [RuntimeException 클래스와 그 자식들을 제외한] Exception 클래스의 자식들은 예외처리 강제
		 * 
		 * 예외처리(try -catch)
		 * - 예외처리를 통해 프로그램이 비정상적으로 종료되는 것을 방지
		 * - try{} catch(Exception){}
		 * - try 블럭 안의 내용을 실행 중 예외가 발생하면 catch로 넘어감
		 * - 여러 종류의 예외 처리할 수 있도록 catch는 하나 이상 올 수 있음
		 * - 발생한 예외와 일치하는 catch 블럭안의 내용이 수행된 후 try-catch를 빠져나감
		 * - 발생한 예외와 일치하는 catch가 없을 경우 예외는 처리하지 않음
		 */
		
		try{
			int result = 10 / 0 ;
			System.out.println(result);
			
		}catch(ArithmeticException | IndexOutOfBoundsException e){
			e.printStackTrace();  //예외가 발생했다는 것을 알려주는 메서드
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		/*
		 * 두개 이상의 예외처리
		 * 1.(Exception1 | Exception2 e)
		 * 2.catch 뒤에 catch 하나 더 작성
		 * 3.catch 조건에 Exception 하나만 작성하면 모든예외 처리 
		 */
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}//형식상 예외처리하는 경우
		
		test1();
		
		/*
		 * CallStack(Stack 자료구조-> 후입 선출)
		 * 맨위의 메서드가 가장 마지막에 호출 -> 에러 발생시 가장 늦게 호출된 부분(맨처음 에러메세지 출력)이 에러일 가능성 높음
		 * 
		 * |			|
		 * |__test2()___|
		 * |__test1()___|
		 * |__main()____|
		 * 
		 */
	}

	private static void test1() {
		test2();
	}

	private static void test2() {
//		System.out.println(10 / 0);
		try {
			new FileInputStream("");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}





















