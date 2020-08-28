/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : demo_ds_0

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-08-28 18:22:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=506048657515085826 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('506048656055468033', '2', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656076439553', '4', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656109993985', '6', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656130965505', '8', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656151937025', '10', 'INSERT_TEST');

-- ----------------------------
-- Table structure for t_order_item
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_item_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=506048657519280129 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES ('506048656063856640', '506048656055468033', '2', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656084828160', '506048656076439553', '4', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656114188288', '506048656109993985', '6', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656135159808', '506048656130965505', '8', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656156131328', '506048656151937025', '10', 'INSERT_TEST');
