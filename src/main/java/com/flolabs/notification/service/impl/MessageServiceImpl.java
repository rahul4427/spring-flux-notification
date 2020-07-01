package com.flolabs.notification.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flolabs.notification.entity.UserNotificationEntity;
import com.flolabs.notification.service.MessageService;
import com.flolabs.notification.utils.ActivePublishers;

import reactor.core.publisher.FluxSink;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	ActivePublishers sinks;
	
	@Override
	public void sendMessage(UserNotificationEntity request) {
		FluxSink<UserNotificationEntity> sink = sinks.getProcessor(request.getUserName());
		sink.next(request);
		
	}

}
