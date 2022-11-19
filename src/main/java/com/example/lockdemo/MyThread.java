package com.example.lockdemo;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class MyThread extends Thread {
	private LockInterruptiblyTest lockInterruptiblyTest = null;

	public MyThread(LockInterruptiblyTest lockInterruptiblyTest) {
		this.lockInterruptiblyTest = lockInterruptiblyTest;
	}

	@Override
	public void run() {
		try {
			lockInterruptiblyTest.insert(Thread.currentThread());
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + "被中断");
		}
	}
}
