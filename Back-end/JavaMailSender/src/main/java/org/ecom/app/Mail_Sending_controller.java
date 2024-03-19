package org.ecom.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@RestController
public class Mail_Sending_controller {

	@Autowired
	private JavaMailSender jms;
	@PostMapping("/sendmail")
	public String sendMail(@RequestParam String email_id)
	{
		MimeMessage message=jms.createMimeMessage();
		MimeMessageHelper helper=new MimeMessageHelper(message);
		try
		{
			helper.setTo(email_id);
			helper.setSubject("Testing Mail Sending API");
			helper.setText("create to test the api");
			return "mail has been sended";
		}
		catch (MessagingException e) {
			
			e.printStackTrace();
			return "cannot send email";
		}
	}
}
