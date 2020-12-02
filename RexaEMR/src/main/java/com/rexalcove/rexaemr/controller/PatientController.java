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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rexalcove.rexaemr.dto.PatientDTO;
import com.rexalcove.rexaemr.service.PatientService;
import com.rexalcove.rexaemr.util.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 환자 정보를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = { "2. Patient" })
@RestController
public class PatientController {
	@Autowired
	PatientService patientService;

	@ApiOperation(value = "전체 환자 조회", notes = "모든 환자를 조회합니다.")
	@GetMapping("/patientList")
	public String getPatientList(@RequestParam(value = "name", required = false) String name) {
		// 변수 선언
		ResultData resultData = new ResultData();
		List<PatientDTO> patientList = null;
		// 로직 처리
		try {
			if (name != null)
				patientList = patientService.getPatientListWithName(name);
			else
				patientList = patientService.getPatientList();
			resultData.setHeader("200", "OK");
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		JSONArray data = new JSONArray(patientList);
		resultData.setBody(data.length(), data);

		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "특정 환자 조회", notes = "특정 환자를 조회합니다.")
	@GetMapping("/patient")
	public String getPatient(@RequestParam(value = "idx") int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		PatientDTO patient = null;
		// 로직 처리
		try {
			patient = patientService.getPatient(idx);
			resultData.setHeader("200", "OK");

			if (patient == null) {
				resultData.setHeader("404", "Given Patient Not Found");
				patient = new PatientDTO();
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}
		resultData.setBody(new JSONObject(patient));
		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "환자 삽입", notes = "특정 환자를 삽입합니다.")
	@PostMapping("/insertPatient")
	public String insertPatient(String name, String email, String contact, String dob, String insurance,
			String gender) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			Date dobd = new SimpleDateFormat("yyyy-mm-dd").parse(dob);
			patientService.insertPatient(name, email, contact, dobd, insurance, gender);
			resultData.setHeader("200", "OK");
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "환자 삭제", notes = "특정 환자를 삭제합니다.")
	@DeleteMapping("/deletePatient")
	public String deletePatient(int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			boolean result = patientService.deletePatient(idx);
			if (result)
				resultData.setHeader("200", "OK");
			else
				resultData.setHeader("204", "Patient Not Found");
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}
		return resultData.getResultData().toString();
	}

	@ApiOperation(value = "환자 정보 업데이트", notes = "환자 정보를 업데이트합니다.")
	@PostMapping("/updatePatient")
	public String updatePatient(int idx, String name, String email, String contact, String dob, String insurance,
			String gender) {
		// 변수 선언
				ResultData resultData = new ResultData();
				// 로직 처리
				try {
					Date dobd = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
					boolean result = patientService.updatePatient(idx, name, email, contact, dobd, insurance, gender);
					if (result)
						resultData.setHeader("200", "OK");
					else
						resultData.setHeader("404", "Patient Not Found");
				} catch (Exception e) {
					resultData.setHeader("500", "Internal Server Error");
					e.printStackTrace();
				}

				return resultData.getResultData().toString();
	}
}
