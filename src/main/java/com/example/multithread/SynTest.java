package com.example.multithread;

/**
 * @author: hanchaowei
 * @date 2022/11/13
 * @description:
 */

public class SynTest {

	public void synBook() {
		synchronized (this) {
			System.out.println("哈哈哈");
		}
	}
}
