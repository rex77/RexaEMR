package com.rexalcove.rexaemr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.HealthRecordDTO;

@Repository
@Mapper
public interface HealthRecordDAO {
	public List<HealthRecordDTO> selectHealthRecordList(int patient);
	public HealthRecordDTO selectHealthRecord(int idx);
	public void insertHealthRecord(int doctor, int patient, String vital, String problems, String visitReasons, String medications, String symptoms, String note);
}
