package e_oop;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그램(Object Oriented Programming)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는것
		 * - 코드의 재사용성이 높고 유지보수가 용이
		 */
		
		SampleClass sample = new SampleClass();
		
		System.out.println(sample.field);
		
		System.out.println(sample.method(5));
		sample.method2();
		
		sample.flowTest1();
		
		//Q.다음을 한줄씩 계상해서 최종 결과값을 출력
		Calculator cal = new Calculator();
		//1. 123456 + 654321
		double add = cal.add(123456, 654321);
		System.out.println(add);
		//2. 1 * 123456
		double mul = cal.multiplication(add, 123456);
		System.out.println(mul);
		//3. 2 / 123456
		double div = cal.division(mul, 123456);
		System.out.println(div);
		//4. 4 - 654321
		double sub = cal.subtract(div, 654321);
		System.out.println(sub);
		//5. 4 % 123456
		double result = cal.remainder(sub, 123456);
		System.out.println(result);
		
		
	}

}
