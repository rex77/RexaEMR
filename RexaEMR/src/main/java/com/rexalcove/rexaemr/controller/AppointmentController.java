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
import com.rexalcove.rexaemr.dto.DoctorDTO;
import com.rexalcove.rexaemr.dto.PatientDTO;
import com.rexalcove.rexaemr.service.AppointmentService;
import com.rexalcove.rexaemr.service.DoctorService;
import com.rexalcove.rexaemr.service.PatientService;
import com.rexalcove.rexaemr.util.ResultData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 예약 정보를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Api(tags = { "3. Appointment" })
@RestController
public class AppointmentController {
	@Autowired
	AppointmentService appointmentService;

	@Autowired
	PatientService patientService;

	@Autowired
	DoctorService doctorService;

	/**
	 * 환자와 특정 날짜를 지정하면 지정된 날짜의 전체 예약 정보를 불러오는 메서드
	 * @param patient 환자
	 * @param date    날짜
	 * @return 특정 환자의 예약 정보 리스트
	 */
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
			JSONArray data = new JSONArray(appointmentList);
			resultData.setBody(data.length(), data);
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	/**
	 * getAppointmentList()에서 찾은 예약 정보를 바탕으로 idx를 찾아 특정 예약 정보만을 불러오는 메서드
	 * @param idx 특정 예약의 인덱스
	 * @return 예약정보
	 */
	@ApiOperation(value = "예약 정보 불러오기", notes = "특정 예약 정보를 불러옵니다.")
	@GetMapping("/appointment")
	public String getAppointment(int idx) {
		// 변수 선언
		ResultData resultData = new ResultData();
		AppointmentDTO appointment = null;
		// 로직 처리
		try {
			appointment = appointmentService.getAppointment(idx);

			if (appointment != null) {
				resultData.setHeader("200", "OK");
				resultData.setBody(new JSONObject(appointment));
			} else {
				resultData.setHeader("404", "Given Appointment Not Found");
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}
		return resultData.getResultData().toString();
	}

	/**
	 * 예약정보를 삽입하는 메서드
	 * @param doctor 예약된 의사
	 * @param patient 예약한 환자
	 * @param memo 메모
	 * @param date 예약 날짜
	 * @return 삽입된 행의 수
	 */
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
			PatientDTO patientDto = patientService.getPatient(patient);
			DoctorDTO doctorDto = doctorService.getDoctor(doctor);

			if (patientDto == null) {
				resultData.setHeader("404", "Patient Not Found");
			} else if (doctorDto == null) {
				resultData.setHeader("405", "Doctor Not Found");
			} else {
				resultData.setHeader("500", "Internal Server Error");
			}
			resultData.setBody(new JSONObject().put("count", "0"));
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	/**
	 * 예약정보를 수정하는 메서드
	 * @param idx 변경할 예약 정보
	 * @param doctor 변경할 의사
	 * @param patient 변경할 환자
	 * @param memo 변경할 메모
	 * @param date 변경할 날짜
	 * @return 수정된 행의 수
	 */
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
				resultData.setHeader("404", "Appointment Not Found"); // where 조건 불일치는 예외 아님
				resultData.setBody(new JSONObject().put("count", "0"));
			}
		} catch (Exception e) {
			PatientDTO patientDto = patientService.getPatient(patient);
			DoctorDTO doctorDto = doctorService.getDoctor(doctor);

			if (patientDto == null) { // 외부키 조건 불일치는 예외임
				resultData.setHeader("404", "Patient Not Found");
			} else if (doctorDto == null) {
				resultData.setHeader("405", "Doctor Not Found");
			} else {
				resultData.setHeader("500", "Internal Server Error");
			}
			resultData.setBody(new JSONObject().put("count", "0"));
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	/**
	 * 예약 정보 삭제하는 메서드
	 * @param idx 삭제할 예약 정보의 인덱스
	 * @return 삭제한 예약의 수
	 */
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
