package com.example.lockdemo;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class TryLockTest {
	private ArrayList<Integer> arrayList = new ArrayList<>();
	private Lock lock = new ReentrantLock();

	public void insert(Thread t) {
		// 如果返回true表示获取成功，否则获取失败，在拿不到锁时不会一直等待
		if (lock.tryLock()) {
			try {
				System.out.println(t.getName() + "得到了锁");
				for (int i = 0; i < 5; i++) {
					arrayList.add(i);
				}
			}finally {
				System.out.println(t.getName() + "释放了锁");
			}
		} else {
			System.out.println(t.getName() + "获取锁失败了");
		}
	}

	public static void main(String[] args) {
		TryLockTest tryLockTest = new TryLockTest();

		new Thread(new Runnable() {
			@Override
			public void run() {
				tryLockTest.insert(Thread.currentThread());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				tryLockTest.insert(Thread.currentThread());
			}
		}).start();
	}
}
