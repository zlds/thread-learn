package com.example.stopthread;

/**
 * @author: hanchaowei
 * @date 2022/11/6
 * @description:
 */

public class VolatileCanStop implements Runnable {
	private volatile boolean cancelled = false;

	@Override
	public void run() {
		int num = 0;
		try {
			while (!cancelled && num <= 10000) {
				if (num % 10 == 0) {
					System.out.println(num + "是10的倍数");
				}
			}
			num++;
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileCanStop r = new VolatileCanStop();
		Thread t1 = new Thread(r);
		t1.start();
		t1.sleep(3000);
		r.cancelled = true;













	}

}
