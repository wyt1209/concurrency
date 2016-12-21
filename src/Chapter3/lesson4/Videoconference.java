package Chapter3.lesson4;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {

	private final CountDownLatch controller;
	
	/*
	 * ��ʹ��CountdownLatch����ʱ��ʹ�ù�������ʼ���ڲ���������
	 * ��countDown()����������ʱ������������1��
	 * ������������0ʱ��CountdownLatch���󽫻���������await()�����ϵȴ����߳�
	 */
	public Videoconference(int number) {
		this.controller = new CountDownLatch(number);
	}

	public void arrive(String name){
		System.out.printf("%s has arrived.", name);
		controller.countDown();   //ÿ�����ȴ����¼������ʱ����
		System.out.printf("Videoconference: Waiting for %d participants.\n", controller.getCount());
	}
	public void run() {
		System.out.printf("Videoconference: Initialization: %d participants .\n", controller.getCount());
		try {
			controller.await();  //��Ҫ�ȴ������߳��¼�����ɵ����̵߳���
			System.out.printf("Videoconference: All the participants have come.\n");
			System.out.printf("Videoconference: Let's start ...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}

}
