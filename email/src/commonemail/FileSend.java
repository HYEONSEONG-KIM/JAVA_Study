package commonemail;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class FileSend {

	public static void main(String[] args) throws EmailException {
		
		String id = "";
		String pass = "";
		
		EmailAttachment file = new EmailAttachment();	// 파일을 전송하기 위해 파일을 담은 객체선언
		file.setPath("C:/Download/3.jpg");				// 해당 파일이 있는 경로
		file.setDescription(EmailAttachment.ATTACHMENT);	//???저도잘...
		file.setDescription("펭귄");
		file.setName("펭귄!!");							// 전송시 파일이름
		
		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.naver.com");	//메일을 이용하기 위한 HostName설정 => "smtp.(사용할서비스).com"
		email.setSmtpPort(465);		// smtp포트 번호 설정
		email.setAuthenticator(new DefaultAuthenticator(id, pass)); // 위에 선언한 id pass
		
		email.setSSLOnConnect(true);

		email.addTo("kimgustjd@naver.com","kimgustjd");	// 받는사람, 표시될 이름
		email.setFrom("kimgustjd@naver.com","me");		// 보내는 사람, 표시될 이름
		email.setSubject("풍경사진");
		email.setMsg("풍경");
		email.attach(file);
		
		email.send();

	}

}
