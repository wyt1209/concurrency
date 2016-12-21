package Chapter3.lesson4;


public class Main {

	public static void main(String[] args) throws InterruptedException {
		//启动视频会议室线程等待参会者(10人)的到来
		Videoconference conference = new Videoconference(10);
		Thread threadConference = new Thread(conference);
		threadConference.start();
		
		//与会者陆续到齐
		for(int i=0;i<10;i++){
			Thread thread = new Thread(new Participant(conference,"Participant "+i));
			thread.start();
		}
		
	}

}
