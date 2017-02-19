/**
 * 
 */
package com.neu.gd.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.neu.gd.pojo.LoginPojo;

/**
 * @author GD
 *
 */
public final class EmailSending {
	private static final String username = "vinniBhole@gmail.com";
	private static final String password = "vinni@123";

	public static int sendMail(LoginPojo loginPojo, String body, String subject){

		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.user", username);
		prop.put("mail.smtp.password", password);
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try{
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(username));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(loginPojo.getUsername()));
			mimeMessage.setSubject(subject);
			mimeMessage.setText(body);
			Transport.send(mimeMessage);
			return 0;
		}
		catch(MessagingException ex){
			System.out.println("Error in sending email--->"+ex.getMessage());
			return 1;
		}
	}

	public static int sendContactUs(String sender, String body, String subject){

		Properties prop = new Properties();
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.user", username);
		prop.put("mail.smtp.password", password);
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try{
			MimeMessage mimeMessage = new MimeMessage(session);
			mimeMessage.setFrom(new InternetAddress(username));
			mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(username));
			mimeMessage.setSubject(subject);
			mimeMessage.setText("Sender:- "+sender+".   "+body);
			Transport.send(mimeMessage);
			return 0;
		}
		catch(MessagingException ex){
			System.out.println("Error in sending email--->"+ex.getMessage());
			return 1;
		}
	}
	
	
	
	private int sendConfirmationEmail(LoginPojo loginPojo, MailSender mailSender, SimpleMailMessage templateMessage){

		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		// Get a Properties object
		Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", "smtp.gmail.com");
		props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.store.protocol", "pop3");
		props.put("mail.transport.protocol", "smtp");

		SimpleMailMessage msg = new SimpleMailMessage(templateMessage);
		msg.setTo(loginPojo.getUsername());

		msg.setText("Dear, " + loginPojo.getPerson().getFirstName()+" "+loginPojo.getPerson().getLastName()+ ", thank you for signing up.");

		try{
			mailSender.send(msg);
			return 0;
		}
		catch (MailException ex) {
			System.out.println(ex.getMessage());
			return 1;
		}
	}
}
