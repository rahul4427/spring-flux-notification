CREATE DATABASE testdb;

DROP TABLE IF EXISTS user_notification;
  
CREATE TABLE user_notification (
  msg_id long AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  event_string VARCHAR(250) NOT NULL
);