package com.rexalcove.rexaemr.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.PatientDTO;

@Repository
@Mapper
public interface PatientDAO {
	public List<PatientDTO> selectPatientList();
	public List<PatientDTO> selectPatientListWithName(String name);
	public PatientDTO selectPatient(int idx);
	public void insertPatient(String name, String email, String contact, Date dob, String insurance, String gender);
	public boolean deletePatient(int idx);
	public boolean updatePatient(int idx, String name, String email, String contact, Date dob, String insurance, String gender);
}
