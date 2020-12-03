package com.rexalcove.rexaemr.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.DoctorDTO;

@Repository
@Mapper
public interface DoctorDAO {
	public DoctorDTO login(String id, String password);
	
	public DoctorDTO selectDoctor(int idx);
}
