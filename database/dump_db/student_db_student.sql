-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: student_db
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `firstname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_of_birth` datetime NOT NULL,
  `sex` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `address` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  `phonenumber` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `class_id` int NOT NULL,
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `Gmail_UNIQUE` (`email`),
  KEY `fk_student_class_idx` (`class_id`),
  CONSTRAINT `fk_student_class` FOREIGN KEY (`class_id`) REFERENCES `class` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Cao Ngoc','Cuong','2000-03-01 00:00:00','Male','ngoccuong010320000@gmail.com','Hue','0337152172',1),(25,'Do Hoang','Kien','2021-04-12 00:00:00','Male','kien.dh@gmail.com','Gia Lai','063456461',5),(39,'Nguyễn Trọng','Hảo','2000-02-12 00:00:00','Male','hao.so@gmail.com','Vinh','9123998288',1),(40,'Huấn Hoa','Hồng','1999-12-10 00:00:00','Male','hong@gmail.com','HCM','023123991',1),(41,'Khá','Bảnh','2000-10-10 00:00:00','Male','banh@gmail.com','HCM','012993211',1),(42,'Lê Hồng','Hoa','2000-11-01 00:00:00','Female','honghoa@gmail.com','Long An','012939483',1),(43,'Cao Hải','Uyên','1999-02-10 00:00:00','Female','uyenhoa@gmail.com','Quảng Trị','093918929',1),(44,'Hoàng Tuấn','Anh','2000-10-23 00:00:00','Male','anhtuan@gmail.com','Quảng Bình','012939992',1),(45,'Triệu Quân','Sự','1997-09-10 00:00:00','Male','suquans@gmail.com','Thanh Hóa','914289999',1),(46,'Bình','Gold','1999-09-30 00:00:00','Male','binhgold@gmail.com','HCM','000999999',1),(47,'Sơn','Tùng','1999-12-01 00:00:00','Male','sontung@gmail.com','Thái Bình','888881288',1),(48,'Hoa Huệ','Huỳnh','1998-12-29 00:00:00','Female','Nhaheo@gmail.com','Vinh','299183917',2),(49,'Hoa','Hồng','2000-05-20 00:00:00','Female','Haoohong@gmail.com','Quảng Ngãi','19123877',2),(50,'Bùi Công','An','2001-08-12 00:00:00','Male','namanas@gmail.com','Quảng Trị','009993810',2),(51,'Lương Thị','Lẹo','2001-09-12 00:00:00','Male','leuongleo@gmail.com','Quảng Nam','019298372',3),(59,'Nguyễn Thị Thúy Ngân','Ngân','2001-07-21 00:00:00','Female','nganngan@gmail.com','Bến Che','0877900625',6);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-01 12:44:47
