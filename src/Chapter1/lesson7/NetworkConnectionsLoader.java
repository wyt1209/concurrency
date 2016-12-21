package Chapter1.lesson7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkConnectionsLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Beginning network connections loading:%s \n", new Date());
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			System.out.printf("The FileClock has been interrupterd");
			return;
		}
		System.out.printf("Network connections loading finish:%s \n", new Date());
	}
}
