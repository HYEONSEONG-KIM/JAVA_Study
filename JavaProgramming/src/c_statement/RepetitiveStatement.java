package c_statement;

import java.util.Scanner;

public class RepetitiveStatement {

	public static void main(String[] args) {
		/*
		 * 반복문
		 * - for문
		 * - while문
		 * - do-while문
		 * 
		 * for문
		 * - for(초기화; 조건식; 증감식){}
		 * - 포함하고 있는 문장들을 정해진 횟수만큼 반복하는 문장
		 */
		
		for(int i = 1; i <= 10; i++){
			System.out.println(i + "번째 반복");
		}
		
		//규칙이 있는 문장들을 효율적으로 작성하기 위해 반복문을 사용
		
		int sum = 0; //1~10까지 합계를 저장
		sum += 1;
		sum += 2;
		sum += 3;
		sum += 4;
		sum += 5;
		sum += 6;
		sum += 7;
		sum += 8;
		sum += 9;
		sum += 10; //개수가 많아 질수록 매우 비효율적
		System.out.println(sum);
		
		sum = 0;
		
		for(int i = 1; i <= 10; i++){
			sum += i;
		}
		System.out.println(sum);
		
		sum=0;
		
		for(int i = 10; i >=1 ; i--){
			sum += i;
		}
		System.out.println(sum);
		
		//Q.1부터 100까지 짝수의 합 출력
		sum = 0;
		
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0)
				sum += i;
		}
		System.out.println(sum);
		
		sum = 0;
		
		for(int i = 0; i <= 100; i += 2 ){
			sum += i;
		}
		
		//Q.1부터 100까지 홀수의 합을 출력
		sum = 0;
		
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 1)
				sum += i;
		}
		
		System.out.println(sum);
		
		sum = 0;
		
		for(int i = 1; i <= 100; i += 2){
			sum += i;
		}
		System.out.println(sum);
		
		/*
		 * Q.구구단 출력
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * ...
		 * 2 * 9 =18
		 */
		for(int i = 1; i <= 9; i++){
			System.out.println("7 x " + i + " = " + i * 7);
		}
		
		//Q.구구단 전체 출력
		
		for(int i = 2; i <= 9; i++){
			System.out.println("===" + i + "단===");
			for(int j = 1; j <= 9; j++){
				System.out.println(i + " x " + j + " = " + i * j);
			}	
		}
		
		//Q.구구단 가로로 출력
		
		for(int i = 1; i <= 9; i++){
			for(int j = 2; j <= 9; j++){
				System.out.print(j + " x " + i + " = " + j * i + "\t");
			}
			System.out.println("");
		}
		
		/*
		 * while문
		 * - while(조건식){}
		 * - 포함하고 있는 문장들을 조건식이 만족하는 동안 반복하는 문장
		 * - 반복횟수가 정확하지 않은 경우에 주로 사용
		 */
		
		int a = 1;
		//a에 2씩 몇번을 곱해야 1000이상이 되는가?
		int cnt = 0;
		while(a <= 1000){
			a *= 2;
			cnt++;
		}
		System.out.println(cnt);
	
		
		/*
		 * do-while문
		 * - do{}while(조건식)
		 * - 최소한 한번의 수행을 보장
		 * - 무언가 한번 실행한 후에 조건을 검사
		 */
		
		//Q.숫자 맞추기 게임
		int random = (int)(Math.random() * 100) + 1;
		int input = 0;
		Scanner sc = new Scanner(System.in);
		
		/*do{
			System.out.println("1 ~ 100 사이의 수를 입력해주세요>");
			input = Integer.parseInt(sc.nextLine());
			
			if(random < input){
				System.out.println(input + "보다 작습니다");
			}else if(random > input){
				System.out.println(input + "보다 큽니다");
			}else{
				System.out.println("정답입니다");
			}
		}while(input != random);*/
		
		
		
		//이름붙은 반복문
		outer : for(int i = 2; i <= 9; i++){
			for(int j = 1; j <= 9; j++){
				if(j == 5){
//					break; //가장 가까운 반복문 하나를 빠져나감
//					break outer; //outer라는 이름의 반복문을 빠져나감
//					continue; //가장 가까운 반복문의 현재 반복회자를 빠져 나감
					continue outer; //outer라는 이름의 현재 반복회차를 빠져나감
				}
				System.out.println(i + " x " + j + " = " + i * j);
			}
			System.out.println();
		}
	
		//반복문을 이용하여 별 짓기
		

		for(int i = 1; i <= 3; i++){
			for(int j = 1; j <= 5; j++){
				System.out.print("*");
			}
			System.out.println();
		}

		System.out.println();
		
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= i ; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		/* Q. 다음모양의 별 출력
		 *  *****
		 *  ****
		 *  ***
		 *  **
		 *  *
		 *  
		 *      *
		 *     **
		 *    ***
		 *   ****
		 *  *****
		 *  
		 *     *
		 *    ***
		 *   *****
		 *  *******
		 * *********    
		 */
		
		for(int i = 1; i <= 5; i++){
			for(int j = i; j <= 5; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int i = 1; i <= 5 ; i++){
			for(int j = 5; j >= 1; j--){
				
				if(i < j){
					System.out.print(" ");
				}else if(i >= j){
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
		
		System.out.println();
		
		
		for(int i = 1; i <= 5 ; i++){
		
			for(int j = 5; j >= 1; j--){
				
				if(i < j){
					System.out.print(" ");
				}else if(i >= j){
					System.out.print("*");
				}
			}
			
			for(int k = 1; k <= 4; k++){
				if(i > k){
					System.out.print("*");
				}
				
			}
			
			
			
			System.out.println();
			
			//산모양 2번째
			
//			for(int k = 1; k <= 5; k++){
//			
//				for(int j = 5; j > k; j--){
//					System.out.print(" ");
//				}
//				for(int j = 1; j <= k * 2 -1; j++){
//					System.out.print("*");
//				}
//				System.out.println();
//			}
		
		
		
		
		}
		
		
	}

}











