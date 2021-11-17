/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.31 : Database - laydb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`laydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `laydb`;

/*Table structure for table `dept` */

DROP TABLE IF EXISTS `dept`;

CREATE TABLE `dept` (
  `dept_id` int(10) NOT NULL,
  `dept_name` char(100) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

/*Data for the table `dept` */

insert  into `dept`(`dept_id`,`dept_name`) values (1,'开发部'),(2,'事业部'),(3,'销售部'),(4,'员工部'),(5,'销售2部'),(6,'开发2部');

/*Table structure for table `emp` */

DROP TABLE IF EXISTS `emp`;

CREATE TABLE `emp` (
  `emp_id` int(10) NOT NULL AUTO_INCREMENT,
  `name` char(100) DEFAULT NULL,
  `sex` char(10) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `sal` double(17,0) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `address` char(100) DEFAULT NULL,
  `dept_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

/*Data for the table `emp` */

insert  into `emp`(`emp_id`,`name`,`sex`,`age`,`sal`,`birthday`,`address`,`dept_id`) values (1,'张三','1',20,3500,'2021-11-12','而为人服务无法',1),(2,'李四','1',23,52135,'2021-11-04','要符合黄金分割甲方根据国际',1),(3,'王五','1',23,2515,'2021-11-06','反对回个电话感到翻跟斗',1),(4,'阿达','1',52,2552,'2021-11-05','和态度很好',1),(5,'奥迪','0',25,2515,'1974-12-27','感动感动感动个人',1),(6,'红色','0',52,255125,'2020-02-13','和他的好烦好烦好烦方法',1),(7,'dwa','1',25,3562,'2021-11-02','hdth',6),(8,'vg','1',15,1566,'2021-11-15','ftvvvvvvvuytu',5),(9,'dfd','1',15,18616,'2021-11-11','drwf',3),(10,'dwad','1',65,1561,'2021-11-03','dwadawd',5),(11,'666','1',20,3500,'2021-11-12','而为人服务无法',1);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` char(100) DEFAULT NULL,
  `password` char(100) DEFAULT NULL,
  `ch_name` char(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`ch_name`) values (1,'admin','$2a$10$Rk7OFBuNQgRAdiPKGfIjBOh1VG34jdW5gR.VKIREuEfGieRdQlXDa','管理员'),(2,'lisi','123456','李四'),(3,'zhangsan','$2a$10$EavQe5bh3QxFrmibzUCB9e0fTaar71Xf0nanNTxS8QfanO/PaiDHm','张三'),(4,'wangwu','$2a$10$BDSTMdEfVBTOB8BXAhPBGuewxibNQOU6wnuEMHTewMX89Dd7KXmk.','王五');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
