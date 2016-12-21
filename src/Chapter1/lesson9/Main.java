package Chapter1.lesson9;


public class Main {
	public static void main(String[]args){
		
		Task task = new Task();
		Thread thread = new Thread(task);
		// 当线程抛出一个未捕获到的异常时，JVM将为异常寻找以下三种可能的处理器：1.线程对象未捕获异常处理器->2.线程组处理器->3.线程级静态处理器
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
//		thread.setGroupUncaughtExceptionHandler
//		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
