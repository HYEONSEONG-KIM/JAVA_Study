package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JPanel;

public class DialogTest {

	public static void main(String[] args) {
		File inFile = null;
		File outFile = null;
		
		JFileChooser fileChooser = new JFileChooser();
		
		// 파일 선택창에 나타날 폴더 설정
		fileChooser.setCurrentDirectory(new File("D:/D_Other"));
		
		int result = fileChooser.showOpenDialog(new JPanel());	// 열기용
		
		// 파일 선택창에서 '선택한 파일 정보' 가져오기
		if(result == JFileChooser.APPROVE_OPTION){	// 열기버튼 또는 저장버튼을 클릭하면...
			inFile = fileChooser.getSelectedFile();
			
		}
		
		result = fileChooser.showSaveDialog(new JPanel());	// 저장용
		if(result == JFileChooser.APPROVE_OPTION){
			outFile = fileChooser.getSelectedFile();
		}
		
//		File inFile = new File("D:/D_Other/펭귄.jpg");
//		File outFile = new File("D:/D_Other/연습용/펭귄_복사복.jpg");
		
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
