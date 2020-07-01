package com.flolabs.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.flolabs.notification.entity.UserNotificationEntity;
import com.flolabs.notification.service.NotificationService;
import com.flolabs.notification.utils.ActivePublishers;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	ActivePublishers sinks;
	
	@Override
	public Flux<ServerSentEvent<UserNotificationEntity>> subscribeUser(String user) {
		FluxProcessor<UserNotificationEntity,UserNotificationEntity> processor = EmitterProcessor.create();
		FluxSink<UserNotificationEntity> sink =  processor.sink();
		sinks.addProcessor(user, sink);
		return processor.map(e -> ServerSentEvent.builder(e).build());
	}

}
