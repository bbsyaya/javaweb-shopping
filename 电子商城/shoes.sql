/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : shoes

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-08-06 12:16:43
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `categoryName` varchar(30) default NULL,
  `description` varchar(30) default NULL,
  `sort` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('7', '116', '116', '4');
INSERT INTO `category` VALUES ('8', '116', '116', '5');
INSERT INTO `category` VALUES ('9', '117', '117', '6');
INSERT INTO `category` VALUES ('10', '222', '222', '7');
INSERT INTO `category` VALUES ('11', '223', '223', '8');
INSERT INTO `category` VALUES ('12', '224', '224', '9');
INSERT INTO `category` VALUES ('13', '225', '225', '10');
INSERT INTO `category` VALUES ('14', '226', '226', '11');

-- ----------------------------
-- Table structure for `commodity`
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL auto_increment,
  `commodityName` varchar(30) default NULL,
  `categoryId` int(11) default NULL,
  `description` varchar(30) default NULL,
  `createDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `photo` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `userName` varchar(30) NOT NULL default '',
  `password` varchar(30) default NULL,
  `email` varchar(30) default NULL,
  `phone` varchar(30) default NULL,
  `createDate` timestamp NULL default NULL on update CURRENT_TIMESTAMP,
  `isadmin` int(11) default '0',
  PRIMARY KEY  (`id`,`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', 'admin', 'admin', null, null, null, '1');
INSERT INTO `user` VALUES ('5', '1513', '1513', '13@qq.com', '13', null, '0');
INSERT INTO `user` VALUES ('6', '1111', '1111', null, null, null, '0');
INSERT INTO `user` VALUES ('7', '112', '112', null, null, null, '0');
INSERT INTO `user` VALUES ('8', '113', '113', null, null, null, '0');
INSERT INTO `user` VALUES ('9', '114', '114', null, null, null, '0');
INSERT INTO `user` VALUES ('10', '115', '115', null, null, null, '0');
INSERT INTO `user` VALUES ('11', '116', '116', null, null, null, '0');
INSERT INTO `user` VALUES ('12', '117', '117', null, null, null, '0');
INSERT INTO `user` VALUES ('13', '118', '118', null, null, null, '0');
INSERT INTO `user` VALUES ('14', '119', '119', null, null, null, '0');
INSERT INTO `user` VALUES ('15', '120', '120', null, null, null, '0');
