package com.flolabs.notification.domain;

public class UserNotificationEntity {

	private String sender;
	
	private String time;
	
	private String user_name;
	
	private String event_string;
	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getUserName() {
		return user_name;
	}

	public void setUserName(String userName) {
		this.user_name = userName;
	}

	public String getEventString() {
		return event_string;
	}

	public void setEventString(String eventString) {
		this.event_string = eventString;
	}
	
	
}
