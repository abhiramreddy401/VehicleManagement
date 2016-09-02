package edu.abhi.springmvc.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.abhi.springmvc.vo.ForgetCredentialsVO;

@Repository("ForgetCredentialsDao")
public class ForgetCredentialsDaoImpl implements ForgetCredentialsDao{
	
	@PersistenceContext        
	private EntityManager entityManager;
	
	 public void setEntityManager(EntityManager entityManager) {
	        this.entityManager = entityManager;
	  }
	 

	@Override
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,isolation = Isolation.DEFAULT)
	public String sendCredentials(ForgetCredentialsVO forgetCredentialsVO,String to,String password)throws Exception {
		// TODO Auto-generated method stub
		String returnValue = sendMail(forgetCredentialsVO,to,password);	
		entityManager.persist(forgetCredentialsVO);
	   	entityManager.flush();
	   	
	   	return returnValue;
	}
	
	public String sendMail(ForgetCredentialsVO forgetCredentialsVO,String toAddress,String password)
	{	    
		   
		    // Sender's email ID needs to be mentioned
		     String from = "ramabhi@yahoo.com";
		     String pass ="venianiabhi";
		    // Recipient's email ID needs to be mentioned.
		   //String to = "srinivas.rbs@gmail.com";
		     String to = toAddress;
		   String host = "smtp.mail.yahoo.com";
    
		   
		   String returnValue = "";
		   // Get system properties
		   Properties properties = System.getProperties();
		   // Setup mail server
		   properties.put("mail.smtp.starttls.enable", "true");
		   properties.put("mail.smtp.host", host);
		   properties.put("mail.smtp.user", from);
		   properties.put("mail.smtp.password", pass);
		   properties.put("mail.smtp.port", "587");
		   properties.put("mail.smtp.auth", "true");

		   // Get the default Session object.
		   Session session = Session.getDefaultInstance(properties);

		   try{
		      // Create a default MimeMessage object.
		      MimeMessage message = new MimeMessage(session);

		      // Set From: header field of the header.
		      message.setFrom(new InternetAddress(from));

		      // Set To: header field of the header.
		      message.addRecipient(Message.RecipientType.TO,
		                               new InternetAddress(to));

		      // Set Subject: header field
		      message.setSubject("John Rentals Credentials!");

		      // Now set the actual message
		      message.setText("The Userid is :"+forgetCredentialsVO.getUserId()+"and the Password is :"+password);

		      // Send message
		      Transport transport = session.getTransport("smtp");
		      transport.connect(host, from, pass);
		      transport.sendMessage(message, message.getAllRecipients());
		      transport.close();
		      returnValue = "Success"; 
		      
		      
		   }catch (MessagingException mex) {
		      mex.printStackTrace();
		   }
		  return returnValue;
		}
		
		

}
