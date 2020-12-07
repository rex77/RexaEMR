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

	/**
	 * 전체 환자 목록을 조회하는 메서드
	 * @param name 환자 이름으로 환자 목록을 조회, 없을 시 가나다순으로 정렬한다
	 * @return 이름 순으로 정렬된 전체 환자 목록
	 */
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

	/**
	 * 인덱스로 특정 환자를 조회하는 메서드
	 * @param idx 조회할 환자의 인덱스
	 * @return 환자 정보
	 */
	@ApiOperation(value = "특정 환자 조회", notes = "특정 환자를 조회합니다.")
	@GetMapping("/patient")
	public String getPatient(@RequestParam(value = "idx") int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		PatientDTO patient = null;
		// 로직 처리
		try {
			patient = patientService.getPatient(idx);

			if (patient != null) {
				resultData.setHeader("200", "OK");
				resultData.setBody(new JSONObject(patient));
			}
			else {
				resultData.setHeader("404", "Given Patient Not Found");
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}
		return resultData.getResultData().toString();
	}

	/**
	 * 환자 정보를 삽입하는 메서드
	 * @param name 이름
	 * @param email 이메일
	 * @param contact 연락처
	 * @param dob 생일
	 * @param insurance 보험사 정보
	 * @param gender 성별
	 * @return 삽입된 데이터의 수
	 */
	@ApiOperation(value = "환자 삽입", notes = "특정 환자를 삽입합니다.")
	@PostMapping("/insertPatient")
	public String insertPatient(String name, String email, String contact, String dob, String insurance,
			String gender) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			Date dobd = new SimpleDateFormat("yyyy-MM-dd").parse(dob);
			patientService.insertPatient(name, email, contact, dobd, insurance, gender);
			resultData.setHeader("200", "OK");
			resultData.setBody(new JSONObject().put("count", "1"));
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			resultData.setBody(new JSONObject().put("count", "0"));
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	/**
	 * 환자를 삭제하는 메서드
	 * @param idx 삭제할 환자의 번호
	 * @return 삭제된 데이터의 수
	 */
	@ApiOperation(value = "환자 삭제", notes = "특정 환자를 삭제합니다.")
	@DeleteMapping("/deletePatient")
	public String deletePatient(int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			boolean result = patientService.deletePatient(idx);
			if (result) {
				resultData.setHeader("200", "OK");
				resultData.setBody(new JSONObject().put("count", "1"));
			}
			else {
				resultData.setHeader("204", "Patient Not Found");
				resultData.setBody(new JSONObject().put("count", "0"));
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			resultData.setBody(new JSONObject().put("count", "0"));
			e.printStackTrace();
		}
		return resultData.getResultData().toString();
	}

	/**
	 * 환자 정보를 수정하는 메서드
	 * @param idx 수정할 환자의 인덱스
	 * @param name 변경할 이름
	 * @param email 변경할 이메일
	 * @param contact 변경할 연락처
	 * @param dob 변경할 생일
	 * @param insurance 변경할 보험사 정보
	 * @param gender 변경할 성별
	 * @return 수정된 데이터의 수
	 */
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
			if (result) {
				resultData.setHeader("200", "OK");
				resultData.setBody(new JSONObject().put("count", "1"));
			}
			else {
				resultData.setHeader("404", "Patient Not Found");
				resultData.setBody(new JSONObject().put("count", "0"));
				}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			resultData.setBody(new JSONObject().put("count", "0"));
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}
}
