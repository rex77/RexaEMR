package com.rexalcove.rexaemr.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rexalcove.rexaemr.dto.PatientDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 예약 정보를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = {"3. Appointment"})
@RestController
public class AppointmentController {

	@ApiOperation(value="전체 예약 정보 불러오기", notes="전체 예약 정보를 불러옵니다.")
	@GetMapping("/appointmentList")
	public String getAppointmentList(String id, Date date) {
		return null;
	}
	
	@ApiOperation(value="예약 정보 불러오기", notes="특정 예약 정보를 불러옵니다.")
	@GetMapping("/appointment")
	public String getAppointment(int idx) {
		return null;
	}
	
	@ApiOperation(value="예약 정보 삽입하기", notes="예약 정보를 입력합니다.")
	@PostMapping("/insertAppointment")
	public String insertAppointment(Date date, PatientDTO patient, String memo) {
		return null;
	}
	
	@ApiOperation(value="예약 정보 수정하기", notes="예약 정보를 수정합니다.")
	@PostMapping("/updateAppointment")
	public String updateAppointment(int idx, Date date, PatientDTO patient, String memo) {
		return null;
	}
	
	@ApiOperation(value="예약 정보 삭제하기", notes="예약 정보를 삭제합니다.")
	@DeleteMapping("/deleteAppointment")
	public String deleteAppointment(int idx) {
		return null;
	}
}
