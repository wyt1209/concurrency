package Chapter3.lesson4;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		//������Ƶ�������̵߳ȴ��λ���(10��)�ĵ���
		Videoconference conference = new Videoconference(10);
		Thread threadConference = new Thread(conference);
		threadConference.start();
		
		//�����½������
		for(int i=0;i<10;i++){
			Thread thread = new Thread(new Participant(conference,"Participant "+i));
			thread.start();
		}
		
	}

}
