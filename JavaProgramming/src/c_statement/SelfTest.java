package c_statement;

import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		//탄수화물 중독 자가진단 프로그램
		Scanner sc = new Scanner(System.in);
		
		int cnt = 0 ;
		int check;
		System.out.println("===탄수화물중독 자가진단 테스트 프로그램 입니다===");
		System.out.println("질문사항에 해당되시면 숫자 1을 해당되지 않으면 2를 입력해주세요");
	
		System.out.print("1.식사후 얼마되지 않아서 금방 허기가 진다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		
		System.out.print("2.식사후 단맛이 도는 디저트를 즐긴다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("3.원두커피보다는 설탕을 넣은 커피를 즐긴다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("4.스트레스를 받으면 식욕이 땡긴다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("5.스트레스를 받았을때에 간식을 먹게 되면 기분이 안정이 된다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("6.무언가를 먹지 않으면 불안한 느낌이 들면서 일이나 공부들에 집중하기가 힘들다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("7.습관적으로 빵이나 과자를 찾게 된다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("8.아침을 거른날보다, 아침을 먹은 날이 점심시간이 되기 전에 더욱 배가 고프다");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
	
		System.out.print("9.패스트푸드나 인스턴트 식품을 즐겨먹는다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("10.식사후 졸리고 나른한 경우가 종종 있다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("11.빵이나 과자, 케익을 먹기 시작하면 양을 조절하지 못하고 끊임없이 먹게 된다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
	
		System.out.print("12.많이 먹어도 배가 부른 느낌이 쉽게 들지 않는다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
	
		System.out.print("13.배가 불러도 입에서 음식이 당겨 음식을 제한하지 못한다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("14.부모님 중 혈압, 당뇨, 심장병, 고지혈 증 등의 순환기질환을 가진 분이 계신다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("15.잡곡밥보다는 흰쌀밥을 선호한다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("16.밀가루음식(스파게티, 흰식빵, 케익류 등)을 선호하며 일주일에 3회 이상 밀가루 음식을 먹는다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("17.맛있는 음식을 먹는 상상 하거나 음식을 보아도 먹고 싶은 욕구가 강하게 든다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("18.평소 운동을 규칙적으로 하지 않고 생활 운동량도 많지 않다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("19.체중을 감량하더라도 다시 쉽게 살이 찐다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		System.out.print("20.부모형제나 친익척 중에 비만인 사람이 있다 >");
		check = Integer.parseInt(sc.nextLine());
		if(check == 1){
			cnt++;
		}
		
		
		if(cnt <= 6){
			System.out.println("정상입니다");
		}else if(cnt >= 7 && cnt <=13){
			System.out.println("탄수화물 중독 위험 수준입니다");
		}else if(cnt >= 14){
			System.out.println("탄수화물 중독입니다");
		}
		
	}

}
