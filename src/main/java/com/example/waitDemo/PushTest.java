package com.example.waitDemo;

/**
 * @author: hanchaowei
 * @date 2022/11/12
 * @description:
 */

public class PushTest {
	public static void main(String[] args) {
		BlockingQueue b = new BlockingQueue();
		b.give("a");
		b.give("b");
		b.give("c");
	}
}
