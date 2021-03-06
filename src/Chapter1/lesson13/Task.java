package Chapter1.lesson13;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable{

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (Exception e) {
		}	
	}
	
	public static void main(String[]args){
		MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");
		Task task = new Task();
		Thread thread;
		System.out.printf("Starting the Threads\n");
		for(int i=0;i<10;i++){
			thread = factory.newThread(task);
			thread.start();
		}
		
		System.out.printf("Factory stats:\n");
		System.out.printf("%s\n",factory.getStats());
		
	}
}
