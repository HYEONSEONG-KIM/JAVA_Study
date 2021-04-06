package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest04 {

	public static void main(String[] args) {
		//Q.문제 1에서 별명의 길이가 같은 것이 있을경우 처리
		
	Scanner sc = new Scanner(System.in);
		
		List<String> nickNameList = new ArrayList<>();
		
		for(int i = 0; i < 5; i++){
			System.out.print((i+1) + "번째 별명 입력>>");
			String input = sc.nextLine();
			
			nickNameList.add(input);
		}
		
		int maxLength = nickNameList.get(0).length();
		int maxIndex = 0;
		
		for(int i = 0; i < 5; i++){
			int check = nickNameList.get(i).length();
			
			if(maxLength <= check){
				maxLength = check;
				maxIndex = i;
			}
		}
		
		System.out.print("입력하신 별명중 가장 긴 단어는");
		for(int i = 0; i < 5; i++){
			if(nickNameList.get(i).length() == maxLength){
				System.out.print(nickNameList.get(i) + " ");
				
				
			}
		}
		System.out.println(" 입니다");
		
		
	}

}
