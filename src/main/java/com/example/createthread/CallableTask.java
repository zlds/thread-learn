package com.example.createthread;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author: hanchaowei
 * @date 2022/11/6
 * @description:
 */

public class CallableTask implements Callable<Integer> {
	@Override
	public Integer call() throws Exception {
		return new Random().nextInt();
	}

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		Future<Integer> submit = executorService.submit(new CallableTask());
		try {
			System.out.println(submit.get().toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
}
