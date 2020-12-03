package com.rexalcove.rexaemr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.rexalcove.rexaemr.dto.MessageDTO;

@Repository
@Mapper
public interface MessageDAO {
	public List<MessageDTO> getInbox(int receiver);
	public List<MessageDTO> getSent(int sender);
	public void sendMessage(int sender, int receiver, String title, String content);
}
