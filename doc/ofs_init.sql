

INSERT INTO `resource` (`id`,`create_time`,`creator`,`is_use`,`update_time`,`updater`,`version`,`name`,`url`) VALUES 
 (1,'2014-11-11 17:14:30',NULL,'Y','2014-11-19 14:48:50',NULL,'2014-11-19 14:48:50','语句-列表','/qstatement!list.action'),
 (2,'2014-11-16 11:42:23',NULL,'Y',NULL,NULL,'2014-11-16 11:42:23','安全-管理','/security/*'),
 (3,'2014-11-19 17:59:43',NULL,'Y',NULL,NULL,'2014-11-19 17:59:43','语句-保存','/qstatement!save.action');


 INSERT INTO `role` (`id`,`create_time`,`creator`,`is_use`,`update_time`,`updater`,`version`,`name`) VALUES 
 (1,'2014-11-11 17:14:30',NULL,'Y','2014-11-16 11:42:24',NULL,'2014-11-16 11:42:24','系统管理员'),
 (2,'2014-11-16 14:48:21',NULL,'Y',NULL,NULL,'2014-11-16 14:48:21','普通用户');


 INSERT INTO `role_resource` (`role_id`,`resource_id`) VALUES 
 (1,2),
 (1,1),
 (2,1),
 (2,3);


 INSERT INTO `user` (`id`,`create_time`,`creator`,`is_use`,`update_time`,`updater`,`version`,`password`,`user_name`) VALUES 
 (3,'2014-11-03 16:23:47',NULL,'Y','2014-11-16 14:00:11',NULL,'2014-11-16 14:00:11','862c65dcfe3b4aec4a1a9cbfce564555','haha'),
 (5,'2014-11-17 11:10:12',NULL,'Y','2014-11-18 14:25:39',NULL,'2014-11-18 14:25:39','f37a9fedea4408b316097a2017ab4c64','user1');


 INSERT INTO `user_role` (`user_id`,`role_id`) VALUES 
 (3,1),
 (5,2);