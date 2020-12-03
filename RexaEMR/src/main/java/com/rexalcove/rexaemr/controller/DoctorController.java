package com.rexalcove.rexaemr.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rexalcove.rexaemr.dto.DoctorDTO;
import com.rexalcove.rexaemr.service.DoctorService;
import com.rexalcove.rexaemr.util.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 의사 정보를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = { "1. Doctor" })
@RestController
public class DoctorController {
	/**
	 * 의사 정보를 관리하는 서비스 객체를 주입 - Autowired
	 * @see #DoctorService
	 */
	@Autowired
	DoctorService doctorService;

	@ApiOperation(value = "의사 아이디 로그인", notes = "의사 아이디로 로그인을 실행합니다.")
	@PostMapping("/login")
	public String doctorLogin(String id, String password) {
		//변수 설정
		ResultData resultData = new ResultData();
		DoctorDTO doctor = null;
		
		//데이터를 담는 로직 처리 & 헤더 설정
		try {
			doctor = doctorService.login(id, password);
			
			if(doctor != null) {
				resultData.setHeader("200", "ok");
				resultData.setBody(new JSONObject(doctor));
			} else {
				resultData.setHeader("404", "Given Doctor Not Found");
				doctor = new DoctorDTO();
			}
		} catch (Exception e) {
			e.printStackTrace();
			resultData.setHeader("500", "Internal Server Error");
		}
		
		//데이터 설정
		return resultData.getResultData().toString();
	}
	
}
