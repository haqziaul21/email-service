package com.email.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.email.domain.MailDomain;

@Service
public class MailService {

	private final JavaMailSender mailSender;

	public MailService(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public String sendMail(MailDomain mailDomain) {
		String responseString="";
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(mailDomain.getTo());
			message.setSubject(mailDomain.getSubject());
			message.setText(mailDomain.getBody());

			mailSender.send(message);
			responseString="Mail send successfully";
		} catch (Exception ex) {
			responseString=ex.getLocalizedMessage();
		}
		
		return responseString;
	}
}
