package a_variable;		//클래스의 위치

import java.util.Scanner; //다른 패키지에 있는 클래스의 위치를 알려주는 것
//ctrl + shift + o

public class Variable {	//클래스 : 변수와 메서드로 구성

	public static void main(String[] args) {
		//main메서드 : 프로그램의 시작과 끝
		//한 줄 주석 : ctrl + shift + c, 범위 주석 : ctrl + shift + /(해제 : \)
		
		/*
		 * 데이터
		 * - 기본형
		 * - 배열
		 * - 클래스
		 * 
		 * 조작
		 * - 산술연산
		 * - 비교연산
		 * - 논리연산
		 * - 조건문
		 * - 반복문
		 */
		
		/*
		 * 기본형 타입
		 *  - 정수 : byte(1), short(2), *int(4), long(8)
		 *  - 실수 : float(4) => 7자리 이후에는 오류발생 가능성, *double(8) => 15자리 이후에는 오류발생 가능성 
		 *  - 문자 : char(2)
		 *  - 논리 : boolean(1)
		 */
		 
		int x; //정수를 저장할 수 있는 x라는 이름을 가진 그릇을 만들어라
		
		double y; //한 블럭 안에는 같은 이름의 변수명으로 선언할 수 없음
		
		//=(대입연산자) : 오른쪽의 값을 왼쪽의 변수에 저장
		x = 10; // 초기화 : 변수에 처음으로 값을 저장하는 것
		y = 3.14; // 변수의 타입에 맞는 값을 저장

		int abc = 30; //일반적으로 선언과 초기화를 한번에 함
		long l = 40L; //접미사 L을 붙여야 long타입이 됨 
		float f = 5.5f; //접미사 f를 붙여야 float타입이 됨
		char c = '한'; //따옴표안에 반드시 한 글자를 넣어야 함
		boolean b = true; //true, false
		
		//Q.8가지 기본형 타입을 사용해서 8개의 변수를 선언 및 초기화
		byte by = 1;
		short sh= 10;
		int in = 100;
		long lo =  1000L;
		float fl = 1.5f;
		double dou = 30.3;
		char ch = 'a';
		boolean boo = false;
		
		x = 20; //기존에 저장되어 있는 10이라는 값은 사라지고 20이라는 값이 저장, 변수를 만들때만 타입을 붙임
		
		//Q.위에서 만든 8개의 변수에 새로운 값을 저장
		by = 2;
		sh = 12;
		in = 102;
		lo = 1002L;
		fl = 1.6f;
		dou = 30.2;
		ch = 'b';
		boo = true;
		
		//콘솔창에 출력, 
		System.out.println(100);
		System.out.println(x);
		//실행 단축키 : ctrl + F11
		
		//Q.위에서 만든 8개의 변수의 값을 출력
		System.out.println(by);
		System.out.println(sh);
		System.out.println(in);
		System.out.println(lo);
		System.out.println(fl);
		System.out.println(dou);
		System.out.println(ch);
		System.out.println(boo);
	
		//문자열
		String str = "문자 여러개.."; //클래스는 참조형타입 데이터, 참조형은 주소값
		System.out.println(str);
		//문자열과 다른 타입의 데이터가 결합되면 문자열의 결과를 얻음
		System.out.println(str + 50);
		System.out.println(10 + 20 + str);
		System.out.println(str + 10 + 20 );
		System.out.println( 10 + str + 20 );
		
		//형변환 : 다른 타입의 값을 저장하기 위해서는 값의 타입을 변경해 주어야 하는데 이를 형변환(Type casting)이라 함
		
		int small = 10;
		long big = 10L;
		
		small = (int)big;
		big = small; //표현범위가 작은쪽에서 큰쪽으로의 형변환은 생략 가능
		
		/*
		 * 명명규칙
		 * - 영문자 대소문자, 한글, 숫자, 특수문자(_ , $)를 사용 할 수 있음
		 * - 숫자로 시작할 수 없음
		 * - 예약어는 사용할 수 없음
		 * - [낙타식 표기법을 사용 (mySampleVariable)]
		 * - [클래스명의 첫 글자는 대문자로 함]
		 */
		
		
		/*
		 * 상수
		 * - 값을 변경할 수 없는 그릇
		 * - 리터럴에 의미를 부여하기 위해 사용
		 * - final 사용
		 * - 상수의 변수명은 대문자로
		 */
		final int MAX_NUMBER = 10;
		
		System.out.print("줄바꿈을 하지 않음");
		System.out.print("줄바꿈을 하지 않음 \n");  // \->탈출 문자(뒤에 있는 기호에게 다른 역할을 부여)
		System.out.println("줄바꿈을 한다");
		System.out.printf("문자열 : %s, 숫자 : %d\n",str ,x); //출력 포멧을 지정
		
		//입력
		Scanner sc = new Scanner(System.in); //입력받기 위한 클래스
		
//		System.out.println("아무거나 입력해주세요");
//		String str2 = sc.nextLine();
//		System.out.println(str2);
		
//		int nextInt = sc.nextInt();
//		double nextDouble = sc.nextDouble();
		//이런것들이 있지만 버그(엔터는 숫자가 아닌 텍스트로 인식)로 인해 사용하지 않는것이 좋음
		
/*		System.out.println("int 입력");
		int nextInt = sc.nextInt();
		System.out.println(nextInt);
		System.out.println("문자열 입력");
		String nextLine = sc.nextLine();
		System.out.println(nextLine);
		System.out.println("입력 끝!");
*/
		/*System.out.print("int 입력>");
		int number =Integer.parseInt(sc.nextLine());
		System.out.print("double 입력>");
		double number2 = Double.parseDouble(sc.nextLine());
		System.out.println(number);
		System.out.println(number2);*/
		
		//Q.자신의 이름을 저장할 변수를 선언
		String myName;
		
		//Q.위에서 선언한 변수를 초기화 하기 위해 이름을 입력받기
		System.out.print("이름을 입력해주세요>");
		myName = sc.nextLine();
		System.out.println(myName);
		
		//Q.자신의 나이를 저장할 변수를 선언
		int myAge;
		
		//Q.위에서 선언한 변수를 초기화 하기 위해 나이를 입력 받기
		System.out.print("나이를 입력해주세요>");
		myAge = Integer.parseInt(sc.nextLine());
		System.out.println(myAge);
		
		System.out.println("이름 : "+ myName + ", 나이 : " + myAge);
		
		/*
		 * -과제-
		 * 다음과 같은 프로그램 작성
		 * 
		 * ==========회원가입==========
		 * 아이디>admin
		 * 비밀번호(4자리 숫자)>1234
		 * 이름>홍길동
		 * 나이>30
		 * 키>185.5
		 * 회원가입 완료!!
		 * =========내 정보===========
		 * 아이디 : admin
		 * 비밀번호 : 1234
		 * 이름 : 홍길동
		 * 나이 : 30세
		 * 키 : 185.5cm
		 */
		
		
	}
}
