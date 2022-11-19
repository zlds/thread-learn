package com.example.maplearn;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: hanchaowei
 * @date 2022/11/13
 * @description:
 */

public class MapNull {
	public static void main(String[] args) {
		// hashMap运行key,value空值
		Map<String,Object> map = new HashMap<>();
		map.put(null,1);
		map.put(null,2);
		map.put("a",null);
		map.put("b",null);
		System.out.println(map);

		// LinkedHashMap 不允许key,value空值
		Map<String,Object> lm = new LinkedHashMap<>();
		lm.put(null,1);
		lm.put(null,2);
		lm.put("a",null);
		lm.put("b",null);
		System.out.println(lm);

		// hashTable 不允许key,value空值
		Map<String, Object> tMap = new Hashtable<>();
//		tMap.put(null,"a");
//		tMap.put("b",null);
//		System.out.println(tMap);
		// ConcurrentHashMap不允许key,value空值
		Map<String, Object> cm = new ConcurrentHashMap<>();
//		cm.put(null,"a");
//		cm.put("b",null);
		cm.put("","b");
		cm.put("","c");
		System.out.println(cm);
	}

}
