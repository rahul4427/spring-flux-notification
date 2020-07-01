package com.flolabs.notification.api;

import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flolabs.notification.entity.UserNotificationEntity;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import reactor.core.publisher.Flux;

@RequestMapping
@RestController
public interface NotificationApi {
	
	@ApiOperation(value = "")
	@ApiResponses(value = {
			
	})
	@GetMapping(path = "/notification/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	Flux<ServerSentEvent<UserNotificationEntity>> getUserNotification();

}
