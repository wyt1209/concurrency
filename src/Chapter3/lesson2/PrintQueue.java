package Chapter3.lesson2;

import java.util.concurrent.Semaphore;

public class PrintQueue {
	
	private final Semaphore semaphore;
	
	public PrintQueue(){
		semaphore = new Semaphore(1);
	}
	
	public void printJob(Object ducument){
		try {
			//1.通过acquire()方法获得信号量
			semaphore.acquire();
			
			//2.使用共享资源执行必要的操作
			long duration = (long)(Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", 
						Thread.currentThread().getName(),duration);
			Thread.sleep(duration);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//3.必须通过release()方法释放信号量
			semaphore.release();
		}
	}
}
