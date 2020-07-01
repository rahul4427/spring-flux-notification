package com.flolabs.notification.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flolabs.notification.entity.UserNotificationEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RequestMapping
public interface MessageApi {

	@ApiOperation(value = "")
	@ApiResponses(value = {
			
	})
	@PostMapping("/send-message")
	HttpStatus getUserNotification(@RequestBody UserNotificationEntity request);
}
