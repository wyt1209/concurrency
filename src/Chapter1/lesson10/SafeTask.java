package Chapter1.lesson10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SafeTask implements Runnable {
	
	private static ThreadLocal<Date> startDate = new ThreadLocal<Date>(){
		@Override
		protected Date initialValue() {
			return new Date();
		}
	};
	
	@Override
	public void run() {
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(),startDate.get());
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finish: %s : %s\n", Thread.currentThread().getId(),startDate.get());

	}
	
	public static void main(String[]args){
		SafeTask unsafe = new SafeTask();
		for(int i=0;i<10;i++){
			Thread thread = new Thread(unsafe);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
