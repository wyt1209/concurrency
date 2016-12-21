package Chapter3.lesson2;

import java.util.concurrent.Semaphore;

public class PrintQueue {
	
	private final Semaphore semaphore;
	
	public PrintQueue(){
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object ducument){
		try {
			//1.ͨ��acquire()��������ź���
			semaphore.acquire();
			
			//2.ʹ�ù�����Դִ�б�Ҫ�Ĳ���
			long duration = (long)(Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", 
						Thread.currentThread().getName(),duration);
			Thread.sleep(duration);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//3.����ͨ��release()�����ͷ��ź���
			semaphore.release();
		}
	}
}
