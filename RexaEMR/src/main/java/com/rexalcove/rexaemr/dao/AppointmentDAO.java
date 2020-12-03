package com.rexalcove.rexaemr.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.AppointmentDTO;

@Repository
@Mapper
public interface AppointmentDAO {
	public List<AppointmentDTO> selectAppointmentList(String patient, String date);
	public AppointmentDTO selectAppointment(int idx);
	public void insertAppointment(int doctor, int patient, String memo, Date date);
	public boolean updateAppointment(int idx, int doctor, int patient, String memo, Date date);
	public boolean deleteAppointment(int idx);
}
