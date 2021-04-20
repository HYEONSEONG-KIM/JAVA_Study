package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOTest01 {

	public static void main(String[] args) {
		
		// 입출력의 성능 항상을 위해서 Buffered 스트림을 사용
		
		
		try {
			FileOutputStream fout = new FileOutputStream("D:/D_Other/bufferTest.txt");
			
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(int i = '1'; i <='9'; i++){
				bout.write(i);
				
			}
			bout.flush(); 	// 작업을 종료하기 전에 버퍼에 남아 있는 데이터를 모두 출력
			
			bout.close();	// 퍼버 스트림을 닫으면 자동으로 flush() 명령을 호출하는 효과
							// 그렇지만 버퍼를 이용해서 출력작업을 할 때는 출력이 끝나면 바로 flush()메서드로
							// 버퍼에 남아 있는 데이터를 강제로 출력해 주는 것이 좋음
			
			System.out.println("작업 끝...");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
