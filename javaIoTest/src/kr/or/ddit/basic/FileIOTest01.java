package kr.or.ddit.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileIOTest01 {

	public static void main(String[] args) {
		
		// 파일 내용 읽기 연습 => FileInputStream을 이용한 예제
		
		try {
			// 읽어올 파일을 인수로 받는 FileInputStream객체 생성
			// 방법1
//			FileInputStream fin = new FileInputStream("D:\\D_Other\\text.txt");
			
			// 방법2
			File file = new File("D:\\D_Other\\text.txt");
			FileInputStream fin = new FileInputStream(file);
			
			int c;	//읽어올 데이터가 저장될 변수 선언
			
			while((c = fin.read()) != -1){
				
				// 읽어온 데이터를 화면에 출력
				System.out.print((char)c);
			}
			
			fin.close();
			
			
		} catch (IOException e) {
			System.out.println("입출력 오류입니다");
		}
	}

}
