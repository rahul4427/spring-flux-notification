package com.flolabs.notification.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flolabs.notification.domain.UserNotificationEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RequestMapping
public interface MessageApi {

	@ApiOperation(value = "Registers a message for a user and make request to send notification", nickname = "sendNotification", response = HttpStatus.class, tags = {"Notify"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Receive msg for a user and send notification"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@PostMapping("/send-message")
	HttpStatus getUserNotification(@RequestBody UserNotificationEntity request);
}
