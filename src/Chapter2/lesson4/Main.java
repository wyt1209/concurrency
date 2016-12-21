package Chapter2.lesson4;


public class Main {
	public static void main(String[]args){
		
		EventStorage eventStorage = new EventStorage();
		
		Producer producer = new Producer(eventStorage);
		Thread thread1 = new Thread(producer, "producer");
		
		Consumer consumer = new Consumer(eventStorage);
		Thread thread2 = new Thread(consumer, "consumer");
		
		thread1.start();
		thread2.start();
		
//		try {
//			thread1.join();
//			thread2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
//		System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
//		System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
	}
	
}
