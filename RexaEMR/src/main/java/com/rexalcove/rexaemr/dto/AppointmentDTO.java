package com.rexalcove.rexaemr.dto;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * 예약 정보를 저장하는 DTO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Getter
@Setter
@ToString
public class AppointmentDTO {
	private int idx;
	private int patient;
	private int doctor;
	private Date date;
	private String memo;
}
