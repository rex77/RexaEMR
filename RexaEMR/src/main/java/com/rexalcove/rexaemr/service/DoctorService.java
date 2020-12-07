package com.rexalcove.rexaemr.service;

import com.rexalcove.rexaemr.dto.DoctorDTO;

/**
 * 의사 정보를 관리하는 서비스
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
public interface DoctorService {
	/**
	 * 로그인을 실행하는 메서드
	 * @see com.rexalcove.rexaemr.controller.DoctorController#doctorLogin(String, String)
	 * @param id 아이디
	 * @param password 패스워드
	 * @return 성공한 계정의 DoctorDTO
	 */
	public DoctorDTO login(String id, String password);
	/**
	 * 인덱스를 이용해 의사 정보를 가져오는 메서드
	 * @param idx 가져올 의사의 인덱스
	 * @return 의사 정보
	 */
	public DoctorDTO getDoctor(int idx);
}
