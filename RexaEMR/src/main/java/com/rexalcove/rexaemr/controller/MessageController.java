package com.rexalcove.rexaemr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

/**
 * 메시지를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = {"5. Message"})
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
