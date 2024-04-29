package com.techymeet.sms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SmsBootJspHibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsBootJspHibernateApplication.class, args);
		System.out.println("Hello world");  //for checking purpose
	}

}
