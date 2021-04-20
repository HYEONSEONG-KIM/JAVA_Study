package kr.or.ddit.basic;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileIOTest04 {

	public static void main(String[] args) {

		// 사용자가 입력한 내용을 그대로 파일로 저장

		try {
			// system.in => 콘솔(표준 입출력 장치) 입력 스트림(byte 기반의 입력 스트림)
			
			// 입력용 byte기반 스트림을 문자기반 스트림으로 변환해 줌

			InputStreamReader isr = new InputStreamReader(System.in);
			
			// 출력용 문자기반 스트림 객체 생성
			FileWriter fw = new FileWriter("D:/D_Other/testChat.txt");
			
			System.out.println("아무 내용이나 입력 (입력의 끝은 Crtl + z)");
			
			int c;
			
			while((c = isr.read()) != -1){
				
				fw.write(c); 	// 콘솔로 입력받은 데이터를 파일에 출력
				
			}
			
			isr.close();
			fw.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
