package com.rexalcove.rexaemr.service;

import java.util.Date;
import java.util.List;

import com.rexalcove.rexaemr.dto.AppointmentDTO;

/**
 * 예약 정보를 관리하는 서비스
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
public interface AppointmentService {
	/**
	 * 예약 정보 리스트를 불러오는 메서드
	 * @see com.rexalcove.rexaemr.controller.AppointmentController#getAppointmentList(String, String)
	 * @param patient 환자
	 * @param date 일자
	 * @return 환자와 일자에 따른 예약정보 리스트
	 */
	public List<AppointmentDTO> getAppointmentList(String patient, String date);
	
	/**
	 * 특정 예약 정보를 불러오는 메서드
	 * @see com.rexalcove.rexaemr.controller.AppointmentController#getAppointment(int)
	 * @param idx 예약 정보의 인덱스
	 * @return 예약 정보
	 */
	public AppointmentDTO getAppointment(int idx);
	
	/**
	 * 예약 정보를 삽입하는 메서드
	 * @see com.rexalcove.rexaemr.controller.AppointmentController#insertAppointment(int, int, String, String)
	 * @param doctor 담당 의사
	 * @param patient 예약 환자
	 * @param memo 메모
	 * @param date 일자
	 */
	public void insertAppointment(int doctor, int patient, String memo, Date date);
	
	/**
	 * 예약 정보를 업데이트하는 메서드
	 * @see com.rexalcove.rexaemr.controller.AppointmentController#updateAppointment(int, int, int, String, String)
	 * @param idx 업데이트할 예약 정보의 인덱스
	 * @param doctor 담당 의사
	 * @param patient 담당 환자
	 * @param memo 메모
	 * @param date 일자
	 * @return 업데이트 성공여부
	 */
	public boolean updateAppointment(int idx, int doctor, int patient, String memo, Date date);
	/**
	 * 예약을 삭제하는 메서드
	 * @see com.rexalcove.rexaemr.controller.AppointmentController#deleteAppointment(int)
	 * @param idx 삭제하고자 하는 예약의 인덱스
	 * @return 삭제 성공여부
	 */
	public boolean deleteAppointment(int idx);
}
