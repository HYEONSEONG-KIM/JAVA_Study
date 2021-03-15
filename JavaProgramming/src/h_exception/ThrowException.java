package h_exception;

import java.io.IOException;

import javax.crypto.NullCipher;

public class ThrowException {

	public static void main(String[] args) {
		
		/*
		 * 예외 발생시키기
		 * - throw new Exception();
		 * - throw 예약어와 예외 클래스의 객체로 예외를 발생시킬 수 있음
		 */
		
		try {
			throw new IOException();
		} catch (IOException e) {
			e.printStackTrace();
		}//Exception 클래의 자식이므로 예외처리 강제

//		throw new NullPointerException();  //RuntimeException의 자식이므로 강제x
		
	/*	String str = null;
		
		System.out.println(str.equals("abc"));
	*/	
		
//		new IndexOutOfBoundsException();
		
		int[] a = new int[10];
		
		for(int i = 0; i <= a.length; i++){
			System.out.println(a[i]);
		}
		
		
		
		
	}

}






















