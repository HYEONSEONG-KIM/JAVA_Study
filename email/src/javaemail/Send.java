package javaemail;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Send {
	public static void main(String[] args) throws AddressException {
		
		
		
		final String user = "";
		final String pass = "";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.naver.com"); 
		prop.put("mail.smtp.port", 587); 
		prop.put("mail.smtp.auth", "true");

		/*
		 * 구글 smtp 설정
		 * prop.put("mail.smtp.host","smtp.gmail.com"); 
		 * prop.put("mail.smtp.port",465);
		 * prop.put("mail.smtp.auth","true"); 
		 * prop.put("mail.smtp.ssl.enable","true");
		 * prop.put("mail.smtp.ssl.trust","smtp.gmail.com");
		 */
	
		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			
			//한명에게 메일전송
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("kimgustjd@naver.com"));

			/*
			 * // 다중 메일 전송 InternetAddress[] toarr = new InternetAddress[2];
			 * 
			 * toarr[0] = new InternetAddress("kimgustjd@naver.com"); toarr[1] = new
			 * InternetAddress("kimgustjd2@gmail.com");
			 * message.addRecipients(Message.RecipientType.TO, toarr);
			 */
			
			message.setSubject("javaEmail Test");
			
			message.setText("javaEmail");
			
			Transport.send(message);
			System.out.println("메세지 전송 성공...");
		
		
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	
	
	
	
	
	}
	
}









