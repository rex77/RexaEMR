package com.rexalcove.rexaemr.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rexalcove.rexaemr.dto.DoctorDTO;
import com.rexalcove.rexaemr.dto.MessageDTO;
import com.rexalcove.rexaemr.service.DoctorService;
import com.rexalcove.rexaemr.service.MessageService;
import com.rexalcove.rexaemr.util.ResultData;

import io.swagger.annotations.Api;

/**
 * 메시지를 관리하는 컨트롤러
 * 
 * @author Rexa
 * @version 1.0.0 20/11/30
 */
@Api(tags = { "5. Message" })
@RestController
public class MessageController {
	@Autowired
	MessageService messageService;

	@Autowired
	DoctorService doctorService;

	@GetMapping("/inbox")
	public String getInbox(int receiver) {
		// 변수 선언
		ResultData resultData = new ResultData();
		List<MessageDTO> messageList = null;
		// 로직 처리
		try {
			messageList = messageService.getInbox(receiver);
			if (messageList.size() != 0) {
				resultData.setHeader("200", "OK");
				JSONArray data = new JSONArray(messageList);
				resultData.setBody(data.length(), data);
			} else if (messageList.size() == 0) {
				resultData.setHeader("200", "OK");
			} else {
				DoctorDTO receiverDto = doctorService.getDoctor(receiver);
				if (receiverDto == null) {
					resultData.setHeader("404", "Given Receiver Not Found");
				}
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	@GetMapping("/sent")
	public String getSent(int sender) {
		// 변수 선언
		ResultData resultData = new ResultData();
		List<MessageDTO> messageList = null;
		// 로직 처리
		try {
			messageList = messageService.getSent(sender);
			resultData.setHeader("200", "OK");
			if (messageList.size() != 0) {
				JSONArray data = new JSONArray(messageList);
				resultData.setBody(data.length(), data);
			} else if (messageList.size() == 0) {
				resultData.setHeader("200", "OK");
			} else {
				DoctorDTO receiverDto = doctorService.getDoctor(sender);
				if (receiverDto == null) {
					resultData.setHeader("404", "Given Sender Not Found");
				}
			}
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}

	@PostMapping("/sendMessage")
	public String sendMessage(int sender, int receiver, String title, String content) {
		// 변수 선언
		ResultData resultData = new ResultData();
		// 로직 처리
		try {
			messageService.sendMessage(sender, receiver, title, content);
			resultData.setHeader("200", "OK");
			resultData.setBody(new JSONObject().put("count", "1"));
		} catch (Exception e) {
			resultData.setHeader("500", "Internal Server Error");
			resultData.setBody(new JSONObject().put("count", "0"));
			e.printStackTrace();
		}

		return resultData.getResultData().toString();
	}
}
