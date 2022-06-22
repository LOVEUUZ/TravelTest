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

 Date: 22/06/2022 14:53:18
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for userInfo
-- ----------------------------
DROP TABLE IF EXISTS `userInfo`;
CREATE TABLE `userInfo`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `addressFull` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详细地址',
  `order` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单',
  PRIMARY KEY (`ID`, `userName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of userInfo
-- ----------------------------
INSERT INTO `userInfo` VALUES (1, '1', '158794656', '上海市普陀区金沙江路', '上海市普陀区金沙江路 1518 弄', NULL);
INSERT INTO `userInfo` VALUES (2, '3', '23453254235', '456453', '78324', NULL);
INSERT INTO `userInfo` VALUES (4, '4', '54315238434', '啊对对对', '对就完事了', NULL);
INSERT INTO `userInfo` VALUES (5, '55', '9999999', '人都去哪里了？？？', '救救救！！！', NULL);
INSERT INTO `userInfo` VALUES (6, 'uuz', '123456789', '天火！天火！', '占个空意思意思嗷', NULL);

SET FOREIGN_KEY_CHECKS = 1;
