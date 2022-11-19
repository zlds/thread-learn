package com.example.waitDemo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: hanchaowei
 * @date 2022/11/12
 * @description:
 */

public class BlockingQueue {
	Queue<String> buffer = new LinkedList<>();

	public  void give(String data) {
		buffer.add(data);
		notify();
	}

	public String take() throws InterruptedException {
		while (buffer.isEmpty()) {
			wait();
		}
		return buffer.remove();
	}


















}
