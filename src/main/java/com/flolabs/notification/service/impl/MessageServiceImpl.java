package com.flolabs.notification.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flolabs.notification.domain.SSEDomain;
import com.flolabs.notification.domain.UserNotificationEntity;
import com.flolabs.notification.service.MessageService;
import com.flolabs.notification.utils.ActivePublishers;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	ActivePublishers sinks;
	
	@Override
	public void sendMessage(UserNotificationEntity request) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		request.setTime(dtf.format(LocalDateTime.now()));
		
		SSEDomain domain = sinks.getProcessor(request.getUserName());
		if(domain!=null) {
			domain.getSink().next(request);
		}	
	}

}
