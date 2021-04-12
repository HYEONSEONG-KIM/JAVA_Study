package kr.or.ddit.basic;

import java.util.Properties;


public class PropertiesTest {

	public static void main(String[] args) {
		
		/*
		 * 	Properties : Map보다 축소된 기능의 객체
		 * 	- Map은 Key값, Value값에 모든 형태의 객체를 사용할 수 있지만,
		 * 	 Properties는 Key와 value값의 String만 사용
		 * 
		 * 	- Map은 put(), get()메서드를 이용하여 데이터를 입출력, 
		 * 	Properties는 setProperty(), getProperty()메서드를 통해서 데이터를 입출력
		 * 
		 * 	- Properties는 데이터를 파일로 입출력할 수 있음 
		 */
		
		Properties prop = new Properties();
		
		prop.setProperty("name", "홍길동");
		prop.setProperty("age", "20");
		prop.setProperty("tel", "010-1234-5678");
		prop.setProperty("addr", "대전시 중구");
		
		String name = prop.getProperty("name");
		int age = Integer.parseInt(prop.getProperty("age"));
		String tel = prop.getProperty("tel");
		String addr = prop.getProperty("addr");
		
		System.out.println("이름  : " + name );
		System.out.println("나이  : " + age );
		System.out.println("전화  : " + tel );
		System.out.println("주소  : " + addr );
		
	}

}






















