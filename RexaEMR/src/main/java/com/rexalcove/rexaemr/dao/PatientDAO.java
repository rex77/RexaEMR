package com.rexalcove.rexaemr.dao;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 환자 정보를 저장하는 DAO
 * @author rexa
 *
 */
@Getter
@Setter
@ToString
public class PatientDAO {
	private int idx;
	String name;
	Date dob;
	String gender;
	String email;
	String contact;
	String insurance;
}
