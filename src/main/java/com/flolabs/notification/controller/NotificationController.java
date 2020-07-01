package com.flolabs.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;

import com.flolabs.notification.api.NotificationApi;
import com.flolabs.notification.entity.UserNotificationEntity;
import com.flolabs.notification.service.NotificationService;

import reactor.core.publisher.Flux;

public class NotificationController implements NotificationApi{

	@Autowired
	NotificationService notificationService;
	
	@Override
	public Flux<ServerSentEvent<UserNotificationEntity>> getUserNotification() {		
		return notificationService.subscribeUser("aa");
	}

}
