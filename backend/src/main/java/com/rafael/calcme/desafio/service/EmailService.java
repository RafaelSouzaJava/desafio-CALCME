package com.rafael.calcme.desafio.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.rafael.calcme.desafio.model.Cliente;

public interface EmailService {
	
	void emailConfirmacao(Cliente cliente);	
	
	void envioEmail(SimpleMailMessage msg);
	
	void emailConfirmationHtml(Cliente obj);
	
	void envioHtmlEmail(MimeMessage msg);

}
