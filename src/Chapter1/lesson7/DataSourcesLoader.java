package Chapter1.lesson7;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourcesLoader implements Runnable {

	@Override
	public void run() {
		System.out.printf("Beginning data source loading:%s \n", new Date());
		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			System.out.printf("The FileClock has been interrupterd");
			return;
		}
		System.out.printf("Data source loading finish:%s \n", new Date());
	}
}
