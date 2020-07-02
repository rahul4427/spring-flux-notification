package com.flolabs.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import com.flolabs.notification.domain.SSEDomain;
import com.flolabs.notification.domain.UserNotificationEntity;
import com.flolabs.notification.service.NotificationService;
import com.flolabs.notification.utils.ActivePublishers;

import reactor.core.Disposable;
import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxProcessor;
import reactor.core.publisher.FluxSink;

@Service
public class NotificationServiceImpl implements NotificationService{

	@Autowired
	ActivePublishers publisher;
	
	@Override
	public Flux<ServerSentEvent<UserNotificationEntity>> subscribeUser(String user) {
		SSEDomain domain = publisher.getProcessor(user);
		if(domain!=null) {
			return domain.getSubscribableProcessor();
		}
		FluxProcessor<UserNotificationEntity,UserNotificationEntity> processor = EmitterProcessor.create();
		FluxSink<UserNotificationEntity> sink =  processor.sink();
		Flux<ServerSentEvent<UserNotificationEntity>> subscribableProcessor= processor.map(e -> ServerSentEvent.builder(e).build());
		publisher.addProcessor(user, new SSEDomain(subscribableProcessor, sink));
		sink.onCancel(new Disposable() {
			@Override
			public void dispose() {
				publisher.removeSSEDomain(user);	
			}
		});
		return subscribableProcessor;
	}

}
