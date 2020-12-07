package com.rexalcove.rexaemr.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 환자 정보를 저장하는 DTO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Getter
@Setter
@ToString
public class PatientDTO {
	private int idx;
	private String name;
	private Date dob;
	private String gender;
	private String email;
	private String contact;
	private String insurance;
}
