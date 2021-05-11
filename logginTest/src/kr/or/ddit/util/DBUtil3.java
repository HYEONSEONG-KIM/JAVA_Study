package kr.or.ddit.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

// JDBC드라이버를 로딩하고 Connection객체를 생성해서 반환하는 메서드로 구성된 class

// ResourceBundle객체를 이용하여 처리하기
public class DBUtil3 {
	private static final Logger logger = Logger.getLogger(DBUtil3.class);
	
	static ResourceBundle bundle;	// ResourceBundle객체 변수 선언
	 
	// static 초기화 블럭
	static{
		bundle = ResourceBundle.getBundle("dbinfo");
		logger.info("ResourceBundle객체 생성 완료 - dbinfo.properties파일 읽기");
		try {
			Class.forName(bundle.getString("driver"));
			logger.info("DB드라이버 로딩 성공...");
		} catch (ClassNotFoundException e) {
			//System.out.println("드라이버 로딩 실패...");
			logger.error("DB드라이버 로딩 실패..." + e.getMessage());
		}
	}
	
	public static Connection getConnection(){
		
		Connection con;
		try {
			/*
			 * return DriverManager.getConnection( bundle.getString("url"),
			 * bundle.getString("user"),bundle.getString("pass"));
			 */
			con = DriverManager.getConnection( bundle.getString("url"),
					 bundle.getString("user"),bundle.getString("pass"));
			logger.info("오라클 연결성공!!");
			return con;
		} catch (SQLException e) {
//			System.out.println("오라클 연결 실패...");
			logger.error("오라클 연결 실패 : " + e);
			return null;
		}
	}
	
	
	
}





















