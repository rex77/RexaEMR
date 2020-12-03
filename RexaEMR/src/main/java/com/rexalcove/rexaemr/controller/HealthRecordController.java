package com.rexalcove.rexaemr.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rexalcove.rexaemr.dto.HealthRecordDTO;
import com.rexalcove.rexaemr.service.HealthRecordService;
import com.rexalcove.rexaemr.service.PatientService;
import com.rexalcove.rexaemr.util.ResultData;

import io.swagger.annotations.Api;

/**
 * 건강 기록을 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = { "4. Health Record" })
@RestController
public class HealthRecordController {
	@Autowired
	HealthRecordService healthRecordService;

	@Autowired
	PatientService patientService;
	
	@GetMapping("/healthRecordList")
	public String getHealthRecordList(int patient) {
		// 변수 선언
		ResultData resultData = new ResultData();
		List<HealthRecordDTO> healthRecordList = null;
		// 로직 처리
		try {
			healthRecordList = healthRecordService.getHealthRecordList(patient);
			resultData.setHeader("200", "OK");
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		//환자 정보 입력 후 관련 건강 레코드 입력
		JSONObject body = new JSONObject();
		body.put("patient", new JSONObject(patientService.getPatient(patient)));
		JSONArray data = new JSONArray(healthRecordList);
		body.put("record", data);
		
		resultData.setBody(body);

		return resultData.getResultData().toString();
	}

	@GetMapping("/healthRecord")
	public String getHealthRecord(int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		HealthRecordDTO healthRecord = null;
		// 로직 처리
		try {
			healthRecord = healthRecordService.getHealthRecord(idx);
			resultData.setHeader("200", "OK");

			if (healthRecord == null) {
				resultData.setHeader("404", "Given Health Record Not Found");
				healthRecord = new HealthRecordDTO();
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}
		resultData.setBody(new JSONObject(healthRecord));
		return resultData.getResultData().toString();
	}

	@PostMapping("/insertHealthRecord")
	public String insertHealthRecord(int doctor, int patient, String vital, String problems, String visitReasons,
			String medications, String symptoms, String note) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			healthRecordService.insertHealthRecord(doctor, patient, vital, problems, visitReasons, medications,
					symptoms, note);
			resultData.setHeader("200", "OK");
			resultData.setBody(new JSONObject().put("count", "1"));
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}
}
