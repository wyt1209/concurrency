package Chapter3.lesson3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	
	private final Semaphore semaphore;
	
	private boolean freePrinters[];  //��ӡ��״̬:����/���ڴ�ӡ
	
	private Lock lockPrinters;   	 //������freePrinters����ķ���
	
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
			//1.ͨ��acquire()��������ź���
			semaphore.acquire();
			
			int assignedPrinter = getPrinter();
			
			//2.ʹ�ù�����Դִ�б�Ҫ�Ĳ���
			long duration = (long)(Math.random()*10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer %d during %d seconds\n", 
						Thread.currentThread().getName() ,assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);
			
			freePrinters[assignedPrinter] = true;
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			//3.����ͨ��release()�����ͷ��ź���
			semaphore.release();
		}
	}
	
	private int getPrinter(){
		int ret = 1; //��ӡ�����
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
