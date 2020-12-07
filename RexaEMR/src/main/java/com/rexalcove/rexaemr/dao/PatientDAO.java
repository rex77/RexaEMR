package com.rexalcove.rexaemr.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.PatientDTO;

/**
 * 환자 정보를 관리하는 DAO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Repository
@Mapper
public interface PatientDAO {
	/**
	 * 기본 순서로 환자 리스트를 정렬하여 반환하는 메서드
	 * @see com.rexalcove.rexaemr.service.PatientService#getPatientList()
	 * @return 환자 리스트
	 */
	public List<PatientDTO> selectPatientList();
	/**
	 * 환자 이름을 통해 환자 리스트를 정렬하여 반환하는 메서드
	 * @see com.rexalcove.rexaemr.service.PatientService#getPatientListWithName(String)
	 * @param name 정렬할 환자의 이름
	 * @return 환자 리스트 
	 */
	public List<PatientDTO> selectPatientListWithName(String name);
	/**
	 * 인덱스를 통해 환자를 선택하는 메서드
	 * @see com.rexalcove.rexaemr.service.PatientService#getPatient(int)
	 * @param idx 환자 인덱스
	 * @return 환자 정보
	 */
	public PatientDTO selectPatient(int idx);
	/**
	 * INSERT 구문으로 환자 정보를 삽입하는 메서드
	 * @see com.rexalcove.rexaemr.service.PatientService#insertPatient(String, String, String, Date, String, String)
	 * @param name 이름
	 * @param email 이메일 
	 * @param contact 연락처 정보
	 * @param dob 생일
	 * @param insurance 보험사 정보
	 * @param gender 성별
	 */
	public void insertPatient(String name, String email, String contact, Date dob, String insurance, String gender);
	/**
	 * DELETE 구문으로 환자 정보를 삭제하는 메서드
	 * @see com.rexalcove.rexaemr.service.PatientService#deletePatient(int)
	 * @param idx
	 * @return 삭제 성공여부
	 */
	public boolean deletePatient(int idx);
	/**
	 * UPDATE 구문으로 환자 정보를 업데이트하는 메서드
	 * @see com.rexalcove.rexaemr.service.PatientService#updatePatient(int, String, String, String, Date, String, String)
	 * @param idx 업데이트할 환자 인덱스
	 * @param name 이름
	 * @param email 이메일
	 * @param contact 연락처 정보
	 * @param dob 생일
	 * @param insurance 보험사 정보
	 * @param gender 성별
	 * @return 업데이트 성공여부
	 */
	public boolean updatePatient(int idx, String name, String email, String contact, Date dob, String insurance, String gender);
}
