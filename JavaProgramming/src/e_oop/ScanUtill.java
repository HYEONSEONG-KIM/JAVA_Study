package e_oop;

import java.util.Scanner;

public class ScanUtill {

	private static Scanner s = new Scanner(System.in);
	
	
	public static String nextLine(){
		return s.nextLine();
	}
	
	public static int nextInt(){
		return Integer.parseInt(s.nextLine());
	}
	
}
