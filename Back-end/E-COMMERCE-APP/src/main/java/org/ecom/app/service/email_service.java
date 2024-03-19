package org.ecom.app.service;

import org.ecom.app.model.merchant;
import org.ecom.app.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import  static org.ecom.app.util.application_constants.VERIFY_LINK;
import  static org.ecom.app.util.application_constants_user.VERIFY_LINK_USER;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpServletRequest;
@Service
public class email_service {

	@Autowired
	private JavaMailSender jms;
	
    public String send_mail(merchant m,HttpServletRequest req)
    {
    	String siteurl=req.getRequestURL().toString();
    	String url=siteurl.replace(req.getServletPath(), "");
    	String actual_url=url + VERIFY_LINK + m.getToken();
    	MimeMessage msg=jms.createMimeMessage();
    	MimeMessageHelper help=new MimeMessageHelper(msg);
    	try
    	{
    		help.setTo(m.getEmail());
    		help.setSubject("Account Activation Mail");
    		help.setText(actual_url);
    		jms.send(msg);
    		return "verification Mail Send";
    	}
    	catch (MessagingException e) {
		   
    		e.printStackTrace();
    		return "cannot send the verification mail";
    	}
    }
    public String send_mail(user m,HttpServletRequest req)
    {
    	String siteurl=req.getRequestURL().toString();
    	String url=siteurl.replace(req.getServletPath(), "");
    	String actual_url=url + VERIFY_LINK_USER + m.getToken();
    	MimeMessage msg=jms.createMimeMessage();
    	MimeMessageHelper help=new MimeMessageHelper(msg);
    	try
    	{
    		help.setTo(m.getEmail());
    		help.setSubject("Account Activation Mail");
    		help.setText(actual_url);
    		jms.send(msg);
    		return "verification Mail Send";
    	}
    	catch (MessagingException e) {
		   
    		e.printStackTrace();
    		return "cannot send the verification mail";
    	}
    }
}
