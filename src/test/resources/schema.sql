create schema if not exists jianown;
drop table if exists permission;
drop table if exists role;
drop table if exists role_pernission;
drop table if exists user;
drop table if exists user_role;



CREATE TABLE if not exists jianown.`user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(20) NOT NULL,
  `email` varchar(100) DEFAULT NULL ,
  `password` varchar(250) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `last_login_time` datetime DEFAULT NULL ,
  `status` int(11) DEFAULT '1',
  `des` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nickname` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;