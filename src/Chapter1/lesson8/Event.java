package Chapter1.lesson8;

import java.util.Date;

public class Event {
	private Date date;
	private String event;
	
	public Event() {
		super();
	}

	public Event(Date date, String event) {
		super();
		this.date = date;
		this.event = event;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	
}
