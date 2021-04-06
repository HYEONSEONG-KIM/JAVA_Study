package kr.or.ddit.basic;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest02 {

	public static void main(String[] args) {
		
		//Q.5명의 이름을 입력 받아 ArrayList에 저장한 후에 이들 중 '김'씨 성의 이름을 모두 출력
		Scanner sc = new Scanner(System.in);
		
		List<String> name = new ArrayList<>();
		
		for(int i = 0; i < 5; i ++){
			System.out.print((i+1) + "번째 입력 >>");
			String inputName = sc.nextLine();
			name.add(inputName);
		}
		
		for(int i = 0; i < name.size(); i++){

			/*String firstName = name.get(i).substring(0,1);
			String check = "김";
			
			if(check.equals(firstName)){
				System.out.println(name.get(i));
			}*/
			
			/*char firstName2 = name.get(i).charAt(0);
			
			if(firstName2 == '김'){
				System.out.println(name.get(i));
			}*/
			
			String name0 = name.get(i);
			if(name0.startsWith("김")){
				System.out.println(name0);
			}
			
			if(name0.indexOf("김") == 1){
				System.out.println(name0);
			}
		}
		
	}

}
