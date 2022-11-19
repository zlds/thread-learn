package com.example.lockdemo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class SynchronizedHashMapWithReadWriteLock {
	Map<String, String> map = new HashMap<>();
	ReadWriteLock lock = new ReentrantReadWriteLock();

	public void put(String key, String value) {
		lock.writeLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "开始写");
			map.put(key, value);
		} finally {
			lock.writeLock().unlock();
			System.out.println(Thread.currentThread().getName() + "写完成");
		}
	}

	public void get(String key) {
		lock.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "开始读");
			map.get(key);
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
			System.out.println(Thread.currentThread().getName() + "读完毕");
		}
	}

	public static void main(String[] args) {
		SynchronizedHashMapWithReadWriteLock readLock = new SynchronizedHashMapWithReadWriteLock();
		readLock.map.put("test", "1");
		// 两个线程可以同时读取
		//		new Thread(new Runnable() {
		//			@Override
		//			public void run() {
		//				readLock.get("test");
		//			}
		//		}).start();
		//
		//		new Thread(new Runnable() {
		//			@Override
		//			public void run() {
		////				readLock.put("test1","test1");
		//				readLock.get("test");
		//			}
		//		}).start();


		// 当一个线程持有读锁之后，另一个写线程必须等锁释放之后才能写入
		new Thread(new Runnable() {
			@Override
			public void run() {
				readLock.get("test");
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				//				readLock.put("test1","test1");
				readLock.put("test1", "test1");
			}
		}).start();
	}


}
