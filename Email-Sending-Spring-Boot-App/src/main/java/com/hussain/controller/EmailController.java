package com.hussain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hussain.model.EmailRequest;
import com.hussain.service.EmailService;

@RestController
public class EmailController {
	
	
	@Autowired
	private EmailService emailService;

	@PostMapping("/send-email")
	private ResponseEntity<?> sendEmail(@RequestBody EmailRequest emailRequest) {

		try {
			emailService.sendEmail(emailRequest);
			return new ResponseEntity<>("Email Send Sucess", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Email Send Failed !Internal Server Error ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@PostMapping("/email")
	public ResponseEntity<?> sendEmailWithAttachment(@RequestParam String email,
			@RequestParam(required = false) MultipartFile[] file) {

		try {
			emailService.sendEmailAndAttachment(email, file);
			return new ResponseEntity<>("Email Send Sucess", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Email Send Failed !Internal Server Error ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

}
