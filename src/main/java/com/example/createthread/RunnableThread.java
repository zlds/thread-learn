package com.example.createthread;

/**
 * @author: hanchaowei
 * @date 2022/11/6
 * @description:
 */

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println("用实现Runnable接口实现线程");
	}
}
