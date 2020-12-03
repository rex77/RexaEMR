package com.rexalcove.rexaemr.service;

import java.util.List;

import com.rexalcove.rexaemr.dto.MessageDTO;

public interface MessageService {
	public List<MessageDTO> getInbox(int receiver);
	public List<MessageDTO> getSent(int sender);
	public void sendMessage(int sender, int receiver, String title, String content);
}
