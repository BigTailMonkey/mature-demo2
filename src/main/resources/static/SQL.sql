-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮箱',
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'Jone', '18', 'test1@baomidou.com', '2019-05-01 19:29:35');
INSERT INTO `user` VALUES ('2', 'Jack', '20', 'test2@baomidou.com', '2019-05-01 19:29:35');
INSERT INTO `user` VALUES ('3', 'Tom', '28', 'test3@baomidou.com', '2019-05-03 19:29:42');
INSERT INTO `user` VALUES ('4', 'Sandy', '21', 'test4@baomidou.com', '2019-05-12 19:29:46');
INSERT INTO `user` VALUES ('5', 'Billie', '24', 'test5@baomidou.com', '2019-05-15 19:29:51');
INSERT INTO `user` VALUES ('6', 'btm', '19', 'test6@baomidou.com', '2019-05-24 19:29:57');
INSERT INTO `user` VALUES ('7', 'btm', '19', 'test7@baomidou.com', '2019-05-31 19:30:03');
INSERT INTO `user` VALUES ('8', 'btm', '18', 'test8@baomidow.com', '2019-06-07 19:30:09');