package Chapter3.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {

	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<String>();
		List<String> buffer2 = new ArrayList<String>();
		
		Exchanger<List<String>> exchanger = new Exchanger();
		
		Producer producer = new Producer(buffer1, exchanger);
		Concumer concumer = new Concumer(buffer1, exchanger);
		
		Thread threadProducer = new Thread(producer);
		Thread threadConcumer = new Thread(concumer);
		threadProducer.start();
		threadConcumer.start();
		
	}

}
