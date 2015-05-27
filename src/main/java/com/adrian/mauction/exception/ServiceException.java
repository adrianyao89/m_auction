package com.adrian.mauction.exception;

import com.adrian.mauction.common.ErrorCode;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Integer errorCode;
	
	public ServiceException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode.getCode();
	}
	
	public ServiceException(Integer errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ServiceException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode.getCode();
	}
	
	public ServiceException(Integer errorCode) {
		this.errorCode = errorCode;
	}
	
	public Integer getErrorCode() {
		return errorCode;
	}
}
