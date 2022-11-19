package com.example.lockdemo;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class LockTest {
	private ArrayList<Integer> arrayList = new ArrayList<>();
	// 声明全局变量，每个线程使用同一把锁
	private Lock lock = new ReentrantLock();

	private void insert(Thread t) {

		lock.lock();
		try {
			System.out.println(t.getName() + "得到了锁");
			for (int i = 0; i < 5; i++) {
				arrayList.add(i);
			}
		} finally {
			System.out.println(t.getName() + "释放了锁");
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		LockTest lockTest = new LockTest();

		new Thread(new Runnable() {
			@Override
			public void run() {
				lockTest.insert(Thread.currentThread());
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				lockTest.insert(Thread.currentThread());
			}
		}).start();
	}


}
