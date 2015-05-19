package com.adrian.mauction.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ThreadPool {

	private static final ExecutorService EXECUTOR;

	static {
		EXECUTOR = Executors.newFixedThreadPool(1000);
	}
	
	public static final <T extends Runnable> void run(T t) {
		EXECUTOR.execute(t);
	}
}
