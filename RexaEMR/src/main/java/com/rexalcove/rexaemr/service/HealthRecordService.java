package com.rexalcove.rexaemr.service;

import java.util.List;

import com.rexalcove.rexaemr.dto.HealthRecordDTO;

/**
 * 건강 레코드를 관리하는 서비스
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
public interface HealthRecordService {
	/**
	 * 특정 환자의 건강 레코드 목록을 가져오는 메서드
	 * @see com.rexalcove.rexaemr.controller.HealthRecordController#getHealthRecordList(int)
	 * @param patient 환자 인덱스
	 * @return 건강 레코드 리스트
	 */
	public List<HealthRecordDTO> getHealthRecordList(int patient);
	/**
	 * 특정 건강 레코드를 가져오는 메서드
	 * @see com.rexalcove.rexaemr.controller.HealthRecordController#getHealthRecord(int)et
	 * @param idx 건강 레코드의 인덱스
	 * @return 건강 레코드
	 */
	public HealthRecordDTO getHealthRecord(int idx);
	/**
	 * 건강 레코드 정보를 삽입하는 메서드
	 * @see com.rexalcove.rexaemr.controller.HealthRecordController#insertHealthRecord(int, int, String, String, String, String, String, String)
	 * @param doctor 작성 의사
	 * @param patient 담당 환자
	 * @param vital 바이탈
	 * @param problems 의사 판단 문제
	 * @param visitReasons 방문 이유
	 * @param medications 처방약
	 * @param symptoms 증상
	 * @param note 메모
	 */
	public void insertHealthRecord(int doctor, int patient, String vital, String problems, String visitReasons, String medications, String symptoms, String note);
}
