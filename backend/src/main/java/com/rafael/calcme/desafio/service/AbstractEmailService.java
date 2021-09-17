package com.rafael.calcme.desafio.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.rafael.calcme.desafio.model.Cliente;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String email;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaEmailSender;
	
	@Override
	public void emailConfirmacao(Cliente cliente) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromCliente(cliente);
		envioEmail(sm);
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromCliente(Cliente cliente) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(cliente.getEmail());
		sm.setFrom(email);
		sm.setSubject(cliente.getNome() + " Seus dados chegaram com sucesso.");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(cliente.toString());
		return sm;
	}
	
	protected String htmlFromTemplateCliente(Cliente obj) {
		Context context = new Context();
		context.setVariable("cliente", obj);
		return templateEngine.process("email/email", context);
	}
	
	@Override
	public void emailConfirmationHtml(Cliente obj) {
		try {
		MimeMessage mm = prepareMimeMessageFromCliente(obj);
		envioHtmlEmail(mm);
		} catch (MessagingException e) {
			emailConfirmacao(obj);
		}
	}

	protected MimeMessage prepareMimeMessageFromCliente(Cliente obj) throws MessagingException {
		MimeMessage mimeMessage = javaEmailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getEmail());
		mmh.setFrom(email);
		mmh.setSubject(obj.getNome() + " Seus dados chegaram com sucesso.");
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateCliente(obj), true);
		return mimeMessage;
	}


}
