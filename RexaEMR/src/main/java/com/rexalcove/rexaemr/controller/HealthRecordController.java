package com.rexalcove.rexaemr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthRecordController {
	@GetMapping("/healthRecordList")
	public String getHealthRecordList() {
		return null;
	}
	
	@GetMapping("/healthRecord")
	public String getHealthRecord() {
		return "가나다";
	}
}
