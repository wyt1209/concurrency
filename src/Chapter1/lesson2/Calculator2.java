package Chapter1.lesson2;

public class Calculator2 extends Thread {
	private int number;

	public Calculator2(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			System.out.printf("%s: %d * %d = %d\n", Thread.currentThread()
					.getName(), number, i, number * i);
			
//			if(Thread.currentThread().getName().equals("Thread-6")){
//				System.exit(0);  # 所有线程都将结束
//			}
		}

	}
	
	public static void main(String[]args){
		for(int i=1;i<=10;i++){
			Calculator2 calculator = new Calculator2(i);
			calculator.setName("Thread-"+i);
			calculator.start();
		}
	}

}
