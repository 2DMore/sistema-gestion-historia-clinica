package org.rehab.email;

import lombok.extern.log4j.Log4j2;

import org.rehab.email.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;


@SpringBootApplication
@Log4j2
@ComponentScan(basePackages = "listener")
@ComponentScan(basePackages = "com.gocahum.email.service")
public class EmailServiceApplication implements CommandLineRunner {
	@Autowired
    private Environment env;

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("email usere: ");
        log.info(env.getProperty("email.props.gmail.user"));
        log.info(env.getProperty("email.props.gmail.password"));
    }
}