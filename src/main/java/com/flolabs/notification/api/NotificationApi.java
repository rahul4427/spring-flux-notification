package com.flolabs.notification.api;

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
	@GetMapping()
	Flux<UserNotificationEntity> getUserNotification();

}
