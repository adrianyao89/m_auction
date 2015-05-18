package com.adrian.mauction.socketio.service;

import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;

public class SocketIOListeners {

	@OnConnect
    public void onConnectHandler(SocketIOClient client) {
		System.out.println("connect");
    }
}
