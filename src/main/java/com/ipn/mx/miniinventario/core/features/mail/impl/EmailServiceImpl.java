package com.ipn.mx.miniinventario.core.features.mail.impl;

import com.ipn.mx.miniinventario.core.features.mail.EmailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void enviarCorreoElectronico(String to, String subject, String text){
        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje, "UTF-8");

        try {
            helper.setFrom("certboy@gmail.com", "Envio de correo mediante spring");
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);

            mailSender.send(mensaje);
            System.out.println(("Correo enviado con exito a " + to));
        } catch (Exception ex) {
             ex.printStackTrace();
        }
    }
}
