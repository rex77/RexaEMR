package com.rexalcove.rexaemr.service;

import java.util.Date;
import java.util.List;

import com.rexalcove.rexaemr.dto.AppointmentDTO;

public interface AppointmentService {
	public List<AppointmentDTO> getAppointmentList(String patient, String date);
	public AppointmentDTO getAppointment(int idx);
	public void insertAppointment(int doctor, int patient, String memo, Date date);
	public boolean updateAppointment(int idx, int doctor, int patient, String memo, Date date);
	public boolean deleteAppointment(int idx);
}
