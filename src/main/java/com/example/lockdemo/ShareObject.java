package com.example.lockdemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class ShareObject {
	int count = 0;
	ReentrantLock lock = new ReentrantLock();

	public void cout() throws InterruptedException {
		// 线程等待一秒，如果获取不到则放弃。
		System.out.println(Thread.currentThread().getName() + "尝试获取锁");
		boolean lock = this.lock.tryLock(1, TimeUnit.NANOSECONDS);
		if (lock) {
			try {
				System.out.println(Thread.currentThread().getName() + "拿到了锁");
				count++;
			} finally {
				this.lock.unlock();
				System.out.println(Thread.currentThread().getName() + "释放了锁");
			}
		} else {
			System.out.println(Thread.currentThread().getName() + "获取锁失败");
		}
		//		lock.lock();
		//		try {
		//			System.out.println(Thread.currentThread().getName() + "拿到了锁");
		//			count++;
		//		} finally {
		//			this.lock.unlock();
		//			System.out.println(Thread.currentThread().getName() + "释放了锁");
		//		}

	}

	public static void main(String[] args) throws InterruptedException {
		ShareObject shareObject = new ShareObject();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					shareObject.cout();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					shareObject.cout();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
