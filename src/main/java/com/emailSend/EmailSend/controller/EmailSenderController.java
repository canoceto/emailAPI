package com.emailSend.EmailSend.controller;

import com.emailSend.EmailSend.model.EmailDTO;
import com.emailSend.EmailSend.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class EmailSenderController {

    final EmailService emailService;

    public EmailSenderController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(path = "object/sendmail")
    public String sendMail(@RequestBody EmailDTO params) {
        emailService.sendEmail(params.emailTo, params.subject, params.txt);
        return "ok";
    }
}
