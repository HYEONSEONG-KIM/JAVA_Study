package e_oop.restaurant;

import java.util.Arrays;

public class Boss {

	public static void main(String[] args) {
		Alba alba = new Alba();
		
		String[] order = alba.order();
		System.out.println(order[1]);
		
		System.out.println("요리 만드는 중...완성!!");
		String[] foods = {"완성된 짜장면", "완성된 탕수육"};
		
		alba.serve(foods);
		
		alba.pay(order);
	
;
	}

}
