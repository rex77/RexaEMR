package com.rexalcove.rexaemr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.HealthRecordDTO;

/**
 * 건강 레코드 정보를 관리하는 DAO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Repository
@Mapper
public interface HealthRecordDAO {
	/**
	 * 환자 인덱스를 이용해 특정 환자의 건강 레코드 리스트를 반환하는 메서드
	 * @see com.rexalcove.rexaemr.service.HealthRecordService#getHealthRecordList(int)
	 * @param patient 환자 인덱스
	 * @return 건강 레코드 리스트
	 */
	public List<HealthRecordDTO> selectHealthRecordList(int patient);
	/**
	 * 건강 레코드를 선택하는 메서드
	 * @see com.rexalcove.rexaemr.service.HealthRecordService#getHealthRecord(int)
	 * @param idx 선택하고자 하는 건강 레코드의 인덱스
	 * @return 건강 레코드
	 */
	public HealthRecordDTO selectHealthRecord(int idx);
	/**
	 * INSERT 구문을 이용해 건강 레코드를 삽입하는 메서드
	 * @see com.rexalcove.rexaemr.service.HealthRecordService#insertHealthRecord(int, int, String, String, String, String, String, String)
	 * @param doctor 의사
	 * @param patient 환자
	 * @param vital 바이탈
	 * @param problems 의사 판단 문제
	 * @param visitReasons 방문 이유
	 * @param medications 처방약
	 * @param symptoms 증상
	 * @param note 메모
	 */
	public void insertHealthRecord(int doctor, int patient, String vital, String problems, String visitReasons, String medications, String symptoms, String note);
}
