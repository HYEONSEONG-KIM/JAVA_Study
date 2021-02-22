package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 연산자를 입력받아 연산결과를 알려주는 프로그램

		Scanner sc = new Scanner(System.in);
		
		System.out.print("num1 >");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("연산자 입력>");
		String Op = sc.nextLine();
		
		System.out.print("num2 >");
		int num2 = Integer.parseInt(sc.nextLine());
	
		int result = 
				Op.equals("+") ? num1 + num2 : 
					(Op.equals("-") ? num1 - num2 :
						(Op.equals("*")? num1 * num2 : 
							(Op.equals("/") ? num1 / num2 : 0)));
		
		System.out.println("연산의 결과는 " + result + "입니다");
	}

}
