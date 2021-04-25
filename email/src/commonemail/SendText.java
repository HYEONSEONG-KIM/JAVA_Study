package commonemail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class SendText {

	public static void main(String[] args) throws EmailException {
		
		// 간단한 문자 이메일
		String id = "";
		String pass = "";
		
		Email email = new SimpleEmail();	//Email 클래스 객체를 얻어오기 위한 변수선언
		email.setHostName("smtp.naver.com");	//메일을 이용하기 위한 HostName설정 => "smtp.(사용할서비스).com"
		email.setSmtpPort(465);		// smtp포트 번호 설정
		email.setAuthenticator(new DefaultAuthenticator(id, pass)); // 위에 선언한 id pass
		
		email.setSSLOnConnect(true);	//connection 연결 허용
		email.setFrom("kimgustjd@naver.com");	//보내는 사람
		email.setSubject("testEmail");	// 메일 제목
		email.setMsg("테스트이메일!!!");	// 메일 내용
		email.addTo("kimgustjd2@gmail.com");	// 받는사람
		email.addTo("kimgustjd@naver.com");		// 받는사람
		email.send();	//전송
	}
}
