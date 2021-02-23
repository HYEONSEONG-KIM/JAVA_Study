package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		//숫자야구 게임 만들기
		Scanner sc = new Scanner(System.in);
		int ran_1, ran_2, ran_3;
		int input_1, input_2, input_3;
		int cnt = 0;
		int strike = 0;
		int ball = 0;
		int out =0;
		int input_check = 0;
		
		
		do{
			ran_1 = (int)(Math.random() * 9) + 1;
			ran_2 = (int)(Math.random() * 9) + 1;
			ran_3 = (int)(Math.random() * 9) + 1;
			
		}while(ran_1 == ran_2 || ran_1 == ran_3 || ran_2 == ran_3);
		
		System.out.println(ran_1 + "" + ran_2 + "" + ran_3);
		
		do{
			strike = 0;
			ball = 0;
			out =0;
			input_check = 0;

			cnt ++;
			if(cnt >= 10){
				System.out.println("패배 하였습니다");
				break;
			}
			
		do{
		if(input_check >= 1){
			System.out.println("중복입력한 숫자가 있습니다.다시입력하여 주세요");
		}
		System.out.println(cnt + "회 공격입니다");	
		System.out.print("첫번째 자리 숫자 입력>");
		input_1 = Integer.parseInt(sc.nextLine());
		System.out.println("두번째 자리 숫자 입력>");
		input_2 = Integer.parseInt(sc.nextLine());
		System.out.println("세번째 자리 숫자 입력>");
		input_3 = Integer.parseInt(sc.nextLine());
		
		input_check++;
		}while(input_1 == input_2 || input_1 == input_3 || input_2 == input_3);
		
		if(input_1 == ran_1){
			strike++;
		}else if(input_1 == ran_2 || input_1 == ran_3){
			ball++;
		}else{
			out++;
		}
		
		if(input_2 == ran_2){
			strike++;
		}else if(input_2 == ran_1 || input_2 == ran_3){
			ball++;
		}else{
			out++;
		}
		
		if(input_3 == ran_3){
			strike++;
		}else if(input_3 == ran_1 || input_3 == ran_2){
			ball++;
		}else{
			out++;
		}
		
		System.out.println("입력한 숫자 " + input_1 + "" + input_2 + "" + input_3 + "은"
					+ strike + "s " + ball + "b " + out + "o 입니다");
		
		}while(strike != 3);
		
		if(strike ==3)
		System.out.println("승리하셨습니다");
		
		
	}

}
