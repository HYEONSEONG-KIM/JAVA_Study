package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {

	public static void main(String[] args) {

		// File 객체 만들기 연습
		
		// 1. new File(String 파일 또는 경로명)
		//	=> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자 '/'를 사용하거나 '\'를 사용
//		File file1 = new File("D:/D_Other/text.txt");	// 구분문자를  '슬래쉬(/)'로 사용
		File file1 = new File("D:\\D_Other\\text.txt");	// 구분문자를 '역슬래쉬(\)'로 사용

		System.out.println("파일 명 : " + file1.getName());
		System.out.println("디렉토리 인가? : " + file1.isDirectory());
		System.out.println("파일 인가? : " + file1.isFile());
		System.out.println();
		
		File file2 = new File("d:/d_other");
		System.out.println("폴더 명 : " + file2.getName());
		System.out.println("디렉토리인가? : " + file2.isDirectory());
		System.out.println("파일인가? : " + file2.isFile());
		System.out.println();
		
		// 2. new File(File parent, String child)
		//		=> 'parent' 디렉토리 안에 있는  'child'파일을 갖음
		File file3 = new File(file2, "text.txt");
		
		System.out.println("파일 명 : " + file3.getName());
		System.out.println("디렉토리 인가? : " + file3.isDirectory());
		System.out.println("파일 인가? : " + file3.isFile());
		System.out.println();
		
		// 3. new File(String parent, String child)
		//		=> 'parent' 디렉토리 안에 있는  'child'파일을 갖음
		File file4 = new File("D:/D_Other", "text.txt");
		System.out.println("파일 명 : " + file4.getName());
		System.out.println("디렉토리 인가? : " + file4.isDirectory());
		System.out.println("파일 인가? : " + file4.isFile());
		System.out.println();
		System.out.println("-------------------------------------------------");
		
		
		/*
		 * 	- 디렉토리(폴더) 만들기
		 * 	1. mkdir() => File객체의 경로 중 마지막 위치의 디렉토리를 만들기
		 * 			=> 반환값 : boolean
		 * 			=> 중간부분의 경로가 모두 만들어져 있어야 마지막 위치의 경로를 만들수 있음
		 * 	2. mkdirs() => 중간 부분의 경로가 없으면 중간부분의 경로도 같이 만들어 줌
		 */

		
		File file5 = new File("d:/d_other/연습용");	// 디스크에 존재할지 않는 정보를 이용해서 File객체 생성
//		System.out.println("디렉토리 인가? : " + file5.isDirectory());
//		System.out.println("파일 인가? : " + file5.isFile());
		System.out.println(file5.getName() + "의 존재 여부 : " + file5.exists());
		System.out.println();
		
		
		if(!file5.exists()){
			if(file5.mkdir()){
				System.out.println(file5.getName() + " 만들기 성공!!");
			}else{
				System.out.println(file5.getName() + " 만들기 실패...");
			}
		}
		
		
		File file6 = new File("D:/D_Other/test/java/src");
		
		if(!file6.exists()){
			if(file6.mkdirs()){
				System.out.println(file6.getName() + " 만들기 성공!!");
			}else{
				System.out.println(file6.getName() + " 만들기 실패...");
			}
		}
	}

}














