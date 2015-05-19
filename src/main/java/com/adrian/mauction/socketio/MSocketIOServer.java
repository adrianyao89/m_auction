package com.adrian.mauction.socketio;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.StringUtils;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

public class MSocketIOServer {
	
	private int port = 18080;
	
	private String hostname = "127.0.0.1";
	
	private SocketIOServer server;
	
	private Object defaultListeners;
	
	private Map<String, Object> listenersMap;

	public void init() {
		Configuration config = new Configuration();
        config.setPort(port);
        config.setHostname(hostname);

        server = new SocketIOServer(config);
        addListerners();
        server.start();
	}
	
	private void addListerners() {
		server.addListeners(defaultListeners);
        if (listenersMap != null) {
        	for (Entry<String, Object> listenersEntry : listenersMap.entrySet()) {
        		String nameSpace = listenersEntry.getKey();
        		Object listeners = listenersEntry.getValue();
        		if (!StringUtils.isEmpty(nameSpace) && listeners != null) {
        			server.addNamespace(nameSpace).addListeners(listeners);
        		}
        	}
        }
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

	public void setDefaultListeners(Object defaultListeners) {
		this.defaultListeners = defaultListeners;
	}

	public void setListenersMap(Map<String, Object> listenersMap) {
		this.listenersMap = listenersMap;
	}

}
