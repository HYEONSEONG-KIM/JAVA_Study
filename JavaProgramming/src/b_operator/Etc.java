package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		/*
		 * 비트연산자
		 * - |, &, ^, ~, <<, >>
		 * - 비트 단위로 연산
		 * 
		 * 기타연산자
		 * - .(참조연산자) : 특정 범위내에 속해 있는 멤버를 지칭할 때 사용
		 * - (type) : 형 변환
		 * - ? : (삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장 : 조건식이 거짓일 경우 수행할 문장
		 */
		
		//1byte : 01010101, 0 혹은 1 하나하나를 bit(비트)
		System.out.println(10 | 15); // | : 둘다 0인 경우 0 그외 1
		// 10 : 0000 1010
		//  |
		// 15 : 0000 1111
		//      0000 1111
		
		int x = 10;
		int y = 20;
		int result = x < y ? x : y; //x가y보다 작으면 x, 크면y 할당
		System.out.println(result);
		
		//ex)주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2면 여자
		int regNo = 5;
		String gender = regNo ==1 ? "남자" : "여자";
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		gender = regNo == 1 ? "남자" : (regNo ==2 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		//Q.2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력
		Scanner sc =new Scanner(System.in);
//		int num1 , num2, moreBigNum;
//		System.out.print("num1 입력 >");
//		num1 = Integer.parseInt(sc.nextLine());
//		System.out.println("num2 입력 >");
//		num2 = Integer.parseInt(sc.nextLine());
//		
//		moreBigNum = num1 > num2 ? num1 : num2;
//		String numStr = num1 > num2 ? "num1" : "num2";
//		System.out.println("num1 과  num2중 더 큰 숫자는 "+ numStr + "(" + moreBigNum +")" + "입니다");
//	
		//Q.숫자를 입력받고, 그 숫자가 1이나 3이면 남자를 2나 4면 여자를 출력
		// 그외 숫자를 입력하면 확인불가 출력
		System.out.print("숫자를 입력하세요>");
		int regNum = Integer.parseInt(sc.nextLine());
		
		String genderResult = regNum == 1 || regNum == 3 ? "남자" : 
							(regNum == 2 || regNum == 4 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 "+ genderResult + "입니다");
		
	
	}

}
