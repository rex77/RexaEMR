package com.rexalcove.rexaemr.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
/**
 * 의사 정보를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = {"1. Doctor"})
@RestController
public class DoctorController {
	
	@ApiOperation(value="의사 아이디 로그인", notes="의사 아이디로 로그인을 실행합니다.")
	@PostMapping("/login")
	public String doctorLogin(String id, String password) {
		return null;
	}
}
