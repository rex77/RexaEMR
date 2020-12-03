package com.rexalcove.rexaemr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexalcove.rexaemr.dao.DoctorDAO;
import com.rexalcove.rexaemr.dto.DoctorDTO;

@Service
public class DoctorServiceImpl implements DoctorService {
	@Autowired
	DoctorDAO doctorDao;
	
	@Override
	public DoctorDTO login(String id, String password) {
		// TODO Auto-generated method stub
		return doctorDao.login(id, password);
	}

	@Override
	public DoctorDTO getDoctor(int idx) {
		// TODO Auto-generated method stub
		return doctorDao.selectDoctor(idx);
	}

}
