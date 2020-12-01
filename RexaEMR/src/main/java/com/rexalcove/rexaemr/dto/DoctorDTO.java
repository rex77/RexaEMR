package com.rexalcove.rexaemr.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 의사 정보를 저장하는 DAO
 * @author rexa
 *
 */
@Getter
@Setter
@ToString
public class DoctorDTO {
	private int idx;
	String id;
	String password;
	String name;
	String hospital;
}
