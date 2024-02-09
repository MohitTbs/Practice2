package sendmail;

import java.io.File;
import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

public class GEmailSender {

	public boolean sendEmail(String to, String from, String subject, String text) {

		boolean flag = false;

		// Logic 
		// smtp properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		String username = "tbs.mohitk";
		String password ="qfdj qylq gqzh ywxq";
		
		// Session 
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username,password);
			}
		});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(text);
			
			Transport.send(message);
			
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}

	
	public boolean sendEmailWithAttachment(String to, String from, String subject, String text, File file) {
		boolean flag = false;

		// Logic 
		// smtp properties
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		String username = "tbs.mohitk";
		String password ="qfdj qylq gqzh ywxq";
		
		// Session 
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(username,password);
			}
		});
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			
			MimeBodyPart part1 = new MimeBodyPart();
			part1.setText(text);
			
			
			
			MimeBodyPart part2 = new MimeBodyPart();
			part2.attachFile(file);
			
			MimeBodyPart part3 = new MimeBodyPart();
			part3.attachFile(new File("C:\\Users\\Technobrain\\Downloads\\PRE377431_Rad_PSL.pdf"));
			
			MimeMultipart mimeMultipart = new MimeMultipart();
			mimeMultipart.addBodyPart(part1);
			mimeMultipart.addBodyPart(part2);
			mimeMultipart.addBodyPart(part3);
			
			message.setContent(mimeMultipart);
			
			Transport.send(message);
			
			flag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
	
}
