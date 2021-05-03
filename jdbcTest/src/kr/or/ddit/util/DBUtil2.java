package kr.or.ddit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// JDBC드라이버를 로딩하고 Connection객체를 생성해서 반환하는 메서드로 구성된 class
public class DBUtil2 {
	
	static Properties prop;
	 
	// static 초기화 블럭
	static{
		
		prop = new Properties();
		File f= new File("res/dbinfo.properties");
		FileInputStream fin = null;
		try {
			fin = new FileInputStream(f);
			prop.load(fin);
			
			Class.forName(prop.getProperty("driver"));
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		} catch (FileNotFoundException e) {
			System.out.println("드라이버 로딩 실패... ==> 설정 파일이 없습니다");
		} catch (IOException e) {
			System.out.println("드라이버 로딩 실패... ==> 파일 입출력 오류...");
		}finally{
			if(fin != null) try{ fin.close();} catch(IOException e){}
		}
	}
	
	public static Connection getConnection(){
		try {
		/*	return DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "PC21", "java");*/
			
			return DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),prop.getProperty("pass"));
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패...");
			return null;
		}
	}
	
	
	
}





















