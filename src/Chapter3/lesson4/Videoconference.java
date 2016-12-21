package Chapter3.lesson4;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {

	private final CountDownLatch controller;
	
	/*
	 * 当使用CountdownLatch对象时，使用构造器初始化内部计数器。
	 * 当countDown()方法被调用时，计数器将减1。
	 * 当计数器到达0时，CountdownLatch对象将唤起所有在await()方法上等待的线程
	 */
	public Videoconference(int number) {
		this.controller = new CountDownLatch(number);
	}

	public void arrive(String name){
		System.out.printf("%s has arrived.", name);
		controller.countDown();   //每个被等待的事件在完成时调用
		System.out.printf("Videoconference: Waiting for %d participants.\n", controller.getCount());
	}
	public void run() {
		System.out.printf("Videoconference: Initialization: %d participants .\n", controller.getCount());
		try {
			controller.await();  //需要等待其他线程事件先完成的主线程调用
			System.out.printf("Videoconference: All the participants have come.\n");
			System.out.printf("Videoconference: Let's start ...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
