package com.flolabs.notification.service;

import org.springframework.http.codec.ServerSentEvent;

import com.flolabs.notification.entity.UserNotificationEntity;

import reactor.core.publisher.Flux;

public interface NotificationService {

	Flux<ServerSentEvent<UserNotificationEntity>> subscribeUser(String user);
	
}
