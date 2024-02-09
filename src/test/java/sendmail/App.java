package sendmail;

import java.io.File;

import org.testng.annotations.Test;

public class App {
	
	
	@Test
	public void sendMailDemo() {
		GEmailSender gEmailSender = new GEmailSender();
		String to = "tbs.yukta@gmail.com";
		String from = "tbs.mohitk@gmail.com";
		String subject = "Test Message from Gmail API";
		String text = "Test Message Body";
		File file = new File("C:\\Users\\Technobrain\\Downloads\\Download1.pdf");
		gEmailSender.sendEmailWithAttachment(to, from, subject, text, file);
	}

	public static void main1() {
		
		GEmailSender gEmailSender = new GEmailSender();
		String to = "tbs.yukta@gmail.com";
		String from = "tbs.mohitk@gmail.com";
		String subject = "Test Message from Gmail API";
		String text = "Test Message Body";
		File file = new File("C:\\Users\\Technobrain\\Downloads\\Download1.pdf");
		/*
		boolean b = gEmailSender.sendEmail(to, from, subject, text);
		 if(b) {
			 System.out.println("Mail is sent");
		 }else {
			 System.out.println("There is a problem");
		 }
		 */
		
		gEmailSender.sendEmailWithAttachment(to, from, subject, text, file);
	}
	
	
}
