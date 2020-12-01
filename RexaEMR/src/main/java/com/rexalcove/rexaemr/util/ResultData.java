package com.rexalcove.rexaemr.util;

import org.json.JSONArray;
import org.json.JSONObject;

public class ResultData {
	
	JSONObject header = new JSONObject();
	JSONObject body = new JSONObject();

	public void setHeader(String code, String msg) {
		header.put("code", code);
		header.put("msg", msg);
	}
	
	public void setBody(JSONObject body) {
		this.body = body;
	}
	
	public void setBody(int cnt, JSONArray data) {
		body.put("cnt", cnt);
		body.put("data", data);
	}
	
	public JSONObject getResultData() {
		JSONObject obj = new JSONObject();
		obj.put("header", header);
		obj.put("body",  body);
		return obj;
	}
}
