package com.gsm.curd.bean;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	/**
	 * 100 success
	 * 200 fail
	 */
	private int code;
	
	private String msg;
	
	private Map<String,Object> extend = new HashMap<String,Object>();
	
	public Msg success() {
		return new Msg(100,"action success!");		
	}
	
	public Msg fail() {
		return new Msg(200,"action fail!");		
	}
	
	public Msg add(String key,Object value) {
		this.getExtend().put(key,value);
		return this;		
	}

	public int getCode() {
		return code;
	}

	public Msg(int code, String msg, Map<String, Object> extend) {
		super();
		this.code = code;
		this.msg = msg;
		this.extend = extend;
	}
	
	public Msg(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	public Msg() {
		
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}
}
