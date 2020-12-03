package com.rexalcove.rexaemr.dto;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AppointmentDTO {
	private int idx;
	private int patient;
	private int doctor;
	Date date;
	String memo;
}
