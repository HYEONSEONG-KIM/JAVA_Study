package e_oop;

public class Static {

	/*
	 * static을 붙이면 프로그램 실행시 메모리에 올라감
	 * 객체생성을 하지 않아도 사용할 수 있음
	 * static을 붙인 변수는 객체간에 변수의 값을 공유
	 * static이 붙은 멤버의 명칭 : 클래스 변수, 클래스 메서드
	 * static이 붙지 않은 멤버의 명칭 : 인스턴스 변수, 인스턴스 메서드
	 */
	
	//값을 공유하기 위해 static을 붙임
	static int var;
	
	
	public static void main(String[] args) {
		Saram s1 = new Saram();
		Saram s2 = new Saram();
		
		s1.name = "철수";
		s2.name = "영희";
		
		s1.saveMoney(100000);
		s2.saveMoney(200000);
		
		s1.saveDateMemory(200000);
		s2.saveDateMemory(200000);
		
		//Math.random();
		//Math.round();
		System.out.println(Math.random());
		
		System.out.print("문자열 입력>");
		String input = ScanUtill.nextLine();
		System.out.print("숫자 입력>");
		int input2 = ScanUtill.nextInt();
		
		System.out.println(input + input2);
	}

}


class Saram{
	
	String name;  //이름
	int account;  //통장의 잔고
	
	void saveMoney(int money){
		account += money;
		System.out.println(name + "의 통장 잔고 : " + account + "원");
		
	}
	
	static int dateAccount; //데이트 통장의 잔고
	
	
	static void saveDateMemory(int money){
		dateAccount += money;
		System.out.println("데이트 통장 잔고 : " + dateAccount + "원");
	}
	
	
	
}









