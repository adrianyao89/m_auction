package com.adrian.mauction.socketio.bean;

public class PriceChangeNotify {

	private Long product;
	
	private int price;
	
	private long times;
	
	public PriceChangeNotify(Long product, int price, long times) {
		this.price = price;
		this.product = product;
		this.times = times;
	}
	
	public Long getProduct() {
		return product;
	}
	public void setProduct(Long product) {
		this.product = product;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public long getTimes() {
		return times;
	}
	public void setTimes(long times) {
		this.times = times;
	}
	
}
