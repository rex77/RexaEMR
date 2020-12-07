package com.rexalcove.rexaemr.dto;

import java.util.Date;

/**
 * 메시지 정보를 저장하는 DTO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
public class MessageDTO {
	private int index;
	private String title;
	private String content;
	private Date date;
	private int sender;
	private int receiver;
}
