package com.flolabs.notification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.github.classgraph.json.Id;

@Entity
@Table(name = "user_notification")
public class UserNotificationEntity {

	@Id
	@Column(name = "msg_pkey")
	private long msgId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "event_string")
	private String eventString;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEventString() {
		return eventString;
	}

	public void setEventString(String eventString) {
		this.eventString = eventString;
	}
	
	
}
