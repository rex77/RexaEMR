package com.rexalcove.rexaemr.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 의사 정보를 저장하는 DTO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Getter
@Setter
@ToString
public class DoctorDTO {
	private int idx;
	private String id;
	private String password;
	private String name;
	private String hospital;
}
