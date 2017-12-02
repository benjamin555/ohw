-- phpMyAdmin SQL Dump
-- version 2.11.11.3
-- http://www.phpmyadmin.net
--
-- 主机: 127.0.0.1
-- 生成日期: 2017 年 12 月 02 日 21:37
-- 服务器版本: 5.1.73
-- PHP 版本: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

--
-- 数据库: `ofs`
--

-- --------------------------------------------------------

--
-- 表的结构 `qstatement`
--

CREATE TABLE IF NOT EXISTS `qstatement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `is_use` varchar(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `version` datetime DEFAULT NULL,
  `content` longtext,
  `description` varchar(255) DEFAULT NULL,
  `skip_row_str` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 导出表中的数据 `qstatement`
--

INSERT INTO `qstatement` (`id`, `create_time`, `creator`, `is_use`, `update_time`, `updater`, `version`, `content`, `description`, `skip_row_str`) VALUES
(1, '2014-10-30 14:21:47', '3', 'Y', '2014-12-15 22:01:20', NULL, '2014-12-15 22:01:20', 'select  sum(cast(t2.c2 as double) * cast(t1.c25 as double)) as "成本",sum(cast(t3.c2 as double)) as "运费",sum(t1.c9-(cast(t2.c2 as double) * cast(t1.c25 as double))-t3.c2) as "利润" \r\n,(select sum(cast(ta.c9 as double )) as "返现" from t1 ta where ta.c24 like ''%好评返现%''  ) as "返现"\r\nfrom t1 left join t2 on t2.c1=t1.c20 left join t3 on t3.c1 = REPLACE(t1.c22,''No:'','''')\r\nwhere t1.c24 not like ''%好评返现%'' and t1.c11 <> ''交易关闭''', '杰少1', '1,1,1'),
(2, '2017-06-05 17:58:21', '7', 'Y', NULL, NULL, '2017-06-05 17:58:21', 'select  t1.*,t2.c2,t2.c3,t3.c2,t3.c2 as 物料组描述 from t1 join t2 on t2.c1 =t1.c1 join t3 on t2.c3 =t3.c1  order by t1.c1', 'test', '1,1,1');

-- --------------------------------------------------------

--
-- 表的结构 `qstatement_user`
--

CREATE TABLE IF NOT EXISTS `qstatement_user` (
  `q_id` bigint(20) NOT NULL,
  `u_id` bigint(20) NOT NULL,
  KEY `FK9A0FEF4CE5CF42BB` (`q_id`),
  KEY `FK9A0FEF4C3FF62B2D` (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 导出表中的数据 `qstatement_user`
--

INSERT INTO `qstatement_user` (`q_id`, `u_id`) VALUES
(1, 6),
(1, 5);

-- --------------------------------------------------------

--
-- 表的结构 `resource`
--

CREATE TABLE IF NOT EXISTS `resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `is_use` varchar(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `version` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

--
-- 导出表中的数据 `resource`
--

INSERT INTO `resource` (`id`, `create_time`, `creator`, `is_use`, `update_time`, `updater`, `version`, `name`, `url`) VALUES
(1, '2014-11-11 17:14:30', NULL, 'Y', '2014-11-19 14:48:50', NULL, '2014-11-19 14:48:50', '语句-列表', '/qstatement!list.action'),
(2, '2014-11-16 11:42:23', NULL, 'Y', NULL, NULL, '2014-11-16 11:42:23', '安全-管理', '/security/*'),
(3, '2014-11-19 17:59:43', NULL, 'Y', '2014-12-06 14:57:33', NULL, '2014-12-06 14:57:33', '语句-保存', '/qstatement!save.action');

-- --------------------------------------------------------

--
-- 表的结构 `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `is_use` varchar(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `version` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- 导出表中的数据 `role`
--

INSERT INTO `role` (`id`, `create_time`, `creator`, `is_use`, `update_time`, `updater`, `version`, `name`) VALUES
(1, '2014-11-11 17:14:30', NULL, 'Y', '2014-11-16 11:42:24', NULL, '2014-11-16 11:42:24', '系统管理员'),
(2, '2014-11-16 14:48:21', NULL, 'Y', NULL, NULL, '2014-11-16 14:48:21', '普通用户');

-- --------------------------------------------------------

--
-- 表的结构 `role_resource`
--

CREATE TABLE IF NOT EXISTS `role_resource` (
  `resource_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FKAEE599B791CFB437` (`role_id`),
  KEY `FKAEE599B726A686B7` (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 导出表中的数据 `role_resource`
--

INSERT INTO `role_resource` (`resource_id`, `role_id`) VALUES
(2, 1),
(1, 1),
(1, 2),
(3, 1),
(3, 2);

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_time` datetime NOT NULL,
  `creator` varchar(255) DEFAULT NULL,
  `is_use` varchar(1) NOT NULL,
  `update_time` datetime DEFAULT NULL,
  `updater` varchar(255) DEFAULT NULL,
  `version` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- 导出表中的数据 `user`
--

INSERT INTO `user` (`id`, `create_time`, `creator`, `is_use`, `update_time`, `updater`, `version`, `password`, `user_name`) VALUES
(3, '2014-11-03 16:23:47', NULL, 'Y', '2014-11-16 14:00:11', NULL, '2014-11-16 14:00:11', '862c65dcfe3b4aec4a1a9cbfce564555', 'haha'),
(5, '2014-11-17 11:10:12', NULL, 'Y', '2014-11-18 14:25:39', NULL, '2014-11-18 14:25:39', 'f37a9fedea4408b316097a2017ab4c64', 'user1'),
(6, '2014-11-20 15:05:29', NULL, 'Y', NULL, NULL, '2014-11-20 15:05:29', '2842fd1f8cfe0b4f5248435de99d9f23', 'jason'),
(7, '2017-06-05 17:57:45', '', 'Y', NULL, NULL, '2017-06-05 17:57:45', '187423aff4660cd6bc9097b1f664f6fd', 'admin');

-- --------------------------------------------------------

--
-- 表的结构 `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  KEY `FK143BF46A91CFB437` (`role_id`),
  KEY `FK143BF46A36FA7817` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 导出表中的数据 `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(3, 1),
(5, 2),
(6, 2),
(7, 2);

--
-- 限制导出的表
--

--
-- 限制表 `qstatement_user`
--
ALTER TABLE `qstatement_user`
  ADD CONSTRAINT `FK9A0FEF4C3FF62B2D` FOREIGN KEY (`u_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK9A0FEF4CE5CF42BB` FOREIGN KEY (`q_id`) REFERENCES `qstatement` (`id`);

--
-- 限制表 `role_resource`
--
ALTER TABLE `role_resource`
  ADD CONSTRAINT `FKAEE599B726A686B7` FOREIGN KEY (`resource_id`) REFERENCES `resource` (`id`),
  ADD CONSTRAINT `FKAEE599B791CFB437` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);

--
-- 限制表 `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK143BF46A36FA7817` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK143BF46A91CFB437` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
