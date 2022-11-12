package com.example.createthread;

/**
 * @author: hanchaowei
 * @date 2022/11/6
 * @description:
 */

public class AnnoThreadDemo {
	public static void main(String[] args) {
		// lambda表达式创建线程
		new Thread(() -> System.out.println(Thread.currentThread().getName())).start();

		// 匿名内部类2
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
			}
		}).start();























	}
}
