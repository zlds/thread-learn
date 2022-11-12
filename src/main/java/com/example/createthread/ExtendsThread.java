package com.example.createthread;

/**
 * @author: hanchaowei
 * @date 2022/11/6
 * @description:
 */

public class ExtendsThread extends Thread {
	@Override
	public void run() {
		System.out.println("用Thread类实现线程");
	}
}
