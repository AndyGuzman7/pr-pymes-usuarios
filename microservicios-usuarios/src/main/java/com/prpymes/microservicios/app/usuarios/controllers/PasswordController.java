package com.PyMes.usuarios_cliente.controllers;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.PyMes.usuarios_cliente.models.entity.Person;
import com.PyMes.usuarios_cliente.services.EmailService;
import com.PyMes.usuarios_cliente.services.PersonService;

@Controller
public class PasswordController {

	@Autowired
	private PersonService personService;
	
	private Person person;

	@Autowired
	private EmailService emailService;

	@Autowired
	
	// Direccionamiento a la página para reestablecer contraseña
	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public ModelAndView displayForgotPasswordPage() {
		return new ModelAndView("forgotPassword");
    }
    
    
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView processForgotPasswordForm(ModelAndView modelAndView, @RequestParam("email") String personEmail, HttpServletRequest request) {

		// Buscar el email en la base de datos
		Optional<Person> optional = personService.findByEmail(personEmail);

		if (!optional.isPresent()) {
			modelAndView.addObject("errorMessage", "No se encontró una cuenta con ese email");
		} else {
			

			String appUrl = request.getScheme() + "://" + request.getServerName();
			
			// email
			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("support@demo.com");
			passwordResetEmail.setTo(person.getEmail());
			passwordResetEmail.setSubject("Reestablecimiento de contraseña");
			passwordResetEmail.setText("Para reestablecer su contraseña, haga click en el siguiente link:\n" + appUrl);
			
			emailService.sendEmail(passwordResetEmail);

			
			modelAndView.addObject("successMessage", "Se envió un link para reestablecer su contraseña al correo " + personEmail);
		}

		modelAndView.setViewName("forgotPassword");
		return modelAndView;

	}

	// formulario de recuperacion
	@RequestMapping(value = "/reset", method = RequestMethod.GET)
	public ModelAndView displayResetPasswordPage(ModelAndView modelAndView, @RequestParam("token") String token) {
		
		Optional<Person> person = personService.findByEmail(token);

		if (person.isPresent()) { // 
			modelAndView.addObject("resetToken", token);
		} else { 
			modelAndView.addObject("errorMessage", "Link inválido.");
		}

		modelAndView.setViewName("resetPassword");
		return modelAndView;
	}

	// 
	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public ModelAndView setNewPassword(ModelAndView modelAndView, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

		
		Optional<Person> person = personService.findByEmail(requestParams.get("token"));

		
		if (person.isPresent()) {
			
			Person resetUser = person.get(); 
            
			// nueva contraseña  
            resetUser.setPassword(requestParams.get("password"));
           

			// guardar
			personService.save(resetUser);

			
			redir.addFlashAttribute("successMessage", "Ha reestablecido su contraseña exitosamente");

			modelAndView.setViewName("redirect:login");
			return modelAndView;
			
		} else {
			modelAndView.addObject("errorMessage", "No se puede utilizar esta contraseña");
			modelAndView.setViewName("resetPassword");	
		}
		
		return modelAndView;
   }
   
    //
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ModelAndView handleMissingParams(MissingServletRequestParameterException ex) {
		return new ModelAndView("redirect:login");
	}
}