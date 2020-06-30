package com.flolabs.notification.controller;

import org.springframework.http.HttpStatus;

import com.flolabs.notification.api.MessageApi;
import com.flolabs.notification.api.request.MessageRequest;

public class MessageController implements MessageApi{

	@Override
	public HttpStatus getUserNotification(MessageRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
