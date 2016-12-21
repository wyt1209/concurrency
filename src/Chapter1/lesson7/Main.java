package Chapter1.lesson7;

import java.util.Date;

public class Main {
	public static void main(String[]args){
		DataSourcesLoader dataSourcesLoader = new DataSourcesLoader();
		Thread thread1 = new Thread(dataSourcesLoader);
		
		NetworkConnectionsLoader networkConnectionsLoader = new NetworkConnectionsLoader();
		Thread thread2 = new Thread(networkConnectionsLoader);
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
//			thread2.join(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Main configure has been loaded:%s \n", new Date());
		
	}
}
