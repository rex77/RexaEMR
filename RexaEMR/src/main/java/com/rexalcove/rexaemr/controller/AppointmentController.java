package com.rexalcove.rexaemr.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rexalcove.rexaemr.dto.AppointmentDTO;
import com.rexalcove.rexaemr.dto.PatientDTO;
import com.rexalcove.rexaemr.service.AppointmentService;
import com.rexalcove.rexaemr.util.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 예약 정보를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = { "3. Appointment" })
@RestController
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;

	@ApiOperation(value = "전체 예약 정보 불러오기", notes = "전체 예약 정보를 불러옵니다.")
	@GetMapping("/appointmentList")
	public String getAppointmentList(String patient, String date) {
		// 변수 선언
		ResultData resultData = new ResultData();
		List<AppointmentDTO> appointmentList = null;
		// 로직 처리
		try {
			appointmentList = appointmentService.getAppointmentList(patient, date);
			resultData.setHeader("200", "OK");
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		JSONArray data = new JSONArray(appointmentList);
		resultData.setBody(data.length(), data);

		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "예약 정보 불러오기", notes = "특정 예약 정보를 불러옵니다.")
	@GetMapping("/appointment")
	public String getAppointment(int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		AppointmentDTO appointment = null;
		// 로직 처리
		try {
			appointment = appointmentService.getAppointment(idx);
			resultData.setHeader("200", "OK");

			if (appointment == null) {
				resultData.setHeader("404", "Given Patient Not Found");
				appointment = new AppointmentDTO();
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}
		resultData.setBody(new JSONObject(appointment));
		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "예약 정보 삽입하기", notes = "예약 정보를 입력합니다.")
	@PostMapping("/insertAppointment")
	public String insertAppointment(int doctor, int patient, String memo, String date) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			Date datef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
			appointmentService.insertAppointment(doctor, patient, memo, datef);
			resultData.setHeader("200", "OK");
			resultData.setBody(new JSONObject().put("count", "1"));
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "예약 정보 수정하기", notes = "예약 정보를 수정합니다.")
	@PostMapping("/updateAppointment")
	public String updateAppointment(int idx, int doctor, int patient, String memo, String date) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			Date datef = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
			boolean result = appointmentService.updateAppointment(idx, doctor, patient, memo, datef);
			if (result) {
				resultData.setHeader("200", "OK");
				resultData.setBody(new JSONObject().put("count", "1"));
			} else {
				resultData.setHeader("404", "Appointment Not Found");
				resultData.setBody(new JSONObject().put("count", "0"));
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "예약 정보 삭제하기", notes = "예약 정보를 삭제합니다.")
	@DeleteMapping("/deleteAppointment")
	public String deleteAppointment(int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			boolean result = appointmentService.deleteAppointment(idx);
			if (result) {
				resultData.setHeader("200", "OK");
				resultData.setBody(new JSONObject().put("count", "1"));
			} else {
				resultData.setHeader("204", "Appointment Not Found");
				resultData.setBody(new JSONObject().put("count", "0"));
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}
		return resultData.getResultData().toString();
	}
}
