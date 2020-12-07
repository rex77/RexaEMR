package com.rexalcove.rexaemr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.MessageDTO;

/**
 * 메시지 정보를 관리하는 DAO
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
@Repository
@Mapper
public interface MessageDAO {
	/**
	 * SELECT 구문을 이용해 수신된 메시지를 가져오는 메서드
	 * @see com.rexalcove.rexaemr.service.MessageService#getInbox(int)
	 * @param receiver 수신자
	 * @return 수신된 메시지 리스트
	 */
	public List<MessageDTO> getInbox(int receiver);
	/**
	 * SELECT 구문을 이용해 발신된 메시지를 가져오는 메서드 
	 * @see com.rexalcove.rexaemr.service.MessageService#getSent(int)
	 * @param sender 발신자
	 * @return 발신된 메시지 리스트
	 */
	public List<MessageDTO> getSent(int sender);
	/**
	 * INSERT 구문을 이용해 메시지를 발신하는 메서드
	 * @see com.rexalcove.rexaemr.service.MessageService#sendMessage(int, int, String, String)
	 * @param sender 발신자
	 * @param receiver 수신자
	 * @param title 메시지 제목
	 * @param content 메시지 내용
	 */
	public void sendMessage(int sender, int receiver, String title, String content);
}
