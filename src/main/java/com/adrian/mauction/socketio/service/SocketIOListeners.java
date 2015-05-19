package com.adrian.mauction.socketio.service;

import java.util.List;

import com.adrian.mauction.socketio.ProductChangeObserver;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;

public class SocketIOListeners {
	
	private ProductChangeObserver observer;

	@OnConnect
    public void onConnectHandler(SocketIOClient client) {
    }
	
	@OnEvent("product")
    public void onEventHandler(SocketIOClient client, List<Long> data, AckRequest ackSender) {
		if (data != null && !data.isEmpty()) {
			observer.regInfo(client, data);
		}
    }
	
	@OnDisconnect
    public void onDisConnectHandler(SocketIOClient client) {
		observer.remove(client);
    }

	public void setObserver(ProductChangeObserver observer) {
		this.observer = observer;
	}
	
}
