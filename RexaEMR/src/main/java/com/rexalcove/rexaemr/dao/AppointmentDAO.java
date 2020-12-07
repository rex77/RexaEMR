package com.rexalcove.rexaemr.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.AppointmentDTO;

/**
 * 예약 정보를 가져오는/저장하는 DAO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Repository
@Mapper
public interface AppointmentDAO {
	/**
	 * 특정 환자와 지정한 날짜의 전체 예약 정보를 가져오는 메서드
	 * @see com.rexalcove.rexaemr.service.AppointmentService#getAppointmentList(String, String)
	 * @param patient 환자
	 * @param date 일자
	 * @return 전체 예약 정보
	 */
	public List<AppointmentDTO> selectAppointmentList(String patient, String date);
	/**
	 * 특정 예약 정보를 가져오는 메서드
	 * @see com.rexalcove.rexaemr.service.AppointmentService#getAppointment(int)
	 * @param idx 가저올 예약 정보의 인덱스
	 * @return 특정 예약 정보
	 */
	public AppointmentDTO selectAppointment(int idx);
	/**
	 * 예약 정보를 삽입하는 메서드
	 * @see com.rexalcove.rexaemr.service.AppointmentService#insertAppointment(int, int, String, Date)
	 * @param doctor 의사
	 * @param patient 환자
	 * @param memo 메모
	 * @param date 일자
	 */
	public void insertAppointment(int doctor, int patient, String memo, Date date);
	/**
	 * 특정 예약 정보를 업데이트하는 메서드
	 * @see com.rexalcove.rexaemr.service.AppointmentService#updateAppointment(int, int, int, String, Date)
	 * @param idx 업데이트할 예약 정보의 인덱스
	 * @param doctor 업데이트할 의사
	 * @param patient 업데이트할 환자
	 * @param memo 업데이트할 메모
	 * @param date 업데이트할 일자
	 * @return 수정 여부
	 */
	public boolean updateAppointment(int idx, int doctor, int patient, String memo, Date date);
	/**
	 * 특정 예약 정보를 삭제하는 메서드
	 * @see com.rexalcove.rexaemr.service.AppointmentService#deleteAppointment(int)
	 * @param idx 삭제할 예약 정보의 인덱스
	 * @return 삭제 여부
	 */
	public boolean deleteAppointment(int idx);
}
