package commonemail;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class FileURLSend {

	public static void main(String[] args) throws MalformedURLException, EmailException {

		EmailAttachment urlFile = new EmailAttachment();
		// URL클래스를 이용하여 해당 URL의 로고 가져오기
		urlFile.setURL(new URL ( "http://www.apache.org/images/asf_logo_wide.gif"));
		urlFile.setDescription(EmailAttachment.ATTACHMENT);
		urlFile.setDescription("아파치 로고");
		urlFile.setName("Apach로고");
		
		String id = "";
		String pass = "";
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.naver.com");	//메일을 이용하기 위한 HostName설정 => "smtp.(사용할서비스).com"
		email.setSmtpPort(465);		// smtp포트 번호 설정
		email.setAuthenticator(new DefaultAuthenticator(id, pass)); // 위에 선언한 id pass
		
		email.setSSLOnConnect(true);

		email.addTo("kimgustjd@naver.com","kimgustjd");	// 받는사람, 표시될 이름
		email.setFrom("kimgustjd@naver.com","me");		// 보내는 사람, 표시될 이름
		email.setSubject("url로고");
		email.setMsg("url로고");
		email.attach(urlFile);
		
		email.send();
		
	}

}
