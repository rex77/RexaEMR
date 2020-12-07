package com.rexalcove.rexaemr.service;

import java.util.Date;
import java.util.List;

import com.rexalcove.rexaemr.dto.PatientDTO;

/**
 * 환자 정보를 관리하는 서비스
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
public interface PatientService {
	/**
	 * 이름을 이용해 환자 정보를 가져오는 메서드
	 * @see com.rexalcove.rexaemr.controller.PatientController#getPatientList(String)
	 * @param name 기준이 될 이름
	 * @return 환자 정보 리스트
	 */
	public List<PatientDTO> getPatientListWithName(String name);
	/**
	 * 기본 정렬 기준(이름 가나다순)을 이용해 환자 정보를 가져오는 메서드 
	 * @see com.rexalcove.rexaemr.controller.PatientController#getPatientList(String)
	 * @return 환자 정보 리스트
	 */
	public List<PatientDTO> getPatientList();
	/**
	 * 특정 환자를 가져오는 메서드
	 * @see com.rexalcove.rexaemr.controller.PatientController#getPatient(int)
	 * @param idx 가져올 환자의 인덱스
	 * @return 환자 정보
	 */
	public PatientDTO getPatient(int idx);
	/**
	 * 환자 정보를 삽입하는 메서드
	 * @see com.rexalcove.rexaemr.controller.PatientController#insertPatient(String, String, String, String, String, String)
	 * @param name 이름
	 * @param email 이메일
	 * @param contact 연락처
	 * @param dob 생일
	 * @param insurance 보험사 정보
	 * @param gender 성별
	 */
	public void insertPatient(String name, String email, String contact, Date dob, String insurance, String gender);
	/**
	 * 특정 환자를 삭제하는 메서드
	 * @see com.rexalcove.rexaemr.controller.PatientController#deletePatient(int)
	 * @param idx 삭제할 환자의 인덱스
	 * @return 삭제 성공 여부
	 */
	public boolean deletePatient(int idx);
	
	/**
	 * 특정 환자 정보를 업데이트하는 메서드
	 * @see com.rexalcove.rexaemr.controller.PatientController#updatePatient(int, String, String, String, String, String, String)
	 * @param idx 수정할 환자의 인덱스
	 * @param name 수정할 이름
	 * @param email 수정할 이메일
	 * @param Contact 수정할 환자 연락처
	 * @param dob 수정할 생일
	 * @param insurance 수정할 보험사 정보
	 * @param gender 수정할 성별
	 * @return 업데이트 성공여부
	 */
	public boolean updatePatient(int idx, String name, String email, String Contact, Date dob, String insurance, String gender);
}
