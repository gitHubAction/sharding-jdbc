/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : demo_ds_1

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2020-08-28 18:22:18
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
) ENGINE=InnoDB AUTO_INCREMENT=506048657506697218 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('506048655875112961', '1', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656068050945', '3', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656089022465', '5', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656118382593', '7', 'INSERT_TEST');
INSERT INTO `t_order` VALUES ('506048656139354113', '9', 'INSERT_TEST');

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
) ENGINE=InnoDB AUTO_INCREMENT=506048657510891521 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of t_order_item
-- ----------------------------
INSERT INTO `t_order_item` VALUES ('506048656047079424', '506048655875112961', '1', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656072245248', '506048656068050945', '3', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656097411072', '506048656089022465', '5', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656122576896', '506048656118382593', '7', 'INSERT_TEST');
INSERT INTO `t_order_item` VALUES ('506048656143548416', '506048656139354113', '9', 'INSERT_TEST');
