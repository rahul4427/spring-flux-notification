package com.flolabs.notification.entity;

//@Table("user_notification")
public class UserNotificationEntity {

//	@Id
	private long msg_id;
	
	private String user_name;
	
	private String event_string;

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
