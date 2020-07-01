package com.flolabs.notification.service;

import com.flolabs.notification.entity.UserNotificationEntity;

public interface MessageService {
	void sendMessage(UserNotificationEntity request);
}
