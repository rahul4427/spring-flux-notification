package com.flolabs.notification.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.flolabs.notification.api.request.MessageRequest;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

public interface MessageApi {

	@ApiOperation(value = "")
	@ApiResponses(value = {
			
	})
	@PostMapping("")
	HttpStatus getUserNotification(@RequestBody MessageRequest request);
}
