package Chapter1.lesson10;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {
	
	private Date startDate;
	
	@Override
	public void run() {
		startDate = new Date();
		System.out.printf("Starting Thread: %s : %s\n", Thread.currentThread().getId(),startDate);
		try {
			TimeUnit.SECONDS.sleep((int)Math.rint(Math.random()*10));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Thread Finish: %s : %s\n", Thread.currentThread().getId(),startDate);

	}
	
	public static void main(String[]args){
		UnsafeTask unsafe = new UnsafeTask();
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
