package e_oop;

import java.util.Arrays;
import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여 출력

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력해 주세요>");
		String num = sc.nextLine();
		String str = "" ;
		
		int cnt = 0;	
		for(int i = num.length() - 1; i >= 0; i--){
			cnt++;
			str += num.charAt(i);
			
			if(cnt % 3 == 0 && i != 0)
				str += ",";
		}
		
		String result = "";
		
		for(int i = str.length() - 1; i >= 0; i--){
			result += str.charAt(i);
		}
	
		System.out.println(result);
	} 
	
}



