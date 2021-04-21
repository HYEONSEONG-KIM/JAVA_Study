package kr.or.ddit.basic;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {

	public static void main(String[] args) {
		
		try {
			FileOutputStream fos = new FileOutputStream("D:/D_Other/test.dat");
			
			// 자료형 단위로 출력하는 보조스트림 객체 생성(DataOutputStream객체)
			DataOutputStream dos = new DataOutputStream(fos);
			
			dos.writeInt(200);	// 정수형 자료 출력
			dos.writeFloat(256.45f);	// 실수형 자료 출력
			dos.writeBoolean(true); 	// 논리형 자료 출력
			dos.writeUTF("안녕123");	// 문자열 자료 출력
			
			System.out.println("출력 완료...");
			
			dos.close();
			
			// -------------------------------------------------------
			
			// 파일에 출력한 자료 읽어오기
			FileInputStream fis = new FileInputStream("D:/D_Other/test.dat");
			
			DataInputStream dis = new DataInputStream(fis);
			
			// DataInputStream으로 자료를 읽어올 때는 출력할 때의 순서와 같은 순서로 읽어와야 함
			System.out.println("정수형 자료 : " + dis.readInt());
			System.out.println("실수형 자료 : " + dis.readFloat());
			System.out.println("논리형 자료 : " + dis.readBoolean());
			System.out.println("문자열 자료 : " + dis.readUTF());
			
			System.out.println("읽기 작업 완료...");
			dis.close();
		} catch (IOException e) {
		}
		
		
	}

}
