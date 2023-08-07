package org.rehab.email.service;

import java.io.File;

import org.rehab.email.dto.EmailDto;
import org.springframework.stereotype.Service;

@Service
public interface IEmailService {
    void sendEmail(String toUser, String subject, String message);
    void sendEmailKafka(EmailDto emailDto);

    void sendEmailWithFile(String [] toUser, String subject, String message, File file);
}