package com.rexalcove.rexaemr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexalcove.rexaemr.dao.PatientDAO;
import com.rexalcove.rexaemr.dto.PatientDTO;

@Service
public class PatientServiceImpl implements PatientService {
	@Autowired
	PatientDAO patientDao;
	
	
	@Override
	public List<PatientDTO> getPatientList() {
		// TODO Auto-generated method stub
		return patientDao.selectPatientList();
	}

	@Override
	public PatientDTO getPatient(int idx) {
		// TODO Auto-generated method stub
		return patientDao.selectPatient(idx);
	}

	@Override
	public void insertPatient(String name, String email, String contact, Date dob, String insurance, String gender) {
		// TODO Auto-generated method stub
		patientDao.insertPatient(name, email, contact, dob, insurance, gender);
	}

	@Override
	public boolean deletePatient(int idx) {
		// TODO Auto-generated method stub
		return patientDao.deletePatient(idx);
	}

	@Override
	public boolean updatePatient(int idx, String name, String email, String contact, Date dob, String insurance, String gender) {
		// TODO Auto-generated method stub
		return patientDao.updatePatient(idx, name, email, contact, dob, insurance, gender);
	}

	@Override
	public List<PatientDTO> getPatientListWithName(String name) {
		// TODO Auto-generated method stub
		return patientDao.selectPatientListWithName(name);
	}

}
