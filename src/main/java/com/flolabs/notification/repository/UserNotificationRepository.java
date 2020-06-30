package com.flolabs.notification.repository;

import org.springframework.data.repository.CrudRepository;

import com.flolabs.notification.entity.UserNotificationEntity;

public interface UserNotificationRepository extends CrudRepository<UserNotificationEntity, String>{

}