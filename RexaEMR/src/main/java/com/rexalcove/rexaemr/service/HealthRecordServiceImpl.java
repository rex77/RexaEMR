package com.rexalcove.rexaemr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexalcove.rexaemr.dao.HealthRecordDAO;
import com.rexalcove.rexaemr.dto.HealthRecordDTO;

@Service
public class HealthRecordServiceImpl implements HealthRecordService {
	@Autowired
	HealthRecordDAO healthRecordDao;
	
	@Override
	public List<HealthRecordDTO> getHealthRecordList(int patient) {
		// TODO Auto-generated method stub
		return healthRecordDao.selectHealthRecordList(patient);
	}

	@Override
	public HealthRecordDTO getHealthRecord(int idx) {
		// TODO Auto-generated method stub
		return healthRecordDao.selectHealthRecord(idx);
	}

	@Override
	public void insertHealthRecord(int doctor, int patient, String vital, String problems, String visitReasons,
			String medications, String symptoms, String note) {
		// TODO Auto-generated method stub
		healthRecordDao.insertHealthRecord(doctor, patient, vital, problems, visitReasons, medications, symptoms, note);
	}

}
