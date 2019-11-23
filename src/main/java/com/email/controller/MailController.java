package com.email.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.email.domain.MailDomain;
import com.email.service.MailService;

@RestController
public class MailController {

	private final MailService mailService;

	public MailController(MailService mailService) {
		this.mailService = mailService;
	}

	@PostMapping("/sendmail")
	public ResponseEntity<String> senMail(@RequestBody MailDomain mailDomain) {
		String mail = mailService.sendMail(mailDomain);

		if (mail.endsWith("successfully")) {
			return ResponseEntity.ok(mail);
		} else {
			return ResponseEntity.badRequest().body(mail);
		}
	}

}
