package com.rexalcove.rexaemr.service;

import java.util.List;

import com.rexalcove.rexaemr.dto.MessageDTO;

/**
 * 메시지를 관리하는 서비스
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
public interface MessageService {
	/**
	 * 수신된 메시지를 불러오는 메서드
	 * @see @see com.rexalcove.rexaemr.controller.MessageController#getInbox(int)
	 * @param receiver 수신자
	 * @return 수신된 메시지 리스트
	 */
	public List<MessageDTO> getInbox(int receiver);
	/**
	 * 발신한 메시지를 불러오는 메서드
	 * @see com.rexalcove.rexaemr.controller.MessageController#getSent(int)
	 * @param sender 발신자
	 * @return 발신된 메시지 리스트
	 */
	public List<MessageDTO> getSent(int sender);
	/**
	 * 메시지를 발신하는 메서드
	 * @see com.rexalcove.rexaemr.controller.MessageController#sendMessage(int, int, String, String) 
	 * @param sender 발신자
	 * @param receiver 수신자 
	 * @param title 메시지 제목
	 * @param content메시지 내용
	 */
	public void sendMessage(int sender, int receiver, String title, String content);
}
