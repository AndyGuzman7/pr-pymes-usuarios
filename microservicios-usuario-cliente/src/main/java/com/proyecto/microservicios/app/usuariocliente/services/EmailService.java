package com.proyecto.microservicios.app.usuariocliente.services;

import com.proyecto.microservicios.app.usuariocliente.dto.EmailValuesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    @Autowired
    TemplateEngine templateEngine;

    @Value("${mail.urlFront}")
    private String urlFront;

    public void sendEmail(EmailValuesDTO dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("quintanillalucas71@gmail.com");
        message.setTo(dto.getMailTo());
        message.setSubject("Restablecer Contraseña");
        message.setText("Para restablecer su contraseña, haga click en el siguiente enlace: " + urlFront );

        javaMailSender.send(message);
    }
}
