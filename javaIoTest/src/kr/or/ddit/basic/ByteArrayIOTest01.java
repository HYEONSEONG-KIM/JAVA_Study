package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {

	public static void main(String[] args) {
		
		byte[] inSrc = {1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		// 입력용 스트림과 출력용 스트림 객체 생성
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);	// 입력용
		ByteArrayOutputStream output = new ByteArrayOutputStream();		// 출력용
		
		int data;	// 읽어온 데이터가 저장될 변수
		
		// read()메서드 => 더 이상 읽어올 자료가 없으면 -1반환
		while((data = input.read()) != -1){
			// 읽어온 데이터를 사용하는 코드를 작성
			
			// 읽어온 데이터를 출력
			output.write(data);
		}
		
		// 출력된 데이터를 스트림에 저장되어 있는데 이 데이터를 꺼내와 배열에 저장
		outSrc = output.toByteArray();
		
		try {
			input.close();
			output.close();
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		System.out.println(" inSrc =>" + Arrays.toString(inSrc));
		System.out.println(" outSrc =>" + Arrays.toString(outSrc));
	}

}



























