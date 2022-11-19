package com.example.waitDemo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2022/11/12
 * @description:
 */

public class PullDemo {
	public static void main(String[] args) throws InterruptedException {
		Map<String, Object> map = new HashMap<>();
		map.put("a",null);
		System.out.println(map.toString());

//		BlockingQueue b = new BlockingQueue();
//		b.take();
	}
}
