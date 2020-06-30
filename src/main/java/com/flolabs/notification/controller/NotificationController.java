package com.flolabs.notification.controller;

import com.flolabs.notification.api.NotificationApi;
import com.flolabs.notification.entity.UserNotificationEntity;

import reactor.core.publisher.Flux;

public class NotificationController implements NotificationApi{

	
	
	@Override
	public Flux<UserNotificationEntity> getUserNotification() {
		// TODO Auto-generated method stub
		return null;
	}

}
