package sendmail;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class Main {

	public static void main(String[] args) throws AddressException, MessagingException {

		MonitoringMail m = new MonitoringMail();
		m.sendMail(TestConfig.server, TestConfig.from, TestConfig.to, TestConfig.subject, TestConfig.messageBody, TestConfig.attachmentPath, TestConfig.attachmentName);
	}

}
