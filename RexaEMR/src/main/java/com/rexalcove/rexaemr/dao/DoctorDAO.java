package com.rexalcove.rexaemr.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.DoctorDTO;

/**
 * 의사 정보를 관리하는 DAO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Repository
@Mapper
public interface DoctorDAO {
	/**
	 * SELECT구문을 이용해 로그인을 실행하는 메서드
	 * @see com.rexalcove.rexaemr.service.DoctorService#login(String, String)
	 * @param id 아이디
	 * @param password 패스워드
	 * @return 로그인 성공한 계정의 DoctorDTO
	 */
	public DoctorDTO login(String id, String password);
	/**
	 * 인덱스를 이용해 특정 의사를 선택하는 메서드
	 * @see com.rexalcove.rexaemr.service.DoctorService#getDoctor(int)
	 * @param idx 의사의 인덱스
	 * @return 의사 정보
	 */
	public DoctorDTO selectDoctor(int idx);
}
