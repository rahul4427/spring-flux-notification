package com.flolabs.notification.service;

import com.flolabs.notification.domain.UserNotificationEntity;

public interface MessageService {
	void sendMessage(UserNotificationEntity request);
}
