package kr.or.ddit.basic;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogginTest {

	// Logger 클래스의 인스턴스를 구하기
	// 형식) Logger.getLogger(현재클래스명.class)
	static Logger logger = Logger.getLogger(LogginTest.class);
	
	
	
	public static void main(String[] args) {
		// log기록 남기기
		// 형식1) Logger객체변수.레벨명("출력할 메시지");
		logger.trace("이것은 Log4j의 [TRACE]레벨의 메시지 입니다.");
		
		// 형식2) Logger객체변수.log(Level.레벨명, "출력할 메세지");
		logger.log(Level.DEBUG, "이것은 Log4j의 [DEBUG]레벨의 메시지 입니다");
		
		// --------------------------------------------------------------
		logger.info("이것은 Log4j의 [INFO]레벨의 메시지 입니다.");
		logger.warn("이것은 Log4j의 [WARN]레벨의 메시지 입니다.");
		logger.error("이것은 Log4j의 [ERROR]레벨의 메시지 입니다.");
		logger.fatal("이것은 Log4j의 [FATAL]레벨의 메시지 입니다.");
		
		
		
	}

}























