package com.proyecto.microservicios.app.usuariocliente.controllers;

import com.proyecto.microservicios.app.usuariocliente.dto.Mensaje;
import com.proyecto.microservicios.app.usuariocliente.dto.ChangePasswordDTO;
import com.proyecto.microservicios.app.usuariocliente.dto.EmailValuesDTO;
import com.proyecto.microservicios.app.usuariocliente.services.EmailService;
import com.proyecto.microservicios.app.usuariocliente.models.entity.Person;
import com.proyecto.microservicios.app.usuariocliente.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;
@EnableEurekaClient
@RestController
@RequestMapping("/email-password")
@CrossOrigin
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    PersonService personService;


    @Value("${spring.mail.username}")
    private String mailFrom = "quintanillalucas71@gmail.com";

    @PostMapping("/send-email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailValuesDTO dto) {
    	emailService.sendEmail(dto);
        return new ResponseEntity("Correo con plantilla enviado con éxito", HttpStatus.OK);
    }

}
