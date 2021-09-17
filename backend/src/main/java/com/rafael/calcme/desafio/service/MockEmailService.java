package com.rafael.calcme.desafio.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailService extends AbstractEmailService{
	
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailService.class);

	@Override
	public void envioEmail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email");
		LOG.info(msg.toString());
		LOG.info("email enviado");
	}

	@Override
	public void envioHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email HTML");
		LOG.info(msg.toString());
		LOG.info("email enviado");
		
	}

}
