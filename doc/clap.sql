-- MySQL dump 10.13  Distrib 5.7.18, for osx10.12 (x86_64)
--
-- Host: localhost    Database: clap
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persons` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_datetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `zone` blob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES (1,'2019-04-08 08:11:41','gubaoer@hotmail.com','8613000001111','male','gubaoer','HongKou District');
INSERT INTO `persons` VALUES (2,'2019-04-08 08:11:41','boyle.gu@hotmail.com','8613000001112','male','baoer.gu','JingAn District');
INSERT INTO `persons` VALUES (3,'2019-04-08 08:11:41','yoyo.wu@gmail.com','8613000001113','female','yoyo.wu','JingAn District');
INSERT INTO `persons` VALUES (4,'2019-04-08 08:11:41','stacy.gao@126.com','8613000001114','female','stacy.gao','MinHang District');
INSERT INTO `persons` VALUES (5,'2019-04-08 08:11:41','yomiko.zhu@qq.com','8613000001115','female','yomiko.zhu','PuDong District');
INSERT INTO `persons` VALUES (6,'2019-04-08 08:11:41','hong.zhu@163.com','8613000001116','male','hong.zhu','YangPu District');
INSERT INTO `persons` VALUES (7,'2019-04-08 08:11:41','leon.lai@qq.com','8613000001117','male','leon.lai','JinShan District');
INSERT INTO `persons` VALUES (8,'2019-04-08 08:11:41','mark.lei@sohu.com','8613000001118','male','mark.lei','HuangPu District');
INSERT INTO `persons` VALUES (9,'2019-04-08 08:11:41','wen.liu@360.com','8613000001119','male','wen.liu','ChongMing District');
INSERT INTO `persons` VALUES (10,'2019-04-08 08:11:41','tom.gao@hotmail.com','8613000001124','female','tom.gao','HuangPu District');
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `sys_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  `resource_type` int(11) DEFAULT NULL COMMENT '1 menu, 2 function',
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_permission`
--

LOCK TABLES `sys_permission` WRITE;
/*!40000 ALTER TABLE `sys_permission` DISABLE KEYS */;
INSERT INTO `sys_permission` VALUES (1,'\0','用户管理',10,'0','sysuser:view',1,'/userInfo/userList');
INSERT INTO `sys_permission` VALUES (2,'\0','用户添加',1,'0/1','sysuser:add',2,'/userInfo/userAdd');
INSERT INTO `sys_permission` VALUES (3,'\0','用户删除',1,'0/1','sysuser:del',2,'/userInfo/userDel');
INSERT INTO `sys_permission` VALUES (4,NULL,'角色管理',10,'0','role:list',1,'/role/list');
INSERT INTO `sys_permission` VALUES (5,NULL,'角色添加',4,'0/4','role:add',2,'/role/add');
INSERT INTO `sys_permission` VALUES (6,NULL,'角色删除',4,'0/4','role:delete',2,'/role/delete');
INSERT INTO `sys_permission` VALUES (7,NULL,'权限管理',10,'0','perm:list',1,'/perm/list');
INSERT INTO `sys_permission` VALUES (8,NULL,'权限添加',7,'0/7','perm:add',2,'perm/add');
INSERT INTO `sys_permission` VALUES (9,NULL,'用户查看',1,'0/1','user:list',2,'/user/list');
INSERT INTO `sys_permission` VALUES (10,NULL,'系统管理',0,'0','systerm:systerm',0,'/systerm/systerm');
/*!40000 ALTER TABLE `sys_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role`
--

DROP TABLE IF EXISTS `sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role`
--

LOCK TABLES `sys_role` WRITE;
/*!40000 ALTER TABLE `sys_role` DISABLE KEYS */;
INSERT INTO `sys_role` VALUES (1,'\0','管理员','admin');
INSERT INTO `sys_role` VALUES (2,'\0','VIP会员','vip');
INSERT INTO `sys_role` VALUES (3,'','测试用户','test');
INSERT INTO `sys_role` VALUES (4,'\0','审核员','audit');
INSERT INTO `sys_role` VALUES (5,'','区域管理员','区域管理员');
/*!40000 ALTER TABLE `sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_role_permission`
--

DROP TABLE IF EXISTS `sys_role_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  KEY `FKomxrs8a388bknvhjokh440waq` (`permission_id`),
  KEY `FK9q28ewrhntqeipl1t04kh1be7` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_role_permission`
--

LOCK TABLES `sys_role_permission` WRITE;
/*!40000 ALTER TABLE `sys_role_permission` DISABLE KEYS */;
INSERT INTO `sys_role_permission` VALUES (4,1);
INSERT INTO `sys_role_permission` VALUES (4,2);
INSERT INTO `sys_role_permission` VALUES (4,3);
INSERT INTO `sys_role_permission` VALUES (4,7);
INSERT INTO `sys_role_permission` VALUES (4,8);
INSERT INTO `sys_role_permission` VALUES (2,1);
INSERT INTO `sys_role_permission` VALUES (2,2);
INSERT INTO `sys_role_permission` VALUES (2,3);
INSERT INTO `sys_role_permission` VALUES (2,9);
INSERT INTO `sys_role_permission` VALUES (2,5);
INSERT INTO `sys_role_permission` VALUES (2,7);
INSERT INTO `sys_role_permission` VALUES (2,8);
INSERT INTO `sys_role_permission` VALUES (2,4);
INSERT INTO `sys_role_permission` VALUES (3,1);
INSERT INTO `sys_role_permission` VALUES (3,2);
INSERT INTO `sys_role_permission` VALUES (3,3);
INSERT INTO `sys_role_permission` VALUES (3,9);
INSERT INTO `sys_role_permission` VALUES (3,6);
INSERT INTO `sys_role_permission` VALUES (3,4);
INSERT INTO `sys_role_permission` VALUES (1,2);
INSERT INTO `sys_role_permission` VALUES (1,9);
INSERT INTO `sys_role_permission` VALUES (1,4);
INSERT INTO `sys_role_permission` VALUES (1,5);
INSERT INTO `sys_role_permission` VALUES (1,6);
INSERT INTO `sys_role_permission` VALUES (1,7);
INSERT INTO `sys_role_permission` VALUES (1,8);
INSERT INTO `sys_role_permission` VALUES (1,10);
INSERT INTO `sys_role_permission` VALUES (1,1);
/*!40000 ALTER TABLE `sys_role_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_user_role`
--

DROP TABLE IF EXISTS `sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sys_user_role` (
  `uid` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FKhh52n8vd4ny9ff4x9fb8v65qx` (`role_id`),
  KEY `FKgkmyslkrfeyn9ukmolvek8b8f` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_user_role`
--

LOCK TABLES `sys_user_role` WRITE;
/*!40000 ALTER TABLE `sys_user_role` DISABLE KEYS */;
INSERT INTO `sys_user_role` VALUES (3,3);
INSERT INTO `sys_user_role` VALUES (4,2);
INSERT INTO `sys_user_role` VALUES (5,4);
INSERT INTO `sys_user_role` VALUES (6,3);
INSERT INTO `sys_user_role` VALUES (7,1);
INSERT INTO `sys_user_role` VALUES (8,2);
INSERT INTO `sys_user_role` VALUES (9,3);
INSERT INTO `sys_user_role` VALUES (10,3);
INSERT INTO `sys_user_role` VALUES (11,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,1);
INSERT INTO `sys_user_role` VALUES (1,2);
INSERT INTO `sys_user_role` VALUES (1,2);
INSERT INTO `sys_user_role` VALUES (1,2);
INSERT INTO `sys_user_role` VALUES (1,2);
/*!40000 ALTER TABLE `sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_info` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(255) DEFAULT NULL,
  `state` tinyint(4) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `UK_f2ksd6h8hsjtd57ipfq9myr64` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (1,'管理员','1015ed3b5f1345911198c995f9ad097e','87e03afa1f0122531f729c9a7453f475',0,'admin');
INSERT INTO `user_info` VALUES (5,'一凡2','d41d8cd98f00b204e9800998ecf8427e','dfe6b93f922ec220e72f7f6de47a01e2',0,'sam2');
INSERT INTO `user_info` VALUES (8,'一凡5','e10adc3949ba59abbe56e057f20f883e','b46be42cbe682f4cc617d05fae9bcf24',0,'sam5');
INSERT INTO `user_info` VALUES (9,'一凡','e10adc3949ba59abbe56e057f20f883e','b46be42cbe682f4cc617d05fae9bcf24',0,'sam');
INSERT INTO `user_info` VALUES (10,'test','d3f1d91fb109c92d3a7e86b7be264769','56579064478bd2af4f4299a6ea01113a',0,'test');
INSERT INTO `user_info` VALUES (11,'测试用户','6ae61eaf548b908e303ac24c9d734416','a3a9423d4d0b7cb434782334dd88da4a',0,'samm');
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-08 17:21:24
