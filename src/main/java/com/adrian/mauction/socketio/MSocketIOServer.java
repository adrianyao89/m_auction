package com.adrian.mauction.socketio;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class MSocketIOServer {
	
	private int port = 18080;
	
	private String hostname = "127.0.0.1";
	
	private SocketIOServer server;
	
	private Object listeners;

	public void init() {
		Configuration config = new Configuration();
        config.setPort(port);
        config.setHostname(hostname);

        server = new SocketIOServer(config);
        server.addListeners(listeners);
        server.start();
	}
	
	public void destroy() {
		server.stop();
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

}
