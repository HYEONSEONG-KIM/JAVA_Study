package kr.or.ddit.basic;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileTest02 {

	public static void main(String[] args) {
		
		File f1 = new File("D:/D_Other/text.txt");
		
		System.out.println(f1.getName() + "의 크기 : " + f1.length() + "bytes");
		System.out.println("path : " + f1.getPath());	//객체 생성시 지정한 경로
		System.out.println("absolutePath : " + f1.getAbsolutePath());	//절대 경로
		System.out.println();
		
		File f2 = new File(".");
		System.out.println("path : " + f2.getPath());
		System.out.println("absolutePath : " + f2.getAbsolutePath());
		System.out.println("------------------------------------------------");
		System.out.println();
		
		//Java프로그램의 실행 위치 구하기
		
		// 방법1) File객체 이용(상대 경로에서 절대 경로로 변환)
		File f3 = new File("");
		System.out.println("현재 실행중인 절대 경로 : " + f3.getAbsolutePath());
		
		// 방법2) System.getProperty("user.dir") 명령 이용
		String path1 = System.getProperty("user.dir");
		System.out.println("현재 실행중인 절대 경로 : " + path1);

		//방법3) Path객체 이용(상대 경로에서 절대 경로로 변환)
		Path rePath = Paths.get("");	// 현재 위치를 나타내는 경로
		String path2 = rePath.toAbsolutePath().toString();
		System.out.println("현재 실행중인 절대 경로 : " + path2);
		
		
		
	}

}















