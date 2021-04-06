package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest03 {

	public static void main(String[] args) {
		
		//Q.5명의 별명을 입력 받아 ArrayList에 저장하고 이들 중 별명의 길이가 제일 긴 별명을 출력
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
			
			if(maxLength < check){
				maxLength = check;
				maxIndex = i;
			}
		}
		
		System.out.println("입력하신 별명 중 가장 긴 글자는 " + nickNameList.get(maxIndex) + " 입니다");
	
		
		
	
	}

}
