package com.flolabs.notification.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.flolabs.notification.entity.UserNotificationEntity;

import reactor.core.publisher.FluxSink;

@Component
public class ActivePublishers {

	Map<String,FluxSink<UserNotificationEntity>> lookup = new HashMap<String, FluxSink<UserNotificationEntity>>();

	public FluxSink<UserNotificationEntity> getProcessor(String userName) {
		return lookup.get(userName);
	}

	public void addProcessor(String userName, FluxSink<UserNotificationEntity> processor) {
		lookup.put(userName, processor);
	}
	
}
