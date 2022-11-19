package com.example.lockdemo;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: hanchaowei
 * @date 2022/11/19
 * @description:
 */

public class ReentrantLockWithCondition {
	Stack<String> stack = new Stack<>();
	int CAPACITY = 5;
	ReentrantLock lock = new ReentrantLock();
	Condition stackEmptyCondition = lock.newCondition();
	Condition stackFullCondition = lock.newCondition();

	public void pushToStack(String s) throws InterruptedException {
		try {
			lock.lock();
			while (stack.size() == CAPACITY) {
				stackFullCondition.await();
			}
			stack.push(s);
			stackEmptyCondition.signalAll();
		} finally {
			lock.unlock();
		}
	}

	public String popFromStack() throws InterruptedException {
		try {
			lock.lock();
			while (stack.size() == 0) {
				stackEmptyCondition.await();
			}
			return stack.pop();
		} finally {
			stackFullCondition.signalAll();
			lock.unlock();
		}
	}










}
