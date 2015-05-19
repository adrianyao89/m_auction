package com.adrian.mauction.socketio;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

import com.adrian.mauction.concurrent.ThreadPool;
import com.adrian.mauction.socketio.bean.PriceChangeNotify;
import com.corundumstudio.socketio.SocketIOClient;

public class ProductChangeObserver {

	private Map<SocketIOClient, Set<Long>> clientToProducts = new ConcurrentHashMap<SocketIOClient, Set<Long>>();
	
	private Map<Long, Set<SocketIOClient>> productToClients = new ConcurrentHashMap<Long, Set<SocketIOClient>>();
	
	public Object monitor = new Object();
	
	public Object sendMonitor = new Object();
	
	public void regInfo(SocketIOClient client, List<Long> products) {
		synchronized (monitor) {
			Set<Long> productIds = clientToProducts.get(client);
			if (null == productIds) {
				productIds = new CopyOnWriteArraySet<>(products);
				clientToProducts.put(client, productIds);
			} else {
				productIds.addAll(productIds);
			}
			
			for (Long product : products) {
				Set<SocketIOClient> clients = productToClients.get(product);
				if (null == clients) {
					clients = new CopyOnWriteArraySet<>(clients);
					productToClients.put(product, clients);
				} else {
					clients.add(client);
				}
			}
		}
	}
	
	public void remove(SocketIOClient client) {
		synchronized (monitor) {
			Set<Long> productIds = clientToProducts.get(client);
			if (productIds != null) {
				for (Long product : productIds) {
					Set<SocketIOClient> clients = productToClients.get(product);
					if (clients != null) {
						clients.remove(client);
					}
				}
			}
		}
	}
	
	public void notify(final Long product, final int price, final long times, boolean syn) {
		Set<SocketIOClient> clients = productToClients.get(product);
		if (clients == null) {
			return;
		}
		
		for (final SocketIOClient client : clients) {
			if (syn) {
				ThreadPool.run(new Runnable() {
					public void run() {
						client.sendEvent("update_product", new PriceChangeNotify(product, price, times));
					}
				});
			} else {
				client.sendEvent("update_product", new PriceChangeNotify(product, price, times));
			}
		}
	}
	
}
