package com.rexalcove.rexaemr.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexalcove.rexaemr.dao.AppointmentDAO;
import com.rexalcove.rexaemr.dto.AppointmentDTO;

@Service
public class AppointmentServiceImpl implements AppointmentService {
	@Autowired
	AppointmentDAO appointmentDao;
	
	@Override
	public List<AppointmentDTO> getAppointmentList(String patient, String date) {
		// TODO Auto-generated method stub
		return appointmentDao.selectAppointmentList(patient, date);
	}

	@Override
	public AppointmentDTO getAppointment(int idx) {
		// TODO Auto-generated method stub
		return appointmentDao.selectAppointment(idx);
	}

	@Override
	public void insertAppointment(int doctor, int patient, String memo, Date date) {
		// TODO Auto-generated method stub
		System.out.println(date);
		appointmentDao.insertAppointment(doctor, patient, memo, date);
	}

	@Override
	public boolean updateAppointment(int idx, int doctor, int patient, String memo, Date date) {
		// TODO Auto-generated method stub
		return appointmentDao.updateAppointment(idx, doctor, patient, memo, date);
	}

	@Override
	public boolean deleteAppointment(int idx) {
		// TODO Auto-generated method stub
		return appointmentDao.deleteAppointment(idx);
	}

}
