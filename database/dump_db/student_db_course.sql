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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-01 12:44:47
