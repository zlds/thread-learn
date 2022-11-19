package com.example.multithread;

/**
 * @author: hanchaowei
 * @date 2022/11/13
 * @description:
 */

public class MultiThreadCount {
	volatile static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				for (int j = 0; j < 10000; j++) {
					i++;
				}
			}
		};
		Thread t1 = new Thread(runnable);
		t1.start();
		Thread t2 = new Thread(runnable);
		t2.start();
		t1.join();
		t2.join();
		System.out.println(i);
	}
}
