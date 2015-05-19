package com.adrian.mauction.controller.interfaces;


import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adrian.mauction.socketio.ProductChangeObserver;

@Controller
public class ILoginController extends AbstractInterfaceController {
	
	@Resource
	private ProductChangeObserver productChangeObserver;

	@RequestMapping("checklogin.json")
	public ResponseEntity<String> checkLogin() {
		productChangeObserver.notify(1l, 600, 111l, true);
		return buildResponse(new Object());
	}
}
