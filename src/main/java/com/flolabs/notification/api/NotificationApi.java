package com.flolabs.notification.api;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flolabs.notification.domain.UserNotificationEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;

@RequestMapping
public interface NotificationApi {
	
	@ApiOperation(value = "Returns a stream for the user to connect and get further notifications", nickname = "getUserNotification", response = Flux.class, tags = {"Notification"})
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "User subscribed to receive notification successfully"),
			@ApiResponse(code = 400, message = "Bad Request detected"),
			@ApiResponse(code = 500, message = "Something bad occured, please contact administrator")
	})
	@GetMapping(path = "/notification/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<ServerSentEvent<UserNotificationEntity>> getUserNotification(@RequestParam("user") String userId);

}
