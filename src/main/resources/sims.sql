/*
 Navicat MySQL Data Transfer

 Source Server         : MySQL80
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : sims

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 08/06/2023 01:03:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classe
-- ----------------------------
DROP TABLE IF EXISTS `classe`;
CREATE TABLE `classe`  (
  `class_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班级id',
  `class_subject` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属专业',
  `class_dept_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属院系',
  `class_manager_tch_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '班主任id',
  PRIMARY KEY (`class_id`) USING BTREE,
  INDEX `fk_clas_dept`(`class_dept_id` ASC) USING BTREE,
  INDEX `fk_clas_tch`(`class_manager_tch_id` ASC) USING BTREE,
  CONSTRAINT `fk_clas_dept` FOREIGN KEY (`class_dept_id`) REFERENCES `department` (`dept_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_clas_tch` FOREIGN KEY (`class_manager_tch_id`) REFERENCES `teacher` (`tch_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classe
-- ----------------------------
INSERT INTO `classe` VALUES ('C001', '计算机科学与技术（嵌入式培养）', 'D001', 'T001');
INSERT INTO `classe` VALUES ('C002', '软件工程', 'D001', 'T002');
INSERT INTO `classe` VALUES ('C003', '网络工程', 'D001', 'T002');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cse_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程id',
  `cse_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名称',
  `cse_credit` smallint NOT NULL COMMENT '学分',
  `cse_period` smallint NOT NULL COMMENT '学时',
  `cse_semster` smallint NOT NULL COMMENT '进修学期',
  PRIMARY KEY (`cse_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('CSE001', 'C语言程序设计', 4, 4, 1);
INSERT INTO `course` VALUES ('CSE002', '数据结构', 4, 4, 2);

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dept_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '院系id',
  `dept_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '院系名称',
  `dept_addr` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '院系地址',
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of department
-- ----------------------------
INSERT INTO `department` VALUES ('D001', '计算机系', '东南校区-九章楼');
INSERT INTO `department` VALUES ('D003', '哲学系', '东湖校区');

-- ----------------------------
-- Table structure for lesson
-- ----------------------------
DROP TABLE IF EXISTS `lesson`;
CREATE TABLE `lesson`  (
  `les_stu_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生id',
  `les_cse_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程id',
  `les_tch_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '讲师id',
  `les_grade` smallint NULL DEFAULT NULL COMMENT '课程成绩',
  PRIMARY KEY (`les_stu_id`, `les_cse_id`, `les_tch_id`) USING BTREE,
  INDEX `fk_les_cse`(`les_cse_id` ASC) USING BTREE,
  INDEX `fk_les_tch`(`les_tch_id` ASC) USING BTREE,
  CONSTRAINT `fk_les_cse` FOREIGN KEY (`les_cse_id`) REFERENCES `course` (`cse_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_les_stu` FOREIGN KEY (`les_stu_id`) REFERENCES `student` (`stu_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_les_tch` FOREIGN KEY (`les_tch_id`) REFERENCES `teacher` (`tch_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of lesson
-- ----------------------------
INSERT INTO `lesson` VALUES ('S001', 'CSE001', 'T001', 99);
INSERT INTO `lesson` VALUES ('S001', 'CSE002', 'T001', 98);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `stu_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生id',
  `stu_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学生姓名',
  `stu_sex` varchar(4) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `stu_age` smallint NOT NULL COMMENT '年龄',
  `stu_class_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属班级',
  PRIMARY KEY (`stu_id`) USING BTREE,
  INDEX `fk_stu_clas`(`stu_class_id` ASC) USING BTREE,
  CONSTRAINT `fk_stu_clas` FOREIGN KEY (`stu_class_id`) REFERENCES `classe` (`class_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('S001', 'lyj', '男', 20, 'C001');
INSERT INTO `student` VALUES ('S002', 'lihua', '女', 19, 'C001');
INSERT INTO `student` VALUES ('S003', '张飞', '男', 38, 'C001');
INSERT INTO `student` VALUES ('S1001', 'jso', '男', 20, 'C002');
INSERT INTO `student` VALUES ('S1002', 'safd', '女', 21, 'C002');
INSERT INTO `student` VALUES ('S2001', 'xkkk', '女', 19, 'C003');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tch_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师id',
  `tch_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师姓名',
  `tch_tittle` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教师职称',
  `tch_dept_id` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '所属院系',
  PRIMARY KEY (`tch_id`) USING BTREE,
  INDEX `fk_tch_dept`(`tch_dept_id` ASC) USING BTREE,
  CONSTRAINT `fk_tch_dept` FOREIGN KEY (`tch_dept_id`) REFERENCES `department` (`dept_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('T001', 'fll', '讲师', 'D001');
INSERT INTO `teacher` VALUES ('T002', 'lyq', '讲师', 'D001');
INSERT INTO `teacher` VALUES ('T003', 'zb', '讲师', 'D001');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户id',
  `user_password` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '账户密码',
  `superManager` tinyint NOT NULL COMMENT '是否为超级管理员',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('GG Bond', '123', 0);
INSERT INTO `user` VALUES ('root', '0000', 1);
INSERT INTO `user` VALUES ('U001', '12345', 0);
INSERT INTO `user` VALUES ('U002', 'asdf', 0);
INSERT INTO `user` VALUES ('yanisin', '0000', 1);

SET FOREIGN_KEY_CHECKS = 1;
