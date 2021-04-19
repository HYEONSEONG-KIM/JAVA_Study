package kr.or.ddit.basic;

import java.awt.DisplayMode;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {

	public static void main(String[] args) {
		
		FileTest03 test = new FileTest03();
		File file = new File("C:\\Users\\PC-21");
		test.displayFileList(file);
			
	}

	// 디렉토리를 매개변수로 받아서 해당 디렉토리에 있는 모든 파일과 디렉토리 목록을 출력하는 메서드
	public void displayFileList(File dir){
		if(!dir.isDirectory()){
			System.out.println(" 디렉토리(폴더)만 사용가능 합니다.");
			System.out.println(" 작업을 종료합니다.");
			return;
		}
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용");
		
		// 지정된 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구함
		File[] files = dir.listFiles();
//		String[] strFile = dir.list();
		
		// 출력할 날짜 형식 만들기
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
		
		// 가져온 파일과 디렉토리 목록 개수만큼 반복
		System.out.println("==========================================================================================");
		System.out.printf("%-40s\t%-5s\t%-20s\t%s" , "날짜", "속성", "크기", "파일명");
		System.out.println();
		System.out.println("==========================================================================================");
		for(int i = 0; i < files.length; i++){
			String fileName = files[i].getName();
			String attr = "";	// 파일의 속성(읽기, 쓰기, 히든, 디렉토리여부)
			String size = "";	// 파일 크기를 문자열로 저장할 변수
			
			
			if(files[i].isDirectory()){
				attr = "<DIR>";
			}else{
				size = String.valueOf(files[i].length());
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			System.out.printf("%-15s\t%-5s\t%-8s\t%s\n",
					df.format(new Date(files[i].lastModified())),
					attr, size, fileName);
			System.out.println("------------------------------------------------------------------------------------------");
		}
		
		
	}
	
}






























