package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class RandomStudents {

	public static void main(String[] args) {
		//입력한 숫자만큼 학생의 이름을 랜덤으로 출력하는 프로그램 만들기
		String[] students = new String[]{"김병수", "곽명훈" , "김나위", "김성현", "김영광", "김정명", 
				"김찬미", "김현민", "김현성", "류창현", "맹세희", "배병주", "설동비", "양규진", "여지연", 
				"오태훈", "이기정" ,"이상훈", "이재헌", "이치우", "전민주", "조기범", "조영현", "조항민", 
				"최진우"};
		boolean[] check = new boolean[students.length];
		
		int[] ran;
		
		
		Scanner sc =new Scanner(System.in);
		
	
		System.out.print("1 ~ "+ students.length +" 중 몇명의 학생을 무작위로 뽑겠습니까?>");
		int input = Integer.parseInt(sc.nextLine());
		
	
		
		ran = new int[input];
		
		//랜덤으로 생성된 숫자의 중복을 막기위한 코드
		for(int i = 0; i < input; i++){
			int random;
			
			while(true){
			random = (int)(Math.random() * students.length);
			if(check[random] == true){
				continue;
			}else{
				break;
			}
			}
			check[random] = true;
			ran[i] = random;
		}		
	
		System.out.print("임의로 선택된 학생 : ");
		
		for(int i = 0; i < input; i++){
			System.out.print(students[ran[i]] + "\t");
		}
		
	
	}

}
