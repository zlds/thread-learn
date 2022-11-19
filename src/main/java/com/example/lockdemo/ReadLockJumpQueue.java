package com.example.lockdemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description: 读锁不插队
 */

public class ReadLockJumpQueue {
	private static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private static final ReentrantReadWriteLock.ReadLock readLock = rwl.readLock();
	private static final ReentrantReadWriteLock.WriteLock writeLock = rwl.writeLock();

	public static void read() {
		readLock.lock();
		try {
			System.out.printf(Thread.currentThread().getName() + "得到读锁，正在读取");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + "释放读锁");
			readLock.unlock();
		}
	}

	private static void write() {
		writeLock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "得到写锁，正在写入");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(Thread.currentThread().getName() + "释放写锁");
			writeLock.unlock();
		}
	}

	public static void main(String[] args) {
		new Thread(() -> read(), "Thread-2").start();
		new Thread(() -> read(), "Thread4").start();
		new Thread(() -> write(), "Thread-3").start();
		// 必须等待写锁释放之后才能获取到读锁，公平
		new Thread(() -> read(), "Thread-5").start();
	}


}
