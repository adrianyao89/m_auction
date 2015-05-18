package com.adrian.mauction.controller.interfaces;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ILoginController extends AbstractInterfaceController {

	@RequestMapping("checklogin.json")
	public ResponseEntity<String> checkLogin() {
		return buildResponse(new Object());
	}
}
