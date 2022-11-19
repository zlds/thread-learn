package com.example.lockdemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class ReentrantReadTest {
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	// synchronized多个线程同时读操作效果.只有当第一个线程读取完毕后，第二个线程才能进行读操作。
	//	public synchronized void get(Thread t) {
	//		long start = System.currentTimeMillis();
	//		while (System.currentTimeMillis() - start <= 1) {
	//			System.out.println(t.getName() + "正在进行读操作");
	//		}
	//		System.out.println(t.getName() + "读操作完毕");
	//	}
	// 通过读写锁读取，thread1和thread2可以同时进行读操作
	public void get(Thread t) {
		lock.readLock().lock();
		try {
			long start = System.currentTimeMillis();
			while (System.currentTimeMillis() - start <= 1) {
				System.out.println(t.getName() + "正在进行读操作");
			}
			System.out.println(t.getName() + "读操作完毕");
		} finally {
			lock.readLock().unlock();
		}
	}

	public static void main(String[] args) {
		final ReentrantReadTest test = new ReentrantReadTest();

		new Thread(() -> {
			test.get(Thread.currentThread());
		}).start();

		new Thread(() -> {
			test.get(Thread.currentThread());
		}).start();
	}


}
