package e_oop;

import java.sql.PseudoColumnUsage;
import java.util.Arrays;

import javax.swing.SpinnerDateModel;

public class StringClass {

	public static void main(String[] args) {

		/*
		 * String
		 * - 여러개의 문자를 사용하기 쉽게 만들어 놓은 클래스
		 * 
		 * String의 주요 메서드
		 * - equals(String) : 문자열의 내용이 같은지 반환
		 * - length(String) : 문자열의 길이를 반환
		 * - charAt(int) : 특정 인덱스에 위치한 문자를 반환
		 * - substring(int, int) : 문자열의 특정 부분을 잘라서 반환
		 * - indexOf(char) : 문자열 내의 특정 문자의 인덱스를 반환
		 * - contains(Sting) : 문자열이 특정 문자열을 포함하고 있는지 여부를 반환
		 * - split(char) : 문자열을 특정 문자를 기준으로 나누어 배열형태로 반환
		 * - trim(String) : 문자열 앞뒤의 공백을 제거해서 반환
		 * - valueOf(String제외) : 다른 타입의 데이터를 문자열로 변환해 반환
 		 */
		
		
		//equals -> boolean 타입 반환
		
		boolean equals = "문자열".equals("문자열");
		System.out.println(equals);
		
		String str1 = "문자열";
		String str2 = null;
		System.out.println(str1.equals(str2));
//		System.out.println(str2.equals(str1));  //null값이 들어간 문자열을 기준으로 메서드 사용시 NullPointException 발생
		//null이 있을 수 있는 변수를 앞에두지 말아야 함
		
		
		
		//length -> int 타입 반환, chatAt -> char 타입 반환
		String str = "12345";
		int length = str.length();
		
		for(int i = 0; i < length; i++){
			char charAt = str.charAt(i);
			System.out.println(charAt);
		}
		
		//문자열 뒤집기
		String rev = "";
		
		for(int i = str.length() - 1; i >= 0; i--){
			rev += str.charAt(i);
		}
		
		System.out.println(rev);
		
		
		
		//substring -> String 타입 반환
		str = "0123456789";
		
		String sub1 = str.substring(3); //3번째 인덱스부터 잘라서 반환
		System.out.println(sub1);
		String sub2 = str.substring(5, 8); //5번째 인덱스 부터 8번째 인덱스 전까지 반환
		System.out.println(sub2);
		
		
		
		//indexOf -> int 타입 반환
		str = "수박 오렌지 귤 블루베리";
		int indexOf = str.indexOf("오렌지");
		System.out.println(indexOf);
		
		//substring과 indexOf를 조합해서 문자열 자르기
		String[] menu = {"수박 20000원" , "오렌지 100000원", "귤 500원",
					"블루베리 3000원"};
		
		for(int i = 0; i < menu.length; i++){
			String menuName = menu[i].substring(0, menu[i].indexOf(" "));
			System.out.println(menuName);
		}
		
		
		//Q.가격만 잘라서 int타입 변수에 저장
		for(int i = 0; i < menu.length; i++){
			int price = Integer.parseInt(menu[i].substring(menu[i].indexOf(" ") + 1, 
						menu[i].indexOf("원")));
			
			System.out.println(price);
		}
		
		
		//contains -> boolean 타입 반화
		str = "abcd";
		boolean contains = str.contains("c");
		System.out.println(contains);
		
		//Q.오렌지가 메뉴의 몇번 인덱스에 있는지 찾기
		
		for(int i = 0; i < menu.length; i++){
			if(menu[i].contains("오렌지")){
				System.out.println("오렌지는 " + i + "번 인덱스에 있습니다");
			}
		}
		
		//split -> 배열형태로 반환
		str = "a/b/c";
		String[] split = str.split("/");
		System.out.println(Arrays.toString(split));
		
		for(int i = 0; i < menu.length; i++){
			split = menu[i].split(" ");
			System.out.println("메뉴명 : " + split[0] + " / 가격 : " + split[1]);
		}
		
		
		//trim -> String 타입 반환(가운데 공백은 없애주지 않음)
		str = "  문자열  ";
		String trim = str.trim();
		System.out.println("[" + str + "] -> [" + trim + "]");
		
		String id = " myId";
		String password = "mypassword ";
		System.out.println(id);
		System.out.println(password);
		System.out.println(id.trim());
		System.out.println(password.trim());

		
		//valueOf
		int number = 10;
		str = String.valueOf(number);
		System.out.println(str);
		str = number + "";
		
		
	}
		
}













