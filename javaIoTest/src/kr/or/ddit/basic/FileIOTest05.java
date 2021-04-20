package kr.or.ddit.basic;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest05 {

	public static void main(String[] args) {
		
		// 한글이 저장된 파일 읽어오기
		// (한글의 인코딩 방식을 지정해서 읽어옴)
		
		try {
			//FileReader fr = new  FileReader("D:/D_Other/test_utf8.txt");
			//FileReader fr = new  FileReader("D:/D_Other/test_ansi.txt");
			
			/*int c;
			
			while((c = fr.read()) != -1){
				System.out.print((char)c);
			}
			
			fr.close();
			*/
			
			// 입력용 byte기반의 스트림을 문자기반의 스트림으로 변환해서 사용할 때 
			// 인코딩 방식을 지정할 수 있음
			FileInputStream fis = new FileInputStream("D:/D_Other/test_ansi.txt");
			
			// byte기반 입력 스트림은 문자기반 스트림으로 변환하기
			// InputStreamReader isr = new InputStreamReader(fis);	// 기본 인코딩 방식으로 읽어옴
			
			
			// 인코딩 방식 지정
			// 인코딩 방식 예시
			// - MS949 => 윈도우의 기본 한글 인코딩 방식(ANSI와 같음)
			// - UTF-8 => 유니코드 UTF-8 인코딩 방식
			// - US-ASCII => 영문 전용 인코딩
			
			InputStreamReader isr = new InputStreamReader(fis, "ms949");		// 인코딩 방식을 지정
			
			int c;
			
			while((c = isr.read()) != -1){
				System.out.print((char)c);
			}
			
			isr.close();	// 보조스트림을 사용할 때는 보조스트림만 닫으면 이것과 연결된 기반스트림도 자동으로 닫힘
			
			
		} catch (IOException e) {
		}
	}

}












