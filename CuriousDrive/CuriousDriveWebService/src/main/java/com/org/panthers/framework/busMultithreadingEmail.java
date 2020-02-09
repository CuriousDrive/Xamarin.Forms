package com.org.panthers.framework;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.org.panthers.business.busConstant;

public class busMultithreadingEmail extends Thread {

	public String istrToEmailAddress;
	public String istrSubject;
	public String istrHTMLTemplatePath;
	public Object[] iobjTemplateParameters;
	
	public void run() {
		
		try {
			
			String[] to = istrToEmailAddress.split(";");// change accordingly
			busUtil lbusUtil = new busUtil();
			
			String host = busConstant.AdminEmail;
			final String senderEmailAddress = busConstant.SalesEmailAddress;
			final String senderEmailName = busConstant.SalesEmailName;
			final String password = busConstant.MailServerPassword;

			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.port", 587);
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(senderEmailAddress, password);
				}
			});

			// Compose the message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(senderEmailAddress,senderEmailName));
				
				
				for (String strToEmailAddress : to) {
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(strToEmailAddress));
				}
				
				message.setSubject(istrSubject);
				// Now set the actual message
				message.setContent(String.format(lbusUtil.getStringFromFile(istrHTMLTemplatePath), iobjTemplateParameters) , "text/html");
				// send the message
				Transport.send(message);

				System.out.println("message sent successfully...");

			} catch (MessagingException e) {
				e.printStackTrace();
			}

			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
