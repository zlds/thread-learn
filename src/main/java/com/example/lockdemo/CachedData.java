package com.example.lockdemo;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description: 锁升级
 */

public class CachedData {
	Object data;
	volatile boolean cacheValid;

	final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	void processCachedData() {
		rwl.readLock().lock();
		if (!cacheValid) {
			// 在获取写锁之前，必须先释放读锁
			rwl.readLock().unlock();
			rwl.writeLock().lock();
			try {
				// 需要再次判断数据的有效性，因为在我们释放读锁和写锁的空隙之内，可能有其他线程修改了数据。
				if (!cacheValid) {
					data = new Object();
					cacheValid = true;
				}
				rwl.readLock().lock();
			} finally {
				// 释放了写锁，但是依然持有读锁
				rwl.writeLock().unlock();
			}
		}
		try {
			System.out.println(data);
		} finally {
			// 释放读锁
			rwl.readLock().unlock();
		}
	}
	// 不支持升级锁,违法了原则: 如ABC三个线程读锁，A在读的过程中尝试从读锁升级到写锁，那么它必须等BC释放掉读锁才能升级成功。
	void upgrade() {
		rwl.readLock().lock();
		System.out.println("获取到了读锁");
		rwl.writeLock().lock();
		System.out.println("升级锁成功");
	}
	public static void main(String[] args) {
		CachedData cachedData = new CachedData();
		cachedData.processCachedData();
		cachedData.upgrade();
	}


	/*
	为什么要锁升级：在刚刚的方法中，如果一开始使用写锁的话，虽然线程是安全的，但是没有必要，因为我们只有一处代码修改数据。
	如果用写锁就不能让多个线程来读取了，持有写锁是浪费资源的，降低了整体的效率。所以上面的利用锁的降级是很好的办法。
	 */










}
