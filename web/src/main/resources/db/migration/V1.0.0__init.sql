/*
SQLyog Trial v13.1.8 (64 bit)
MySQL - 8.0.27 : Database - gbr_prototype
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gbr_prototype` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `gbr_prototype`;

/*Table structure for table `brand` */

DROP TABLE IF EXISTS `brand`;

CREATE TABLE `brand` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `local_date_time` datetime DEFAULT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `company` */

DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `barcode` bigint DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `register_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `banking_account` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `logo_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `level` double DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `is_active` boolean DEFAULT NULL,
  `is_verified` boolean DEFAULT NULL,
  `is_synchronized` boolean DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `company_type_id` bigint DEFAULT NULL,
  `pres_seller_id` bigint DEFAULT NULL,
  `region_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `company_type_id` (`company_type_id`),
  KEY `pres_seller_id` (`pres_seller_id`),
  KEY `region_id` (`region_id`),
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`company_type_id`) REFERENCES `company_type` (`id`),
  CONSTRAINT `company_ibfk_2` FOREIGN KEY (`pres_seller_id`) REFERENCES `pres_seller` (`id`),
  CONSTRAINT `company_ibfk_3` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `company_type` */

DROP TABLE IF EXISTS `company_type`;

CREATE TABLE `company_type` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `country` */

DROP TABLE IF EXISTS `country`;

CREATE TABLE `country` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `emotion` */

DROP TABLE IF EXISTS `emotion`;

CREATE TABLE `emotion` (
  `listing_id` bigint NOT NULL,
  `lt_id` bigint NOT NULL,
  PRIMARY KEY (`listing_id`,`lt_id`),
  KEY `FKrtd3gdpx2qine1fw47temopdo` (`lt_id`),
  CONSTRAINT `emotion_ibfk_1` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`),
  CONSTRAINT `emotion_ibfk_2` FOREIGN KEY (`lt_id`) REFERENCES `lt` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `listing` */

DROP TABLE IF EXISTS `listing`;

CREATE TABLE `listing` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `listing_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` bigint NOT NULL,
  `product_id` bigint DEFAULT NULL,
  `listing_group_id` bigint NOT NULL,
  `listing_category_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `product_id` (`product_id`),
  KEY `listing_group_id` (`listing_group_id`),
  KEY `listing_category_id` (`listing_category_id`),
  CONSTRAINT `listing_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `listing_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `listing_ibfk_3` FOREIGN KEY (`listing_group_id`) REFERENCES `listing_group` (`id`),
  CONSTRAINT `listing_ibfk_4` FOREIGN KEY (`listing_category_id`) REFERENCES `listing_category` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `listing_category` */

DROP TABLE IF EXISTS `listing_category`;

CREATE TABLE `listing_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `listing_comment` */

DROP TABLE IF EXISTS `listing_comment`;

