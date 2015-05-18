package com.adrian.mauction.common;

public enum ErrorCode {

	SERVER_RUNTIME(500, "服务器错误");
	
	private int code;
	
	private String message;
	
	private ErrorCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}

}
