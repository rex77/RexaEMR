package com.rexalcove.rexaemr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	@GetMapping("/inbox")
	public String getInbox() {
		return null;
	}
	
	@GetMapping("/sent")
	public String getSent() {
		return null;
	}
	
	@PostMapping("/sendMessage")
	public String sendMessage() {
		return null;
	}
}
