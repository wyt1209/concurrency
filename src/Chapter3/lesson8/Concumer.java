package Chapter3.lesson8;

import java.util.List;
import java.util.concurrent.Exchanger;

public class Concumer implements Runnable {
	
	private List<String> buffer;
	
	private final Exchanger<List<String>> exchanger;
	
	public Concumer(List<String> buffer, Exchanger<List<String>> exchanger){
		this.buffer = buffer;
		this.exchanger = exchanger;
	}
	
	@Override
	public void run() {
		int cycle = 1;
		for(int i=0;i<10;i++){
			System.out.printf("Concumer: Cycle %d\n", cycle);
			try {
				buffer = exchanger.exchange(buffer);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			for(int j=0;j<10;j++){
				String message = buffer.get(0);
				System.out.println("Concumer: "+ message);
				buffer.remove(0);
			}
			
			cycle++;
		}

	}

}
