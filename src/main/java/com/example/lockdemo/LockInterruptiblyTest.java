package com.example.lockdemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class LockInterruptiblyTest {
	private Lock lock = new ReentrantLock();

	public void insert(Thread t) throws InterruptedException {
		lock.lockInterruptibly();
		try {
			System.out.println(t.getName() + "得到了锁");
			long startTime = System.currentTimeMillis();
			for (; ; ) {
				if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE) {
					break;
				}
			}
		} finally {
			System.out.println(t.getName() + "执行了finally");
			lock.unlock();
			System.out.println(t.getName() + "释放了锁");
		}
	}

	public static void main(String[] args) {
		LockInterruptiblyTest lock = new LockInterruptiblyTest();
		MyThread t1 = new MyThread(lock);
		MyThread t2 = new MyThread(lock);
		t1.start();
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.interrupt();
	}


}
