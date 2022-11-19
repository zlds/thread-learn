package com.example.reentrantlockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2022/11/17
 * @description:
 */

public class ReentrantLockNoFairTest {
	/**
	 * 非公平锁
	 * 返回结果: AA,BB,CC
	 */
	static Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			new Thread(() -> {
				for (int j = 0; j < 2; j++) {
					lock.lock();
					System.out.println("当前线程: " + Thread.currentThread().getName());
					lock.unlock();
				}
			}).start();
		}
	}
}
