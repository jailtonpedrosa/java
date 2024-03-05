package com.adm.emailservice.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adm.emailservice.adapters.EmailSenderGateway;
import com.adm.emailservice.core.EmailSenderUseCase;

@Service
public class EmailSenderService implements EmailSenderUseCase {

	private final EmailSenderGateway emailSenderGateway;
	
	@Autowired
	public EmailSenderService(EmailSenderGateway emailGateway) {
		this.emailSenderGateway = emailGateway;
	}
	
	@Override
	public void sendEmail(String to, String subject, String body) {
		this.emailSenderGateway.sendEMail(to, subject, body);
	}
}
