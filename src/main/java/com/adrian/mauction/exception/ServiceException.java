package com.adrian.mauction.exception;

import com.adrian.mauction.common.ErrorCode;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private ErrorCode errorCode;
	
	public ServiceException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public ServiceException(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}
	
	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
