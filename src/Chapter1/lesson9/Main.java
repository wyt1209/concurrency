package Chapter1.lesson9;


public class Main {
	public static void main(String[]args){
		
		Task task = new Task();
		Thread thread = new Thread(task);
		// ���߳��׳�һ��δ���񵽵��쳣ʱ��JVM��Ϊ�쳣Ѱ���������ֿ��ܵĴ�������1.�̶߳���δ�����쳣������->2.�߳��鴦����->3.�̼߳���̬������
		thread.setUncaughtExceptionHandler(new ExceptionHandler());
//		thread.setGroupUncaughtExceptionHandler
//		Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
		thread.start();
	}
}
