package com.example.stopthread;

/**
 * @author: hanchaowei
 * @date 2022/11/6
 * @description:
 */

public class StopThread implements Runnable {
	@Override
	public void run() {
		int count = 0;
		// isInterrupted 判断线程是否被中断。如果线程被设置中断，同时count值小于1000，这停止
		while (!Thread.currentThread().isInterrupted() && count < 1000) {
			System.out.println("count = " + count++);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new StopThread());
		t1.start();
		t1.sleep(5);
		t1.interrupt();
	}
}
