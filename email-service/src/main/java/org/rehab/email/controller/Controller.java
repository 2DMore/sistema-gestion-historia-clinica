package org.rehab.email.controller;

import lombok.extern.log4j.Log4j2;

import org.rehab.email.dto.EmailDto;
import org.rehab.email.dto.EmailFileDto;
import org.rehab.email.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@RestController
@RequestMapping("/v1")
@Log4j2
public class Controller {
    @Autowired
    private IEmailService emailService;
    
    @Autowired
    private KafkaTemplate<String, EmailDto> kafkaTemplate;
    

    @PostMapping("/email")
    public ResponseEntity<?> receiveEmail(@RequestBody EmailDto emailDto) {
        log.info("Mensaje recibido:");
        log.info(emailDto.toString());
        //emailService.sendEmail(emailDto.getToUser(), emailDto.getSubject(), emailDto.getMessage());
        //kafkaTemplateString.send("uady-mail-topic", "Mensaje enviado " + UUID.randomUUID());
        return (ResponseEntity<?>) ResponseEntity.ok("mensaje enviado");
    }

    @PostMapping("/emailKafka")
    public ResponseEntity<?> receiveEmailKafka(@RequestBody EmailDto emailDto) {
        log.info("Mensaje recibido:");
        log.info(emailDto.toString());
        emailService.sendEmailKafka(emailDto);
        //kafkaTemplate.send("uady-mail-topic", emailDto); // Use the kafkaTemplate from the producer configuration
        return (ResponseEntity<?>) ResponseEntity.ok("mensaje enviado");
    }

//    @PostMapping("email-file")
//    public ResponseEntity<?> receiveEmailWithfile(@ModelAttribute  EmailFileDto emailFileDto){
//        try {
//            String fileName = emailFileDto.getFile().getOriginalFilename();
//            Path path = Paths.get("src/main/resources/files/"+fileName);
//            Files.createDirectories(path.getParent());
//            Files.copy(emailFileDto.getFile().getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
//            File file = path.toFile();
//            emailService.sendEmailWithFile(emailFileDto.getToUser(), emailFileDto.getSubject(), emailFileDto.getMessage(), file);
//            //Files.deleteIfExists(path.getParent());
//            return (ResponseEntity<?>) ResponseEntity.ok("Email enviado correctamente");
//        }catch (IOException ex){
//            log.error("Error",ex);
//            return new ResponseEntity<>("No se pudo enviar el emial",HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
