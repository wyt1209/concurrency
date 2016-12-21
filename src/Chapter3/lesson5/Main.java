package Chapter3.lesson5;

import java.util.concurrent.CyclicBarrier;

public class Main {

	public static void main(String[] args) {
		final int ROWS = 10000;    	  //����
		final int NUMBERS = 1000;  	  //ÿ��Ԫ�ظ���
		final int SEARCH = 5;      	  //����ѯԪ��ֵ
		final int PARTICIPANTS  = 5;  //�߳���
		final int LINES_PARTICIPANT = 2000; 
		
		MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
		Results results = new Results(ROWS);
		Grouper grouper = new Grouper(results);  
		
//		CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
		CyclicBarrier barrier = new CyclicBarrier(6);
		
		Searcher searchers[] = new Searcher[PARTICIPANTS];
		for(int i=0;i<PARTICIPANTS;i++){
			searchers[i] = new Searcher(i*LINES_PARTICIPANT, (i*LINES_PARTICIPANT)+LINES_PARTICIPANT, mock, results, SEARCH, barrier);
			Thread thread = new Thread(searchers[i]);
			thread.start();
		}	
		
	}

}
