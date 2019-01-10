/*
 Navicat Premium Data Transfer

 Source Server         : localmysql
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : mymysql

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 26/12/2018 15:01:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for announcement_table
-- ----------------------------
DROP TABLE IF EXISTS `announcement_table`;
CREATE TABLE `announcement_table`  (
  `announcement_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `announcement_comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `announcement_delete` int(11) NULL DEFAULT NULL,
  `announcement_persion` bigint(20) NULL DEFAULT NULL,
  `announcement_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `announcement_table` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `announcement_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `announcement_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`announcement_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of announcement_table
-- ----------------------------
INSERT INTO `announcement_table` VALUES (1, NULL, 0, 7, NULL, '测试', '11111', '测试');
INSERT INTO `announcement_table` VALUES (8, NULL, 1, 7, 'announemence_2018-1116 13-06-067', '大撒大撒大苏打水水大苏打大撒大撒大苏打', '2018-1116 13-06-06', '第一条存入的测试信息');
INSERT INTO `announcement_table` VALUES (9, NULL, 1, 7, 'announemence_2018-11-22 13-44-127', 'dajksdjkashdjahsjkdfjkaskvfaksfvajf', '2018-11-22 13-44-12', '这时一条公告');

-- ----------------------------
-- Table structure for comment_table
-- ----------------------------
DROP TABLE IF EXISTS `comment_table`;
CREATE TABLE `comment_table`  (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment_delete` int(11) NULL DEFAULT NULL,
  `comment_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `comment_persion` bigint(20) NULL DEFAULT NULL,
  `comment_table` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `comment_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `comment_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment_table
-- ----------------------------
INSERT INTO `comment_table` VALUES (1, 0, '1', 7, '测试', '111111', NULL);
INSERT INTO `comment_table` VALUES (2, 1, '1', 7, '这是第一条测试的数据', '2018-11-15 07:11:28', NULL);
INSERT INTO `comment_table` VALUES (3, 1, '1', 7, '这是第二条测试数据', '2018-11-15 07:13:06', NULL);
INSERT INTO `comment_table` VALUES (4, 1, '8', 7, '日你妈逼', '2018-11-16 01:27:24', NULL);
INSERT INTO `comment_table` VALUES (5, 1, '1', 7, '这时一个评论', '2018-11-22 01:43:34', NULL);

-- ----------------------------
-- Table structure for community_table
-- ----------------------------
DROP TABLE IF EXISTS `community_table`;
CREATE TABLE `community_table`  (
  `community_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `community_adress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `community_delete` int(11) NULL DEFAULT NULL,
  `community_introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `community_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `community_picture` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`community_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of community_table
-- ----------------------------
INSERT INTO `community_table` VALUES (1, '江南路110号', 1, '非常美丽的吧1111', '江南华府', NULL);
INSERT INTO `community_table` VALUES (2, '长安路22号', 1, '高档小区', '碧桂园', NULL);
INSERT INTO `community_table` VALUES (3, '人民路23号', 1, '非常古老的小区', '西苑', NULL);
INSERT INTO `community_table` VALUES (4, '解放路22号', 1, '非常nice的地方', '东苑', NULL);
INSERT INTO `community_table` VALUES (5, '人民路44号', 1, '有好处的', '人民广场', NULL);
INSERT INTO `community_table` VALUES (6, '太湖路1号', 1, '临近海边的社区', '太湖新城', NULL);
INSERT INTO `community_table` VALUES (7, '新城路11号', 1, '新建的社区', '新城社区', NULL);
INSERT INTO `community_table` VALUES (8, '1', 0, '1', '1', NULL);
INSERT INTO `community_table` VALUES (9, '3', 1, '3', '2', NULL);
INSERT INTO `community_table` VALUES (10, '3', 0, '3', '3', NULL);
INSERT INTO `community_table` VALUES (11, '4', 1, '4', '4', NULL);
INSERT INTO `community_table` VALUES (12, '5', 1, '555', '5', NULL);
INSERT INTO `community_table` VALUES (15, '6', 1, '8', '6', NULL);
INSERT INTO `community_table` VALUES (16, '7', 1, '7', '7', NULL);
INSERT INTO `community_table` VALUES (17, '88', 1, '8', '8', NULL);
INSERT INTO `community_table` VALUES (18, '7', 1, '7', '7', NULL);
INSERT INTO `community_table` VALUES (19, '11', 1, '11', '11', NULL);

-- ----------------------------
-- Table structure for permission_table
-- ----------------------------
DROP TABLE IF EXISTS `permission_table`;
CREATE TABLE `permission_table`  (
  `permission_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `permission_delete` int(11) NULL DEFAULT NULL,
  `permission_level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `permission_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission_table
-- ----------------------------
INSERT INTO `permission_table` VALUES (1, 1, '1', '社区居民');
INSERT INTO `permission_table` VALUES (2, 1, '2', '社区管理员');
INSERT INTO `permission_table` VALUES (3, 1, '3', '最高管理员');

-- ----------------------------
-- Table structure for picture_table
-- ----------------------------
DROP TABLE IF EXISTS `picture_table`;
CREATE TABLE `picture_table`  (
  `picture_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `picture_delete` int(11) NULL DEFAULT NULL,
  `picture_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picture_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `picture_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`picture_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture_table
-- ----------------------------
INSERT INTO `picture_table` VALUES (3, 1, 'resident_7', '20181115140410', '/image/resident/20181115140410_86f5f8744f3c1255bdd75638936c7ccde816.png');
INSERT INTO `picture_table` VALUES (11, 1, 'announemence_2018-1116 13-06-067', '2018-1116 13-06-06', '/image/announcement/2018-1116 13-06-06_noting.jpg');
INSERT INTO `picture_table` VALUES (12, 1, 'resident_8', '20181121140909', '/image/resident/20181121140909_u17887171641492061235fm27gp0.png');
INSERT INTO `picture_table` VALUES (13, 1, 'announemence_2018-11-22 13-44-127', '2018-11-22 13-44-12', '/image/announcement/2018-11-22 13-44-12_新建web项目.png');
INSERT INTO `picture_table` VALUES (14, 1, 'resident_7', '20181122134520', '/image/resident/20181122134520_新建web项目.png');

-- ----------------------------
-- Table structure for resident_table
-- ----------------------------
DROP TABLE IF EXISTS `resident_table`;
CREATE TABLE `resident_table`  (
  `resident_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resident_account` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_adress` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_age` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_community` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_delete` int(11) NULL DEFAULT NULL,
  `resident_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `resident_permission` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`resident_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resident_table
-- ----------------------------
INSERT INTO `resident_table` VALUES (7, '302771918@qq.com', '7栋217室', '34', 'resident_7', '1', 1, 'cccc', '123', '13776146050', 3);
INSERT INTO `resident_table` VALUES (8, '320771917@qq.com', 'b栋11号', '11', 'resident_8', '1', 1, '张三', '123', '123667326273', 3);
INSERT INTO `resident_table` VALUES (9, '302771916@qq.com', NULL, NULL, NULL, '3', 1, '李四', '123', NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;
