package kr.or.ddit.basic;

import java.util.ResourceBundle;

/*
 * 	ResourceBundle객체 => 파일의 확장자가 properties인 파일의 내용을 읽어와
 * 						key값과 value값을 분리해서 분리된 정보를 갖고 있는 객체
 * 
 * 	=> 읽어올 파일의 내용은 'key값 = value값' 형태로 되어있어야 함
 */

public class ResourceBundleTest {

	public static void main(String[] args) {
		
		// ResourceBundle객체를 이용하여 파일 읽어오기
		
		
		// ResourceBundle객체 생성하기
		// => 읽어올 파일명을 지정할 때 '파일 명'만 지정하고 확장자는 지정하지 않음
		//		( 이유 : 이 객체는 확장자가 properties인 파일만 처리하기 때문에)
		ResourceBundle bundle = ResourceBundle.getBundle("dbinfo");
		
		//------------------------------------------
		// 읽어온 내용 출력하기
		System.out.println("driver => " + bundle.getString("driver"));
		System.out.println("url => " + bundle.getString("url"));
		System.out.println("user => " + bundle.getString("user"));
		System.out.println("pass => " + bundle.getString("pass"));
	}

}

















