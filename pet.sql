/*
 Navicat Premium Data Transfer

 Source Server         : mysql8.0
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : localhost:3306
 Source Schema         : pet

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 07/12/2021 22:12:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES (1, '大型犬类');
INSERT INTO `category` VALUES (2, '小型犬类');
INSERT INTO `category` VALUES (3, '宠物猫');
INSERT INTO `category` VALUES (4, '宠物用品');
INSERT INTO `category` VALUES (5, '同城寄养');
INSERT INTO `category` VALUES (6, '领养宠物');

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家地址',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家联系方式',
  `status` int(0) NULL DEFAULT 0 COMMENT '状态，0：普通用户，1：会员',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES (1, '1', '12345', '5A124', '123456', 1);
INSERT INTO `customer` VALUES (12, '11', '11', '大连市沙河口区', '', 0);
INSERT INTO `customer` VALUES (13, 'admin', '111', '市区里', '13666668889', 0);
INSERT INTO `customer` VALUES (14, '1', '1', '1', '13624266705', 0);

-- ----------------------------
-- Table structure for order_
-- ----------------------------
DROP TABLE IF EXISTS `order_`;
CREATE TABLE `order_`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单编号',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '买家地址',
  `status` int(0) NULL DEFAULT 0 COMMENT '支付状态，0：未支付，1：正在发货，2：已发货，3：已收货',
  `cstid` int(0) NULL DEFAULT NULL COMMENT '买家id',
  `bid` int(0) NULL DEFAULT NULL COMMENT '商家id',
  `img` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '处方照片',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cstid`(`cstid`) USING BTREE,
  CONSTRAINT `order__ibfk_1` FOREIGN KEY (`cstid`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order_
-- ----------------------------
INSERT INTO `order_` VALUES (43, '202112072145177399205', '姓名：狗狗,邮箱：13624266705@163.com,配送地址：1@1.com,手机号：13624266705', 4, 14, 36, NULL);
INSERT INTO `order_` VALUES (44, '202112072145177399205', '姓名：狗狗,邮箱：13624266705@163.com,配送地址：1@1.com,手机号：13624266705', 4, 14, 37, NULL);

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `pid` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `oid` int(0) NULL DEFAULT NULL COMMENT '订单id',
  `cstid` int(0) NULL DEFAULT NULL COMMENT '买家id',
  `number` int(0) NULL DEFAULT NULL COMMENT '数量',
  `bid` int(0) NULL DEFAULT NULL COMMENT '商家ID',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `oid`(`oid`) USING BTREE,
  INDEX `cstid`(`cstid`) USING BTREE,
  CONSTRAINT `orderitem_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `orderitem_ibfk_2` FOREIGN KEY (`oid`) REFERENCES `order_` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `orderitem_ibfk_3` FOREIGN KEY (`cstid`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 93 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES (100, 49, 43, 14, 1, 36);
INSERT INTO `orderitem` VALUES (101, 50, 44, 14, 1, 37);
INSERT INTO `orderitem` VALUES (104, 51, NULL, 14, 1, 37);

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 54 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (1, '删除分类', '删除分类', '/category/delCategory');
INSERT INTO `permission` VALUES (2, '分类列表', '查看分类列表', '/category/list');
INSERT INTO `permission` VALUES (15, '修改分类页面', '修改分类页面', '/category/editCategory');
INSERT INTO `permission` VALUES (17, '添加商品分类', '添加商品分类', '/category/addCategory');
INSERT INTO `permission` VALUES (18, '查看管理员列表', '查看管理员列表', '/config/listUser');
INSERT INTO `permission` VALUES (20, '查看角色列表', '可增删改查', '/config/listRole');
INSERT INTO `permission` VALUES (21, '查看权限列表', '无', '/config/listPermission');
INSERT INTO `permission` VALUES (23, '修改管理员信息界面', '修改界面', '/config/editUser');
INSERT INTO `permission` VALUES (24, '更新管理员信息', '无', '/config/updateUser');
INSERT INTO `permission` VALUES (25, '管理员删除', '删除', '/config/deleteUser');
INSERT INTO `permission` VALUES (26, '添加管理员界面', '无', '/config/adminAdd');
INSERT INTO `permission` VALUES (27, '添加管理员', '无', '/config/addUser');
INSERT INTO `permission` VALUES (28, '商品列表', '查看商品列表', '/product/list');
INSERT INTO `permission` VALUES (29, '添加商品', '添加上线商品', '/product/addProduct');
INSERT INTO `permission` VALUES (30, '删除商品', '暂无', '/product/deleteProduct');
INSERT INTO `permission` VALUES (31, '修改商品界面', '暂无', '/product/editProduct');
INSERT INTO `permission` VALUES (32, '更新商品', '暂无', '/product/updateProduct');
INSERT INTO `permission` VALUES (33, '添加商品界面', '暂无', '/product/productAddUI');
INSERT INTO `permission` VALUES (34, '商品上线', '暂无', '/product/enableStatus');
INSERT INTO `permission` VALUES (35, '商品下线', '暂无', '/product/stopStatus');
INSERT INTO `permission` VALUES (36, '订单发货', '暂无', '/order/orderDelivery');
INSERT INTO `permission` VALUES (37, '查看订单项', '暂无', '/order/seeOrderItem');
INSERT INTO `permission` VALUES (38, '评论列表', '暂无', '/review/list');
INSERT INTO `permission` VALUES (39, '删除评论', '暂无', '/review/del');
INSERT INTO `permission` VALUES (40, '查看订单列表', '暂无', '/order/list');
INSERT INTO `permission` VALUES (41, '添加权限UI', '暂无', '/config/adminPerAddUI');
INSERT INTO `permission` VALUES (42, '添加权限', '暂无', '/config/addPermission');
INSERT INTO `permission` VALUES (43, '删除权限', '暂无', '/config/deletePermission');
INSERT INTO `permission` VALUES (44, '修改权限ui', '暂无', '/config/editPermission');
INSERT INTO `permission` VALUES (45, '更新权限', '暂无', '/config/updatePermission');
INSERT INTO `permission` VALUES (46, '查看用户列表', '暂无', '/customer/list');
INSERT INTO `permission` VALUES (47, '删除角色', '暂无', '/config/deleteRole');
INSERT INTO `permission` VALUES (48, '添加管理员UI', '暂无', '/config/adminAdd');
INSERT INTO `permission` VALUES (49, '添加管理员', '暂未', '/config/addUser');
INSERT INTO `permission` VALUES (50, '修改角色UI', '暂无', '/config/editRole');
INSERT INTO `permission` VALUES (51, '修改角色', '暂无', '/config/updateRole');
INSERT INTO `permission` VALUES (52, '添加角色UI', '暂无', '/config/addRoleUI');
INSERT INTO `permission` VALUES (53, '添加角色', '暂无', '/config/addRole');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` float(10, 2) NULL DEFAULT 0.00,
  `zan` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `number` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '1',
  `imageurl` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `miaoshu` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `cid` int(0) NULL DEFAULT NULL COMMENT '分类id',
  `bid` bigint(0) NULL DEFAULT NULL COMMENT '商家id',
  `recipe` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `product_ibfk_1`(`cid`) USING BTREE,
  INDEX `product_ibfk_2`(`bid`) USING BTREE,
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`cid`) REFERENCES `category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`bid`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (49, 'admin', 888.00, '8', '雄', '1', 'images/product/49.jpg', '1', 1, 36, 0);
INSERT INTO `product` VALUES (50, '狗狗2号', 2222.00, '2', '雌', '1', 'images/product/50.jpg', '1', 2, 37, 0);
INSERT INTO `product` VALUES (51, '寄养测试', 0.00, '1', '1', '1', 'images/product/51.jpg', '1', 1, 37, 2);

-- ----------------------------
-- Table structure for review
-- ----------------------------
DROP TABLE IF EXISTS `review`;
CREATE TABLE `review`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '该用户默认给出了好评！！！' COMMENT '评论内容',
  `cstid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `pid` int(0) NULL DEFAULT NULL COMMENT '商品id',
  `createtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `cstid`(`cstid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`cstid`) REFERENCES `customer` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `product` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `desc_` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '超级管理员');
INSERT INTO `role` VALUES (2, '卖家/主人', '商品管理员');
INSERT INTO `role` VALUES (3, '游客', '只能查看，不能增删改');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `rid` bigint(0) NULL DEFAULT NULL,
  `pid` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 399 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (134, 3, 2);
INSERT INTO `role_permission` VALUES (135, 3, 18);
INSERT INTO `role_permission` VALUES (136, 3, 20);
INSERT INTO `role_permission` VALUES (137, 3, 21);
INSERT INTO `role_permission` VALUES (138, 3, 28);
INSERT INTO `role_permission` VALUES (139, 3, 37);
INSERT INTO `role_permission` VALUES (140, 3, 38);
INSERT INTO `role_permission` VALUES (141, 3, 40);
INSERT INTO `role_permission` VALUES (346, 1, 53);
INSERT INTO `role_permission` VALUES (347, 1, 52);
INSERT INTO `role_permission` VALUES (348, 1, 51);
INSERT INTO `role_permission` VALUES (349, 1, 50);
INSERT INTO `role_permission` VALUES (350, 1, 49);
INSERT INTO `role_permission` VALUES (351, 1, 48);
INSERT INTO `role_permission` VALUES (352, 1, 47);
INSERT INTO `role_permission` VALUES (353, 1, 46);
INSERT INTO `role_permission` VALUES (354, 1, 45);
INSERT INTO `role_permission` VALUES (355, 1, 44);
INSERT INTO `role_permission` VALUES (356, 1, 43);
INSERT INTO `role_permission` VALUES (357, 1, 42);
INSERT INTO `role_permission` VALUES (358, 1, 41);
INSERT INTO `role_permission` VALUES (359, 1, 40);
INSERT INTO `role_permission` VALUES (360, 1, 39);
INSERT INTO `role_permission` VALUES (361, 1, 38);
INSERT INTO `role_permission` VALUES (362, 1, 37);
INSERT INTO `role_permission` VALUES (363, 1, 36);
INSERT INTO `role_permission` VALUES (364, 1, 35);
INSERT INTO `role_permission` VALUES (365, 1, 34);
INSERT INTO `role_permission` VALUES (366, 1, 33);
INSERT INTO `role_permission` VALUES (367, 1, 32);
INSERT INTO `role_permission` VALUES (368, 1, 31);
INSERT INTO `role_permission` VALUES (369, 1, 30);
INSERT INTO `role_permission` VALUES (370, 1, 29);
INSERT INTO `role_permission` VALUES (371, 1, 28);
INSERT INTO `role_permission` VALUES (372, 1, 27);
INSERT INTO `role_permission` VALUES (373, 1, 26);
INSERT INTO `role_permission` VALUES (374, 1, 25);
INSERT INTO `role_permission` VALUES (375, 1, 24);
INSERT INTO `role_permission` VALUES (376, 1, 23);
INSERT INTO `role_permission` VALUES (377, 1, 21);
INSERT INTO `role_permission` VALUES (378, 1, 20);
INSERT INTO `role_permission` VALUES (379, 1, 18);
INSERT INTO `role_permission` VALUES (380, 1, 17);
INSERT INTO `role_permission` VALUES (381, 1, 15);
INSERT INTO `role_permission` VALUES (382, 1, 2);
INSERT INTO `role_permission` VALUES (383, 1, 1);
INSERT INTO `role_permission` VALUES (384, 2, 40);
INSERT INTO `role_permission` VALUES (386, 2, 37);
INSERT INTO `role_permission` VALUES (387, 2, 36);
INSERT INTO `role_permission` VALUES (388, 2, 35);
INSERT INTO `role_permission` VALUES (389, 2, 34);
INSERT INTO `role_permission` VALUES (390, 2, 33);
INSERT INTO `role_permission` VALUES (391, 2, 32);
INSERT INTO `role_permission` VALUES (392, 2, 31);
INSERT INTO `role_permission` VALUES (393, 2, 30);
INSERT INTO `role_permission` VALUES (394, 2, 29);
INSERT INTO `role_permission` VALUES (395, 2, 28);
INSERT INTO `role_permission` VALUES (396, 2, 17);
INSERT INTO `role_permission` VALUES (397, 2, 15);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员姓名',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL COMMENT '状态，1：启用，0：停用',
  `address` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '暂无' COMMENT '商家管理员地址',
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `lasttime` datetime(0) NULL DEFAULT NULL COMMENT '最后登陆时间',
  `shopid` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家ID',
  `img` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '营业执照',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 34 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (-1, 'admin', '74c5777c983c8be3d4b1f02f5b7f9914', 'nTBxvvDBZuQ+FzZf5qmaZQ==', 1, '暂无', '12445242532', '2021-12-07 21:38:13', '1', 'images/product/d38a35689b134dcbbfdeea5d54bd3c8b.jpg');
INSERT INTO `user` VALUES (36, '狗狗', 'a5553ca2ed2e22920453726c4154ed6f', '9DTQClovqw5ckQoji75IfA==', 1, '1@1.com', '13624266705', '2021-12-07 21:39:41', '21212121', 'images/product/a10572ce87c940b2b98855b497bcd06f.jpg');
INSERT INTO `user` VALUES (37, '猫猫', 'de9fc76f1972f4a7d30f1d89f18281dd', '7/o8fCcA+Ce404VLRfp8Mg==', 1, '1@1.com', '13624266705', '2021-12-07 21:43:22', '21212121', 'images/product/1f5ad6e7c0cb4939a9d2b206f8a964f4.jpg');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT,
  `uid` bigint(0) NULL DEFAULT NULL,
  `rid` bigint(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (88, -1, 1);
INSERT INTO `user_role` VALUES (92, 29, 2);
INSERT INTO `user_role` VALUES (102, 28, 2);
INSERT INTO `user_role` VALUES (103, 15, 2);
INSERT INTO `user_role` VALUES (104, 30, 2);
INSERT INTO `user_role` VALUES (105, 31, 2);
INSERT INTO `user_role` VALUES (106, 32, 2);
INSERT INTO `user_role` VALUES (107, 33, 2);
INSERT INTO `user_role` VALUES (114, 37, 2);
INSERT INTO `user_role` VALUES (115, 36, 2);

-- ----------------------------
-- Table structure for zixun
-- ----------------------------
DROP TABLE IF EXISTS `zixun`;
CREATE TABLE `zixun`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资讯内容',
  `cstid` int(0) NULL DEFAULT NULL COMMENT '客户id',
  `status` int(0) NULL DEFAULT 0 COMMENT '审核状态，1：通过，0：未通过;',
  `fabudate` datetime(0) NULL DEFAULT NULL COMMENT '发布时间;',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
