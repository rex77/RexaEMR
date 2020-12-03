package com.rexalcove.rexaemr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rexalcove.rexaemr.dao.MessageDAO;
import com.rexalcove.rexaemr.dto.MessageDTO;

@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	MessageDAO messageDao;
	
	@Override
	public List<MessageDTO> getInbox(int receiver) {
		// TODO Auto-generated method stub
		return messageDao.getInbox(receiver);
	}

	@Override
	public List<MessageDTO> getSent(int sender) {
		// TODO Auto-generated method stub
		return messageDao.getSent(sender);
	}

	@Override
	public void sendMessage(int sender, int receiver, String title, String content) {
		// TODO Auto-generated method stub
		messageDao.sendMessage(sender, receiver, title, content);
	}

}
