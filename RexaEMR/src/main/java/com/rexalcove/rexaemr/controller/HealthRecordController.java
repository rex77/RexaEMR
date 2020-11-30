package com.rexalcove.rexaemr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;


/**
 * 건강 기록을 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = {"4. Health Record"})
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
