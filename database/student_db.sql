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
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `classname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `year` year DEFAULT NULL,
  `course_id` int NOT NULL,
  `major_id` int NOT NULL,
  `teacher_id` int DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `fk_class_major_idx` (`major_id`),
  KEY `fk_class_teacher_idx` (`teacher_id`),
  KEY `fk_class_exam_result_idx` (`course_id`),
  CONSTRAINT `fk_class_exam_result` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `fk_class_major` FOREIGN KEY (`major_id`) REFERENCES `major` (`major_id`),
  CONSTRAINT `fk_class_teacher` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'DH18CS81',2018,1,1,1),(2,'DH18CS82',2018,1,1,1),(3,'DH18IM81',2018,2,4,2),(4,'DH18IM82',2018,2,4,2),(5,'DH18IT81',2018,3,3,3),(6,'DH18IT82',2018,3,3,3),(7,'DH18KK82',2019,4,5,3),(8,'DH18KK92',2019,5,6,2),(9,'DH19Luat92',2018,7,5,3);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `coursename` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `sign_s_time` datetime NOT NULL,
  `sign_e_time` datetime NOT NULL,
  `exam_s_time` datetime NOT NULL,
  `exam_e_time` datetime NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Lập trình hướng đối tượng','2020-01-01 00:00:00','2020-11-22 00:00:00','2020-05-09 00:00:00','2020-10-13 00:00:00'),(2,'Lập trình Web','2020-02-21 00:00:00','2020-09-22 00:00:00','2020-06-12 00:00:00','2020-06-12 00:00:00'),(3,'Lập trình Python','2020-08-30 00:00:00','2020-12-20 00:00:00','2020-11-20 00:00:00','2020-11-21 00:00:00'),(4,'Kinh Tế Vỉ Mô','2021-01-20 00:00:00','2021-12-10 00:00:00','2020-10-20 00:00:00','2020-11-21 00:00:00'),(5,'Luật Dân Sự','2020-12-10 00:00:00','2021-02-12 00:00:00','2021-02-19 00:00:00','2021-02-19 00:00:00'),(6,'Luật Quốc Phòng','2020-10-11 00:00:00','2020-12-01 00:00:00','2021-01-10 00:00:00','2021-01-11 00:00:00'),(7,'Maketing','2021-01-19 00:00:00','2021-02-28 00:00:00','2021-03-12 00:00:00','2021-03-13 00:00:00');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `exam_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `start_date` date DEFAULT NULL,
  `exam_type_id` int DEFAULT NULL,
  PRIMARY KEY (`exam_id`),
  UNIQUE KEY `exam_id_UNIQUE` (`exam_id`),
  KEY `fk_exam_examtype_idx` (`exam_type_id`),
  CONSTRAINT `fk_exam_exam_type` FOREIGN KEY (`exam_type_id`) REFERENCES `exam_type` (`exam_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'Lập trình hướng đối tượng','2020-09-12',1),(2,'Lập trình hướng đối tượng','2020-10-12',2),(3,'Lập trình web','2020-11-21',1),(4,'Lập trình web','2020-12-20',2),(5,'Lập trình Java','2020-10-01',1),(6,'Lập trình Java','2020-11-10',2),(7,'Toán cao cấp A1','2020-02-10',1),(8,'Toán cao cấp A1','2020-03-11',2),(9,'Toán Rời Rạc','2020-07-10',1),(10,'Toán Rời Rạc','2020-10-10',2),(11,'Kỹ thuật lập trình ','2020-11-11',1),(12,'Kỹ thuật lập trình','2020-12-10',2),(13,'Lập Trình Python','2021-02-12',1),(14,'Lập Trình Python','2021-12-11',2);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result`
--

DROP TABLE IF EXISTS `exam_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_result` (
  `student_id` int NOT NULL,
  `exam_id` int NOT NULL,
  `course_id` int NOT NULL,
  `exam_type_id` int NOT NULL,
  `score` float DEFAULT NULL,
  PRIMARY KEY (`student_id`,`exam_id`,`course_id`,`exam_type_id`),
  KEY `fk_ers_student_idx` (`student_id`),
  KEY `fk_ers_exam_idx` (`exam_id`),
  KEY `fk_ers_course_idx` (`course_id`),
  KEY `fk_ers_exam_type_idx` (`exam_type_id`),
  CONSTRAINT `fk_ers_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`course_id`),
  CONSTRAINT `fk_ers_exam` FOREIGN KEY (`exam_id`) REFERENCES `exam` (`exam_id`),
  CONSTRAINT `fk_ers_exam_type` FOREIGN KEY (`exam_type_id`) REFERENCES `exam_type` (`exam_type_id`),
  CONSTRAINT `fk_ers_student` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_520_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result`
--

LOCK TABLES `exam_result` WRITE;
/*!40000 ALTER TABLE `exam_result` DISABLE KEYS */;
INSERT INTO `exam_result` VALUES (25,1,1,1,2),(25,1,1,2,NULL),(25,3,2,1,NULL),(25,3,2,2,2),(39,1,1,1,9),(39,1,1,2,NULL),(39,3,2,1,NULL),(39,3,2,2,NULL),(40,1,1,1,1.6),(40,1,1,2,1),(40,3,2,1,2),(40,3,2,2,2),(41,1,1,1,9),(41,1,1,2,10),(41,3,2,1,NULL),(41,3,2,2,NULL),(42,1,1,1,2),(42,1,1,2,NULL),(42,3,2,1,NULL),(42,3,2,2,NULL),(43,1,1,1,NULL),(43,1,1,2,NULL),(43,3,2,1,NULL),(43,3,2,2,NULL),(44,1,1,1,NULL),(44,1,1,2,NULL),(44,3,2,1,NULL),(44,3,2,2,0),(45,1,1,1,NULL),(45,1,1,2,NULL),(45,3,2,1,NULL),(45,3,2,2,NULL),(46,1,1,1,10),(46,1,1,2,6),(46,3,2,1,NULL),(46,3,2,2,NULL),(47,1,1,1,NULL),(47,1,1,2,NULL),(47,3,2,1,NULL),(47,3,2,2,NULL),(48,1,1,1,NULL),(48,1,1,2,NULL),(48,3,2,1,NULL),(48,3,2,2,NULL),(49,1,1,1,NULL),(49,1,1,2,NULL),(49,3,2,1,NULL),(49,3,2,2,NULL),(50,1,1,1,NULL),(50,1,1,2,NULL),(50,3,2,1,NULL),(50,3,2,2,NULL);
/*!40000 ALTER TABLE `exam_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_type`
--

DROP TABLE IF EXISTS `exam_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_type` (
  `exam_type_id` int NOT NULL AUTO_INCREMENT,
  `name_exam` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`exam_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_type`
--

LOCK TABLES `exam_type` WRITE;
/*!40000 ALTER TABLE `exam_type` DISABLE KEYS */;
INSERT INTO `exam_type` VALUES (1,'Thi Cuối Kì',''),(2,'Thi Giữa Kì',NULL);
/*!40000 ALTER TABLE `exam_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `major`
--

DROP TABLE IF EXISTS `major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `major` (
  `major_id` int NOT NULL AUTO_INCREMENT,
  `majorname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(200) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`major_id`),
  UNIQUE KEY `major_id_UNIQUE` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `major`
--

LOCK TABLES `major` WRITE;
/*!40000 ALTER TABLE `major` DISABLE KEYS */;
INSERT INTO `major` VALUES (1,'CNTT','Cong nghe thong tin'),(3,'CS','Khoa học máy tính'),(4,'IM','Hệ thống thông tin quản lí'),(5,'KK','Kế toán kiếm toán'),(6,'Luật','Luật'),(7,'QTKD','Quản trị kinh doanh');
/*!40000 ALTER TABLE `major` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Cao Ngọc','Cường','2000-10-01 00:00:00','Female','ngoccuong@gmail.com','Huế','0337152172',1),(25,'Do Hoang','Kien','2021-04-12 00:00:00','Male','kien.dh@gmail.com','Gia Lai','063456461',5),(39,'Nguyễn Trọng','Hảo','2000-02-12 00:00:00','Male','hao.so@gmail.com','Vinh','9123998288',1),(40,'Huấn Hoa','Hồng','1999-12-10 00:00:00','Male','hong@gmail.com','HCM','023123991',1),(41,'Khá','Bảnh','2000-10-10 00:00:00','Male','banh@gmail.com','HCM','012993211',1),(42,'Lê Hồng','Hoa','2000-11-01 00:00:00','Female','honghoa@gmail.com','Long An','012939483',1),(43,'Cao Hải','Uyên','1999-02-10 00:00:00','Female','uyenhoa@gmail.com','Quảng Trị','093918929',1),(44,'Hoàng Tuấn','Anh','2000-10-23 00:00:00','Male','anhtuan@gmail.com','Quảng Bình','012939992',1),(45,'Triệu Quân','Sự','1997-09-10 00:00:00','Male','suquans@gmail.com','Thanh Hóa','914289999',1),(46,'Bình','Gold','1999-09-30 00:00:00','Male','binhgold@gmail.com','HCM','000999999',1),(47,'Sơn','Tùng','1999-12-01 00:00:00','Male','sontung@gmail.com','Thái Bình','888881288',1),(48,'Hoa Huệ','Huỳnh','1998-12-29 00:00:00','Female','Nhaheo@gmail.com','Vinh','299183917',2),(49,'Hoa','Hồng','2000-05-20 00:00:00','Male','Haoohong@gmail.com','Quảng Ngãi','19123877',1),(50,'Bùi Công','An','2001-08-12 00:00:00','Male','namanas@gmail.com','Quảng Trị','009993810',2),(59,'Nguyễn Thị Thúy Ngân','Ngân','2001-07-21 00:00:00','Female','nganngan@gmail.com','Bến Che','0877900625',6);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `lastname` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `phonenumber` int NOT NULL,
  `email` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `adress` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL,
  `account_id` int NOT NULL,
  PRIMARY KEY (`teacher_id`),
  UNIQUE KEY `teacher_id_UNIQUE` (`teacher_id`),
  KEY `fk_teacher_account_idx` (`account_id`),
  CONSTRAINT `fk_teacher_account` FOREIGN KEY (`account_id`) REFERENCES `user_account` (`user_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'Thành','Dương Hữu','1992-02-02',223421231,'thanh.dh@gmail.com','TP.HCM',2),(2,'Trang','Nguyễn Thị Phương','1994-03-12',90239129,'trang.ntp@gmai.com','Hà Nội',2),(3,'Phương','Lưu Quang','1991-09-23',10239192,'phuong.lq@gmail.com','Đà Nẵng',2);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_account`
--

DROP TABLE IF EXISTS `user_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_account` (
  `user_account_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(45) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`user_account_id`),
  UNIQUE KEY `user_account_id_UNIQUE` (`user_account_id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_account`
--

LOCK TABLES `user_account` WRITE;
/*!40000 ALTER TABLE `user_account` DISABLE KEYS */;
INSERT INTO `user_account` VALUES (1,'Admin','abc'),(2,'thanh.dh@gmail.com','123');
/*!40000 ALTER TABLE `user_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 22:53:44
