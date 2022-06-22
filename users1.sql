/*
 Navicat Premium Data Transfer

 Source Server         : 43.138.189.91
 Source Server Type    : MySQL
 Source Server Version : 50738
 Source Host           : 43.138.189.91:3306
 Source Schema         : uuz

 Target Server Type    : MySQL
 Target Server Version : 50738
 File Encoding         : 65001

 Date: 22/06/2022 14:53:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users1
-- ----------------------------
DROP TABLE IF EXISTS `users1`;
CREATE TABLE `users1`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `UserName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `PassWord` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `CreatTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`, `UserName`) USING BTREE,
  UNIQUE INDEX `userName`(`UserName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users1
-- ----------------------------
INSERT INTO `users1` VALUES (1, '1', '123', '2022-05-07 22:57:57');
INSERT INTO `users1` VALUES (3, '3', '3', '2022-05-08 12:25:05');
INSERT INTO `users1` VALUES (4, '4', '4', '2022-05-08 12:25:42');
INSERT INTO `users1` VALUES (5, '55', '550', '2022-05-08 14:21:42');
INSERT INTO `users1` VALUES (6, 'uuz', 'loveuuz', '2022-05-10 10:50:01');

SET FOREIGN_KEY_CHECKS = 1;
