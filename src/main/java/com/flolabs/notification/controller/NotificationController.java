package com.flolabs.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.RestController;

import com.flolabs.notification.api.NotificationApi;
import com.flolabs.notification.domain.UserNotificationEntity;
import com.flolabs.notification.service.NotificationService;

import reactor.core.publisher.Flux;


@RestController
public class NotificationController implements NotificationApi{

	@Autowired
	NotificationService notificationService;
	
	@Override
	public Flux<ServerSentEvent<UserNotificationEntity>> getUserNotification(String userId) {
		return notificationService.subscribeUser(userId);
	}
}
