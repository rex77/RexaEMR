package com.rexalcove.rexaemr.service;

import com.rexalcove.rexaemr.dto.DoctorDTO;

public interface DoctorService {
	public DoctorDTO login(String id, String password);
}
