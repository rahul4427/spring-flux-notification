package com.flolabs.notification.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.flolabs.notification.domain.UserNotificationEntity;

import reactor.core.publisher.FluxSink;

@Component
public class ActivePublishers {

	Map<String,List<FluxSink<UserNotificationEntity>>> lookup = new HashMap<String, List<FluxSink<UserNotificationEntity>>>();

	public List<FluxSink<UserNotificationEntity>> getProcessor(String userName) {
		List<FluxSink<UserNotificationEntity>> sinks = lookup.get(userName);
		if(sinks==null) {
			sinks = new ArrayList<FluxSink<UserNotificationEntity>>();
			lookup.put(userName, sinks);
		}
		return sinks;
	}

	public void addProcessor(String userName, FluxSink<UserNotificationEntity> processor) {
		List<FluxSink<UserNotificationEntity>> sinks = lookup.get(userName);
		if(sinks==null) {
			sinks = new ArrayList<FluxSink<UserNotificationEntity>>();
			lookup.put(userName, sinks);
		}
		sinks.add(processor);
	}
	
	public void removeSink(String user,FluxSink<UserNotificationEntity> sink) {
		List<FluxSink<UserNotificationEntity>> sinks = lookup.get(user);
		sinks.remove(sink);
	}
	
}
