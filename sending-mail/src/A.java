import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class A {

	public static void main(String[] args) throws AddressException, MessagingException {
		final String fromEmail = "test@gmail.com";
		final String password = "test@123";
		final String toMail = "receiver@gmail.com";
		
		Properties prop = new Properties();
		prop.put("mail.smtp.host","smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth","true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		
		Authenticator auth =new Authenticator() {
			protected	PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
			};
			
		
		Session session=Session.getInstance(prop,auth);
		MimeMessage m = new MimeMessage(session);
		m.setFrom(new InternetAddress(fromEmail));
		m.addRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
		System.out.println("mail check");
		m.setSubject("no reply");
		m.setText("hii ");
		System.out.println("mail check 1");
		Transport.send(m);
		System.out.println("message sent successfully");
		
	}
	
}
