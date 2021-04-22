package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {
	
	public static void main(String[] args) throws IOException {
		/*
		 *	URLConnection 클래스 => 애플리케이션과 URL간의 통신 연결을 위한 클래스
		 * 						=> 해당 URL에 접속해서 자료를 가져오거나 보낼 수 있음
		 *
		 *	ex) 특정 서버의 정보와 파일 내욜을 자겨와 출력하는 예제 만들기
		 */
		
		URL url = new URL("https://www.naver.com/index.html");
		
		// URLCOnnection 객체 구하기
		URLConnection urlCon = url.openConnection();
		
		// 전체 Header 정보 가져오기
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		
		// headerMap의 키값과 value값 출력
		for(String headerKey : headerMap.keySet()){
			System.out.println(headerKey + " : " + headerMap.get(headerKey));
		}
		System.out.println("----------------------------------------------");
		System.out.println();
		
	/*	// URL에 지정한 문서의 내용을 가져오기(index.html문서의 내용)
		
		// 방법1 => URLConnetion객체 이용 방법
		
		// 파일을 읽어오기 위한 스트림 객체 생성
		InputStream is = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		
		// 자료를 읽어와 출력
		while(true){
			String str = br.readLine();	// 한 줄씩 자료 읽기
			if(str == null)
				break;
			
			System.out.println(str);
			
		}
		br.close();*/
		
		//Buffered에서 input,output과 reader, writer 차이...??
		//가져오고자 하는 원본의 구조에 맞게 설정!!!
		//input 스트림은 바이트 단위  reader는 문자열 단위!!!!
		
		// 방법2 => URL객체의 openStream() 메서드 이용
		InputStream is2 = url.openStream();
		InputStreamReader isr2 = new InputStreamReader(is2, "UTF-8");
		BufferedReader br2 = new BufferedReader(isr2);
		
		while(true){
			String str = br2.readLine();	// 한 줄씩 자료 읽기
			if(str == null)
				break;
			
			System.out.println(str);
			
		}
		br2.close();
		
		
	}
}














