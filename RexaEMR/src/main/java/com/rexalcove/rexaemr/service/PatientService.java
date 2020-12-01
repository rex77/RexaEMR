package com.rexalcove.rexaemr.service;

import java.util.Date;
import java.util.List;

import com.rexalcove.rexaemr.dto.PatientDTO;

public interface PatientService {
	public List<PatientDTO> getPatientListWithName(String name);
	public List<PatientDTO> getPatientList();
	public PatientDTO getPatient(int idx);
	public void insertPatient(String name, String email, String contact, Date dob, String insurance, String gender);
	public boolean deletePatient(int idx);
	public boolean updatePatient(int idx, String name, String email, String Contact, Date dob, String insurance, String gender);
}
