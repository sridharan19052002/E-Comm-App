package org.ecom.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class Mail_Sending_controller {

	@Autowired
	private JavaMailSender jms;
	
	private String token;

	@PostMapping("/sendmail")
	public String sendMail(HttpServletRequest request, @RequestParam String email_id) {
		token="abcdefg";
		String siteurl = request.getRequestURL().toString();
		String url = siteurl.replace(request.getServletPath(), "/verify") + "?token=" + token;
		MimeMessage message = jms.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		try {
			helper.setTo(email_id);
			helper.setSubject("Account Verification");
			helper.setText(url);
			jms.send(message);
			return "mail has been sended";
		} catch (MessagingException e) {

			e.printStackTrace();
			return "cannot send email";
		}
	}
	@GetMapping("/verify")
	public String verify(@RequestParam String token)
	{
		if(this.token.equals(token))
		{
			return "Verification Successfully";
		}
		else
		{
			return "cannot verify";
		}
	}
}
