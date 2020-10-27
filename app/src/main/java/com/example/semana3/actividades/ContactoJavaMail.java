package com.example.semana3.interfaces;

import android.content.Context;
import android.os.AsyncTask;


import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class ContactoJavaMail extends AsyncTask<Void,Void,Void> {
    private Context context;
    private String mail, asunto, mensaje;

    public ContactoJavaMail(Context context, String mail, String asunto, String mensaje) {
        this.context = context;
        this.mail = mail;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("tucompanerodemates@gmail.com", "Faraon951109mate");
            }
        });

        try {
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress("tucompanerodemates@gmail.com"));
            mimeMessage.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(mail)));
            mimeMessage.setSubject(asunto);
            mimeMessage.setText(mensaje);
            Transport.send(mimeMessage);
            
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
