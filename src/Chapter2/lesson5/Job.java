package Chapter2.lesson5;

public class Job implements Runnable {

	private PrintQueue printQueue;
	
	public Job(PrintQueue printQueue) {
		super();
		this.printQueue = printQueue;
	}

	@Override
	public void run() {
		System.out.printf("%s: Going to print a document\n",
				Thread.currentThread().getName());
		
		printQueue.printJob(new Object());
		
		System.out.printf("%s: The Document has been printed\n",
				Thread.currentThread().getName());
	}

}
