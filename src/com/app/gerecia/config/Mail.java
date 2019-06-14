/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.gerecia.config;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author rique
 */
public class Mail {
    
    public String send(String smtp, String from, String port, String pass,
            String name,String to,String assunto,String mensg) {
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtp);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);
        props.put("mail.smtp.from", from);
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from,pass);
            }
        });

        session.setDebug(true);
        String out ;
        
        try {

            Message message = new MimeMessage(session);
            InternetAddress me = new InternetAddress(from);
            me.setPersonal(name);

            Address[] toUser = InternetAddress
                    .parse(to);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(assunto);
            message.setText(mensg);
            Transport.send(message);
            return "Enviado com sucesso para "+to;
        } catch (MessagingException e) {
            return "Erro ao envia LOG:\n" + e.toString() + "\n Caso duvidas contatar o fonecedor do sistema";
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE, null, ex);
            return "Erro ao envia LOG:\n" + ex.toString();
        }
            
    }
}
