package kr.or.ddit.basic;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 	Q. 'D:/D_Other' 폴더에 있는 '펭귄.jpg' 파일을 'D:/D_Other/연습용' 
 * 	폴더에  '펭귄_복사복.jpg' 파일로 복사하는 프로그램 작성 
 */

public class FileCopy {

	public static void main(String[] args) {
		
		File file = new File("D:/D_Other/펭귄.jpg");
		File files = new File("D:/D_Other/연습용/펭귄_복사복.jpg");
		
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(files);
			
			int c;
			
			while((c = fis.read()) != -1){
				fos.write(c);
			}
			fis.close();
			fos.close();
			
		} catch (IOException e) {
		}
		
	}

}
