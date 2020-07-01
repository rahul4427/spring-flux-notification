package com.flolabs.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flolabs.notification.api.MessageApi;
import com.flolabs.notification.entity.UserNotificationEntity;
import com.flolabs.notification.service.MessageService;

@RestController
public class MessageController implements MessageApi{

	@Autowired
	MessageService messageService;
	
	@Override
	public HttpStatus getUserNotification(UserNotificationEntity request) {
		messageService.sendMessage(request);
		return HttpStatus.OK;
	}

}
