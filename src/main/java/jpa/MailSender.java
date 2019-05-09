package jpa;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	Properties properties = System.getProperties();

	public MailSender() {
		properties.put("mail.smtp.host", "localhost");
		properties.put("mail.smtp.port", "25");
	}

	public void sendMail(String to, String from) {
		Session session = Session.getDefaultInstance(properties, null);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Sondage pour la prochaine réunion");
			message.setContent("<h1>Doodle : </h1>", "text/html");
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}