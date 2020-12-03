package com.rexalcove.rexaemr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HealthRecordDTO {
	private int idx;
	private int doctor;
	private int patient;
	private String vital;
	private String problems;
	private String symptoms;
	private String visitReasons;
	private String medications;
	private String note;
}
