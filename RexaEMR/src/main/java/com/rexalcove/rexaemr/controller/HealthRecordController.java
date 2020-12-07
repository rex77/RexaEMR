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
 * @version 1.0.0 20/12/07
 */
@Api(tags = { "4. Health Record" })
@RestController
public class HealthRecordController {
	/**
	 * 건강 레코드를 관리하는 서비스 객체를 주입
	 */
	@Autowired
	HealthRecordService healthRecordService;

	/**
	 * 일부 메서드에서 사용되는 환자 기록 서비스 객체를 주입
	 */
	@Autowired
	PatientService patientService;
	
	/**
	 * 특정 환자의 전체 건강 레코드를 불러오는 메서드
	 * @param patient 건강 레코드를 불러올 환자
	 * @return 특정 환자의 전체 건강 레코드
	 */
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

	/**
	 * 특정 건강 레코드 정보를 불러오는 메서드
	 * @param idx 건강 레코드의 고유 번호
	 * @return 건강 레코드
	 */
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

	
	/**
	 * 건강 레코드를 삽입하는 메서드
	 * @param doctor 건강 레코드를 작성하는 의사 주체
	 * @param patient 건강 레코드의 대상이 되는 환자
	 * @param vital 환자의 바이탈
	 * @param problems 의사 관점에서의 문제
	 * @param visitReasons 환자가 기술한 방문이유
	 * @param medications 처방할 약
	 * @param symptoms 환자의 증상
	 * @param note 그 이외의 메모
	 * @return 삽입된 레코드의 수
	 */
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
