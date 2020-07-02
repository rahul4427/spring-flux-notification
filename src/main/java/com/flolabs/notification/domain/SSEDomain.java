package com.flolabs.notification.domain;

import org.springframework.http.codec.ServerSentEvent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class SSEDomain {
	private Flux<ServerSentEvent<UserNotificationEntity>> subscribableProcessor;
	private FluxSink<UserNotificationEntity> sink;

	public SSEDomain(Flux<ServerSentEvent<UserNotificationEntity>> subscribableProcessor,
			FluxSink<UserNotificationEntity> sink) {
		super();
		this.subscribableProcessor = subscribableProcessor;
		this.sink = sink;
	}

	public Flux<ServerSentEvent<UserNotificationEntity>> getSubscribableProcessor() {
		return subscribableProcessor;
	}

	public void setSubscribableProcessor(Flux<ServerSentEvent<UserNotificationEntity>> subscribableProcessor) {
		this.subscribableProcessor = subscribableProcessor;
	}

	public FluxSink<UserNotificationEntity> getSink() {
		return sink;
	}

	public void setSink(FluxSink<UserNotificationEntity> sink) {
		this.sink = sink;
	}
}
