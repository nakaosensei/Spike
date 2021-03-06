package br.com.model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author nakao
 */
public class Mail {
    
    public static void sendMail(String msgTitle,String msg,String destinationMail){
        Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
 
            Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication(){
                    return new PasswordAuthentication("nksecuresystem@gmail.com", "yukari100");
                }});
             session.setDebug(false);
 
            try { 
               Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress("nksecuresystem@gmail.com")); 
                  Address[] toUser = InternetAddress.parse(destinationMail);   
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(msgTitle);//Assunto
                  message.setText(msg);
                  Transport.send(message); 
 
             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    }
    
    
    
    
    public static void main(String[] args) {
        Mail.sendMail("TESTE", "TESTE DE ENVIO", "nakaosensei@gmail.com");
    }
}