CREATE TABLE `listing_comment` (
  `listing_id` bigint NOT NULL,
  `comment_id` bigint NOT NULL,
  PRIMARY KEY (`listing_id`,`comment_id`),
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `listing_comment_ibfk_1` FOREIGN KEY (`listing_id`) REFERENCES `listing` (`id`),
  CONSTRAINT `listing_comment_ibfk_2` FOREIGN KEY (`comment_id`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `listing_group` */

DROP TABLE IF EXISTS `listing_group`;

CREATE TABLE `listing_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `lt` */

DROP TABLE IF EXISTS `lt`;

CREATE TABLE `lt` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `reaction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `lt_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `made_in_country` */

DROP TABLE IF EXISTS `made_in_country`;

CREATE TABLE `made_in_country` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `order_basket` */

DROP TABLE IF EXISTS `order_basket`;

CREATE TABLE `order_basket` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `serial_number` bigint NOT NULL,
  `user_id` bigint DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `sale_date_time` datetime DEFAULT NULL,
  `is_verified` boolean NOT NULL,
  `is_synchronized` boolean NOT NULL,
  `order_cost` double NOT NULL,
  `order_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `order_basket_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `order_basket_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `order_payment` */

DROP TABLE IF EXISTS `order_payment`;

CREATE TABLE `order_payment` (
  `order_basket_id` bigint NOT NULL,
  `payment_id` bigint NOT NULL,
  PRIMARY KEY (`order_basket_id`,`payment_id`),
  KEY `payment_id` (`payment_id`),
  CONSTRAINT `order_payment_ibfk_1` FOREIGN KEY (`order_basket_id`) REFERENCES `order_basket` (`id`),
  CONSTRAINT `order_payment_ibfk_2` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `order_product_order` */

DROP TABLE IF EXISTS `order_product_order`;

CREATE TABLE `order_product_order` (
  `order_basket_id` bigint NOT NULL,
  `product_order_id` bigint NOT NULL,
  PRIMARY KEY (`order_basket_id`,`product_order_id`),
  KEY `product_order_id` (`product_order_id`),
  CONSTRAINT `order_product_order_ibfk_1` FOREIGN KEY (`order_basket_id`) REFERENCES `order_basket` (`id`),
  CONSTRAINT `order_product_order_ibfk_2` FOREIGN KEY (`product_order_id`) REFERENCES `product_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `payment` */

DROP TABLE IF EXISTS `payment`;

CREATE TABLE `payment` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `size` double NOT NULL,
  `is_synchronized` boolean DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `payment_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `company_register_number` varchar(255) NOT NULL,
  `serial_number` varchar(255) DEFAULT NULL,
  `from_user_id` bigint NOT NULL,
  `order_basket_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `from_user_id` (`from_user_id`),
  KEY `FK607qop306gpxscgrhb3qg329t` (`order_basket_id`),
  CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`from_user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`order_basket_id`) REFERENCES `order_basket` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `pres_seller` */

DROP TABLE IF EXISTS `pres_seller`;

CREATE TABLE `pres_seller` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `surname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `phone_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rating` double DEFAULT NULL,
  `is_active` boolean DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `barcode` bigint NOT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `price` double NOT NULL,
  `weight` double DEFAULT NULL,
  `cashback` double DEFAULT NULL,
  `is_synchronized` boolean DEFAULT NULL,
  `small_pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `pic_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_date_time` datetime(6) DEFAULT NULL,
  `is_active` boolean DEFAULT NULL,
  `made_in_country_id` bigint NOT NULL,
  `product_category_id` bigint NOT NULL,
  `product_group_id` bigint NOT NULL,
  `brand_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `made_in_country_id` (`made_in_country_id`),
  KEY `product_category_id` (`product_category_id`),
  KEY `product_group_id` (`product_group_id`),
  KEY `brand_id` (`brand_id`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`made_in_country_id`) REFERENCES `made_in_country` (`id`),
  CONSTRAINT `product_ibfk_2` FOREIGN KEY (`product_category_id`) REFERENCES `product_category` (`id`),
  CONSTRAINT `product_ibfk_3` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`id`),
  CONSTRAINT `product_ibfk_4` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `product_category` */

DROP TABLE IF EXISTS `product_category`;

CREATE TABLE `product_category` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `product_group_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_group_id` (`product_group_id`),
  CONSTRAINT `product_category_ibfk_1` FOREIGN KEY (`product_group_id`) REFERENCES `product_group` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `product_group` */

DROP TABLE IF EXISTS `product_group`;

CREATE TABLE `product_group` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `product_order` */

DROP TABLE IF EXISTS `product_order`;

CREATE TABLE `product_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `count` int NOT NULL,
  `product_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `product_order_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `region` */

DROP TABLE IF EXISTS `region`;

CREATE TABLE `region` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `country_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `country_id` (`country_id`),
  CONSTRAINT `region_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `surname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `passport_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `created_date_time` datetime DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `mail_verify_token` binary(255) DEFAULT NULL,
  `is_mail_verified` boolean DEFAULT NULL,
  `is_contract_verified` boolean DEFAULT NULL,
  `is_active` boolean DEFAULT NULL,
  `is_black_list` boolean DEFAULT NULL,
  `is_synchronized` boolean DEFAULT NULL,
  `region_id` bigint DEFAULT NULL,
  `company_id` bigint DEFAULT NULL,
  `role` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `region_id` (`region_id`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`region_id`) REFERENCES `product_group` (`id`),
  CONSTRAINT `user_ibfk_2` FOREIGN KEY (`company_id`) REFERENCES `company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
