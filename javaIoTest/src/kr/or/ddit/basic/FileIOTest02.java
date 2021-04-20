package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileIOTest02 {

	public static void main(String[] args) {
		
		// 파일에 출력(write)하기 => FileOutputstream객체 사용
		
		try {
			// 지정한 파일이 없으면 새로 생성, 파일이 있으면 새로운 내욜으로 덮어쓰기
			FileOutputStream fos = new FileOutputStream("D:/D_Other/out.txt");
			
			for(char ch = 'A'; ch <= 'Z'; ch++){
				fos.write(ch);
			}
			
			System.out.println("출력 작업 완료!!");
			
			fos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
