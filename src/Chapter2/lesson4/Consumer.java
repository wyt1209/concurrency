package Chapter2.lesson4;

public class Consumer implements Runnable {
	
	private EventStorage eventStorage;
	
	public Consumer(EventStorage eventStorage) {
		super();
		this.eventStorage = eventStorage;
	}

	@Override
	public void run() {
		for(int i=0;i<100;i++){
			eventStorage.get();
		}
	}

}
