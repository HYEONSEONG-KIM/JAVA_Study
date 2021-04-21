package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 	Q. 'D:/D_Other' 폴더에 있는 '펭귄.jpg' 파일을 'D:/D_Other/연습용' 
 * 	폴더에  '펭귄_복사복.jpg' 파일로 복사하는 프로그램 작성 
 */

public class FileCopy {

	public static void main(String[] args) {
		
		
		File inFile = new File("D:/D_Other/펭귄.jpg");
		File outFile = new File("D:/D_Other/연습용/펭귄_복사복.jpg");
		
		if(!inFile.exists()){
			System.out.println("파일이 없습니다");
			System.exit(0);
		}
		
		try {
			FileInputStream fis = new FileInputStream(inFile);
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream(outFile);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			int c;
			
			while((c = bis.read()) != -1){
				bos.write(c);
			}
			bos.flush();
			
			bis.close();
			bos.close();
			fis.close();
			fos.close();
			
		} catch (IOException e) {
		}
		
	}

}
