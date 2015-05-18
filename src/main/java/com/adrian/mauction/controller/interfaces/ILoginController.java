package com.adrian.mauction.controller.interfaces;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ILoginController extends AbstractInterfaceController {

	@RequestMapping("checklogin.json")
	public ResponseEntity<String> checkLogin() {
		MultiValueMap<String, String> header = new LinkedMultiValueMap<String, String>();
		header.put("Content-Type", Arrays.asList("application/json;charset=UTF-8"));
		ResponseEntity<String> a = new ResponseEntity<String>("{}", header, HttpStatus.OK);
		return a;
	}
}
