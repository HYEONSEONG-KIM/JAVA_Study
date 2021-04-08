package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BaseBallTest {

	public static void main(String[] args) {
		/*
		 * 	Q. Set과 List를 이용하여 숫자야구 게임 프로그램 작성
		 * 	컴퓨터의 숫자는 난수를 이용하여 구한다
		 * 	(스트라이크는 S,볼은 B로 나타낸다)
		 */
		Scanner sc = new Scanner(System.in);
		HashSet<Integer> answer = new HashSet<>();
		
		System.out.println("***난이도를 선택하세요***");
		System.out.print("1.nomal\t2.hard >");
		int level = Integer.parseInt(sc.nextLine());
		
		
		while(answer.size() < (level+2)){
			int ran = (int)(Math.random() * 9) + 1;
			answer.add(ran);
		}
		
		List<Integer> answerList = new ArrayList<>(answer);
		
		Collections.shuffle(answerList);
		System.out.println(answerList);
		
		int cnt = 1;
		
		while(true){
			int strike = 0;
			int ball = 0;
			
			List<Integer> inputList = new ArrayList<>();
			
			System.out.println("*********" + cnt + "회 공격입니다*********");
			
			for(int i = 0; i < answerList.size(); i++){
				System.out.print((i+1) + "번째 숫자 입력>");
				int input = Integer.parseInt(sc.nextLine());
				inputList.add(input);
			}
			
			for(int i = 0; i < answerList.size(); i++){
				for(int j = 0; j < answerList.size(); j++){
					if(i == j && answerList.get(i) == inputList.get(j)){
						strike++;
					}
					if(i != j && answerList.get(i) == inputList.get(j)){
						ball++;
					}
				}
			}
			
			if(strike == answerList.size()){
				System.out.println("*****" + cnt +"번째 만에 맞히셨습니다*****");
				break;
			}
			
			
			System.out.println("입력하신 " + inputList + "는 " + strike + "S " + ball + "B 입니다");
			cnt++;
			
			if(cnt == 10){
				System.out.println("패배하였습니다");
				break;
			}
			
			
		}
		
		
	}

}
