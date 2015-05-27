package com.adrian.mauction.controller.interfaces;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adrian.mauction.common.ErrorCode;
import com.adrian.mauction.exception.ServiceException;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class AbstractInterfaceController {
	
	private static final MultiValueMap<String, String> HEADER;
	
	static {
		HEADER = new LinkedMultiValueMap<String, String>();
		HEADER.put("Content-Type", Arrays.asList("application/json;charset=UTF-8"));
	}

	/**
	 * demo:
	 * {
	 *   "state":{
	 *     "code":200
	 *   },
	 *   "body": {
	 *   }
	 * }
	 * code等于200，为请求正常处理
	 * @param body
	 * @return
	 */
	public <T> ResponseEntity<String> buildResponse(T body) {
		JSONObject response = new JSONObject();
		JSONObject state = new JSONObject();
		state.put("code", 200);
		response.put("state", state);
		response.put("body", body);
		return new ResponseEntity<String>(JSON.toJSONString(response), HEADER, HttpStatus.OK);
	}
	
	/**
	 * demo:
	 * {
	 *   "state":{
	 *     "code":500,
	 *     "msg":"服务器处理异常"
	 *   },
	 *   "body": {
	 *   }
	 * }
	 * code不等于200，为请求处理异常
	 * @param body
	 * @param code
	 * @param message
	 * @return
	 */
	public <T> ResponseEntity<String> buildErrorResponse(T body, Integer code, String message) {
		JSONObject response = new JSONObject();
		JSONObject state = new JSONObject();
		state.put("code", code);
		state.put("msg", message);
		response.put("state", state);
		response.put("body", body);
		return new ResponseEntity<String>(JSON.toJSONString(response), HEADER, HttpStatus.OK);
	}
	
	public <T> ResponseEntity<String> buildErrorResponse(T body, ErrorCode code) {
		return buildErrorResponse(body, code.getCode(), code.getMessage());
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handle(Exception e) {
		if (e instanceof ServiceException) {
			Integer errorCode = ((ServiceException) e).getErrorCode();
			return buildErrorResponse(null, errorCode, e.getMessage());
		}
		return buildErrorResponse(null, ErrorCode.SERVER_RUNTIME);
	}
}
