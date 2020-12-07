package com.rexalcove.rexaemr.util;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * ResultData를 관리하는 유틸리티 클래스
 * @author Rexa
 * @version 1.0.0 20/12/07
 */
public class ResultData {
	
	JSONObject header = new JSONObject();
	JSONObject body = new JSONObject();

	/**
	 * JSONDATA 헤더를 설정하는 메서드
	 * @param code 반환할 코드
	 * @param msg 반환할 메시지
	 */
	public void setHeader(String code, String msg) {
		header.put("code", code);
		header.put("msg", msg);
	}
	
	/**
	 * JSONDATA 바디를 설정하는 메서드
	 * @param body 반환할 JSON 형식의 컨텐츠
	 */
	public void setBody(JSONObject body) {
		this.body = body;
	}
	
	/**
	 * JSONDATA 바디를 설정하는 메서드 (Array 형식)
	 * @param cnt 데이터의 개수
	 * @param data JSONArray 형태의 데이터
	 */
	public void setBody(int cnt, JSONArray data) {
		body.put("cnt", cnt);
		body.put("data", data);
	}
	
	/**
	 * JSONObject 형태로 저장된 데이터를 반환한다
	 * @return
	 */
	public JSONObject getResultData() {
		JSONObject obj = new JSONObject();
		obj.put("header", header);
		obj.put("body",  body);
		return obj;
	}
}
