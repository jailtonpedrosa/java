package com.adm.emailservice.adapters;

public interface EmailSenderGateway {	
	void sendEMail(String to, String subject, String body);
}
