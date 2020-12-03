package com.rexalcove.rexaemr.service;

import java.util.List;

import com.rexalcove.rexaemr.dto.HealthRecordDTO;

public interface HealthRecordService {
	public List<HealthRecordDTO> getHealthRecordList(int patient);
	public HealthRecordDTO getHealthRecord(int idx);
	public void insertHealthRecord(int doctor, int patient, String vital, String problems, String visitReasons, String medications, String symptoms, String note);
}
