package com.flolabs.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;

import com.flolabs.notification.entity.UserNotificationEntity;
import com.flolabs.notification.service.NotificationService;
import com.flolabs.notification.utils.ActivePublishers;

import reactor.core.publisher.DirectProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

public class NotificationServiceImpl implements NotificationService{

	@Autowired
	ActivePublishers sinks;
	
	@Override
	public Flux<ServerSentEvent<UserNotificationEntity>> subscribeUser(String user) {
		FluxProcessor processor = DirectProcessor.create().serialize();
		FluxSink<UserNotificationEntity> sink =  processor.sink();
		sinks.addProcessor(user, sink);
		return processor.map(e -> ServerSentEvent.builder(e).build());
	}

}
