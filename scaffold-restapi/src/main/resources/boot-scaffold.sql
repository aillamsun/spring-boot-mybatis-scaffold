/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : boot-scaffold

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 08/21/2017 18:40:15 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `authorty`
-- ----------------------------
DROP TABLE IF EXISTS `authorty`;
CREATE TABLE `authorty` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `authorty`
-- ----------------------------
BEGIN;
INSERT INTO `authorty` VALUES ('1', 'ROLE_USER'), ('2', 'ROLE_ADMIN');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(11) DEFAULT NULL,
  `last_password_reset_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', 'admin', '$2a$08$lDnHPz7eUkSi6ao14Twuau08mzhWrL4kyZGGU5xfiGALO/Vxd5DOi', null, '', '1', '2017-08-21 16:44:12'), ('8', 'user', '$2a$10$HjoWoNdG23N1XjHh720idePurSbrUA.pAcDfGGyDbI5KgsGgvuvPi', null, '', '1', '2017-08-21 17:26:34'), ('9', 'disabled', '$2a$10$ZgTe2Owsh9NPWJOnADJkeOPWT7dyX/7M64QhW6zqXdSNEGtv3W/Rm', null, '', '0', '2017-08-21 17:29:31');
COMMIT;

-- ----------------------------
--  Table structure for `user_authority`
-- ----------------------------
DROP TABLE IF EXISTS `user_authority`;
CREATE TABLE `user_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL,
  `authority_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_authority`
-- ----------------------------
BEGIN;
INSERT INTO `user_authority` VALUES ('1', '1', '1'), ('2', '1', '2'), ('13', '8', '1'), ('14', '9', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
