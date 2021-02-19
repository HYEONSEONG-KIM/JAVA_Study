package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술 연산자
		 * - 사칙연산 : +, -, *, /, %(나머지)
		 * - 복합연산자 : +=, -=,*=, /=, %=
		 * - 증감연산자 : ++, --
		 */
		
		int result = 10 + 20 -30 * 40 / 50 % 60;
		
		//나머지 연산
		result = 10 / 3;
		System.out.println(result);
		result =10 % 3;
		System.out.println(result);
		
		//Q.5개의 산술연산자를 사용해 5개의 연산을 수행 후 결과 출력
		int operatorNum_1 = 10 + 30;
		int operatorNum_2 = 20 - 4;
		int operatorNum_3 = 100 * 5;
		int operatorNum_4 = 100 / 2;
		int operatorNum_5 = 15 % 4;
		System.out.println(operatorNum_1);
		System.out.println(operatorNum_2);
		System.out.println(operatorNum_3);
		System.out.println(operatorNum_4);
		System.out.println(operatorNum_5);
		
		//복합연산자
		//변수에 저장되어 있는 값에 연산을 수행할 때 연산자와 대입연산자를 결합해 사용할 수 있다
		result = result + 3;
		result += 3;
	
		result = result - 5;
		result -= 5;
		
		result = result * 2;
		result *= 2;
		
		//Q.아래의 문장을 복합 연산자를 사용한 문장으로 만들기
		//result = result + 10;
		result += 10;
		
		//result = result -2 * 3;
		result -= 2 * 3;
		
		//result = result % 5;
		result %= 5;
	
		//증감연산자
		//증가연산자(++) : 변수의 값을 1 증가
		//감소연산자(--) : 변수의 값을 1감소
		int i=0;
		
		++i; //전위형 : 변수의 값을 읽어오기 전에 1 증가
		i++; //후위형 : 변수의 값을 읽어온 후 1 증가
		--i;
		i++;
		
		i = 0;
		System.out.println("++i = " + ++i);
		i = 0;
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double; //표현범위가 더 큰 타입으로 형 변환
		System.out.println(result2);
		
		long _long = 100L;
		_long = _int + _long;
		_int =_int + (int)_long;
		
		byte _byte = 5;
		short _short = 10;
		_int = _byte + _short; //int보다 작은 타입은 int로 형변환(4byte보다 작으면 연산을 하지 않음)
		System.out.println(_int);
		
		char _char = 'a';
		char _char2 = 'b';
		_int = _char + _char2; //2byte 이므로 int로 형변환 -> 유니코드에 대응하는 숫자로 변환
		System.out.println(_int);
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		//오버플로우
		byte b = 127;
		b++;
		System.out.println(b);
	
		//언더플로우
		b--;
		System.out.println(b);
		
		//Q.다음을 한줄씩 계산해서 최종 결과값을 출력
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 /123456
		//4. 3번의 결과값 - 654321;
		//5. 4번의 결과값 % 123456;
		
		long num;
		num = 123456 + 654321;
		System.out.println("1->"+num);
		num *= 123456;
		System.out.println("2->"+num);
		num /= 123456;
		System.out.println("3->"+num);
		num -= 654321;
		System.out.println("4->"+num);
		num %= 123456;
		System.out.println("result ->"+num);
		
		//Q.3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구하기
		int scr_1 = 84;
		int scr_2 = 98;
		int scr_3 = 99;
		int sum = scr_1 + scr_2 + scr_3;
		double avg = sum /3.0;
		
		System.out.println("3점수의 평균 : "+ avg);
		
		//반올림
//		avg = Math.round(avg); //소수점은 모두 반올림
//		System.out.println(avg);
		avg = Math.round(avg *100) / 100.0; //소수 첫째 자리는 10, 둘째 자리는 100...
		System.out.println(avg);
		
		//랜덤
		Math.random(); //0.0 ~ 1.0 미만 (0.999999...)
		int random = (int)(Math.random() * 100) + 1;
		System.out.println(random);
		
		
		
	}

}
