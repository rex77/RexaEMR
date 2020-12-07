package com.rexalcove.rexaemr.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 건강 레코드를 저장하는 DTO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
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
