package javaemail;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;

public class FileSend {

	public static void main(String[] args) {

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
		
		session.setDebug(true);
		
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("kimgustjd@naver.com"));
			
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("kimgustjd@naver.com"));
			
			message.setSubject("FileTest");
			
			message.setContent(new MimeMultipart());
			
			Multipart mp = (Multipart) message.getContent();
			
			
		
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
