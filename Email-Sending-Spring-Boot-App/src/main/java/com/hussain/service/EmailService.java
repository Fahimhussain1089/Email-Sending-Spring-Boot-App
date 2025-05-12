package com.hussain.service;

import org.springframework.web.multipart.MultipartFile;

import com.hussain.model.EmailRequest;

public interface EmailService {
	
	
	public Boolean sendEmail(EmailRequest emailRequest) throws Exception;
	
	
	public void sendEmailAndAttachment(String email, MultipartFile[] file) throws Exception;



}
