package a_variable;

import java.util.Scanner;

public class Homework {

	public static void main(String[] args) {
		
		String id;
		int password;
		String name;
		int age;
		double stature;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("회원가입을 위해 정보를 입력하여 주세요");
		System.out.print("ID : ");
		id = sc.nextLine();
		
		System.out.print("Password : ");
		password = Integer.parseInt(sc.nextLine());
		
		System.out.println("이름 : ");
		name = sc.nextLine();
		
		System.out.println("나이 : ");
		age = Integer.parseInt(sc.nextLine());
		
		System.out.println("신장 : ");
		stature = Double.parseDouble(sc.nextLine());
		
		System.out.println("====입력된 정보====");
		System.out.println("아이디 : " + id + "\n" +
						 "비밀번호 : "+ password + "\n" +
						 "이름 : " + name + "\n" +
						 "나이 : " + age + "세\n" +
						 "신장 : " + stature + "cm");
	}

}
