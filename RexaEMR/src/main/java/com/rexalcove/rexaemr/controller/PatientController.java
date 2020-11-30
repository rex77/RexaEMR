package com.rexalcove.rexaemr.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 환자 정보를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = {"2. Patient"})
@RestController
public class PatientController {
	
	
	@ApiOperation(value="전체 환자 조회", notes="모든 환자를 조회합니다.")
	@GetMapping("/patientList")
	public String getPatientList() {
		return null;
	}
	@ApiOperation(value="전체 환자 조회", notes="특정 환자를 조회합니다.")
	@GetMapping("/patient")
	public String getPatient() {
		return null;
	}
	@ApiOperation(value="환자 삽입", notes="특정 환자를 삽입합니다.")
	@PostMapping("/insertPatient")
	public String insertPatient() {
		return null;
	}
	@ApiOperation(value="환자 삭제", notes="환자를 삭제합니다.")
	@DeleteMapping("/deletePatient")
	public String deletePatient() {
		return null;
	}
	@ApiOperation(value="환자 정보 업데이트", notes="환자 정보를 업데이트합니다.")
	@PostMapping("/updatePatient")
	public String updatePatient() {
		return null;
	}
}
