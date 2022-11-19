package com.example.multithread;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: hanchaowei
 * @date 2022/11/13
 * @description:
 */

public class WrongInit {
	private Map<Integer,String> map;

	public WrongInit() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				map = new HashMap<>();
				map.put(1,"张三");
				map.put(2,"李四");
			}
		}).start();
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public static void main(String[] args) {
		WrongInit wrongInit = new WrongInit();
		wrongInit.getMap().get(0);
	}
}
