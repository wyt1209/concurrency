package Chapter3.lesson3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	private final Semaphore semaphore;
	
	private boolean freePrinters[];  //打印机状态:空闲/正在打印
	
	private Lock lockPrinters;   	 //保护对freePrinters数组的访问
	
	public PrintQueue(){
		semaphore = new Semaphore(3);
		lockPrinters = new ReentrantLock();
		freePrinters = new boolean[3];
		for(int i=0;i<3;i++){
			freePrinters[i] = true;
		}		
	}
	
	public void printJob(Object ducument){
		try {
			//1.通过acquire()方法获得信号量
			semaphore.acquire();
			
			int assignedPrinter = getPrinter();
			
			//2.使用共享资源执行必要的操作
			long duration = (long)(Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", 
						Thread.currentThread().getName() ,assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);
			
			freePrinters[assignedPrinter] = true;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//3.必须通过release()方法释放信号量
			semaphore.release();
		}
	}
	
	private int getPrinter(){
		int ret = 1; //打印机编号
		try{
			lockPrinters.lock();
			for(int i=0;i<freePrinters.length;i++){
				if(freePrinters[i]){
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			lockPrinters.unlock();
		}
		return ret;
		
	}
}
