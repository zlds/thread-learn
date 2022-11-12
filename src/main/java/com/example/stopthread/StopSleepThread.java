package com.example.stopthread;

/**
 * @author: hanchaowei
 * @date 2022/11/6
 * @description:
 */

public class StopSleepThread {
	public static void main(String[] args) throws InterruptedException {
		Runnable runnable = () -> {
			int num = 0;
			try {
				while (!Thread.currentThread().isInterrupted() && num <= 1000) {
					System.out.println(num);
					num++;
					Thread.sleep(1000000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
		thread.sleep(5);
		thread.interrupt();

	}


	// 再次中断
	private void reInterrupt(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}
	}













}
