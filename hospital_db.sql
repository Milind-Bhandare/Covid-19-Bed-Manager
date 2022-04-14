-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hospital_mgt
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `hospital_master`
--

DROP TABLE IF EXISTS `hospital_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital_master` (
  `hospital_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `hospital_name` varchar(64) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `pin_code` varchar(8) DEFAULT NULL,
  `contact_number` varchar(12) NOT NULL,
  `is_covid` varchar(1) DEFAULT NULL,
  `total_normal_beds` varchar(4) NOT NULL,
  `occupied_normal_beds` varchar(4) NOT NULL,
  `total_oxygen_beds` varchar(4) NOT NULL,
  `occupied_oxygen_beds` varchar(4) NOT NULL,
  `total_icu_beds` varchar(4) NOT NULL,
  `occupied_icu_beds` varchar(4) NOT NULL,
  PRIMARY KEY (`hospital_id`),
  KEY `fk_hos_user_id` (`user_id`),
  CONSTRAINT `fk_hos_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital_master`
--

LOCK TABLES `hospital_master` WRITE;
/*!40000 ALTER TABLE `hospital_master` DISABLE KEYS */;
INSERT INTO `hospital_master` VALUES (1,3,'abc','city','state','con',NULL,'12345','12345','Y','10','0','10','0','10','0'),(2,5,'Godavari','jalgaon','MH','India',NULL,'425001','12345','Y','20','10','25','20','10','8'),(3,NULL,'test','ad','ad','ad',NULL,'12','12','Y','10','0','10','0','10','0'),(4,7,'civil','jalgaon','maharashtra','India','jilha peth,jalgaon','425001','123456','Y','50','40','30','25','10','8');
/*!40000 ALTER TABLE `hospital_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_enquiry`
--

DROP TABLE IF EXISTS `patient_enquiry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_enquiry` (
  `enquiry_id` int NOT NULL AUTO_INCREMENT,
  `patient_id` int DEFAULT NULL,
  `hospital_id` int DEFAULT NULL,
  `date_of_enquiry` varchar(50) DEFAULT NULL,
  `symtoms_detail` varchar(512) NOT NULL,
  `status` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`enquiry_id`),
  KEY `fk_hos_hos_id` (`hospital_id`),
  KEY `fk_pat_pat_id` (`patient_id`),
  CONSTRAINT `fk_hos_hos_id` FOREIGN KEY (`hospital_id`) REFERENCES `hospital_master` (`hospital_id`),
  CONSTRAINT `fk_pat_pat_id` FOREIGN KEY (`patient_id`) REFERENCES `patient_master` (`patient_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_enquiry`
--

LOCK TABLES `patient_enquiry` WRITE;
/*!40000 ALTER TABLE `patient_enquiry` DISABLE KEYS */;
INSERT INTO `patient_enquiry` VALUES (1,2,1,'Fri Apr 01 20:24:23 IST 2022','my symptoms','open'),(2,2,2,'Fri Apr 01 20:55:47 IST 2022','my symptoms','close'),(3,3,2,'Fri Apr 01 21:19:35 IST 2022','High Fever and Cold','close'),(4,2,2,'Fri Apr 01 21:48:57 IST 2022','High Fever and Headche','close'),(5,2,4,'Fri Apr 01 22:36:15 IST 2022','fever','open');
/*!40000 ALTER TABLE `patient_enquiry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient_master`
--

DROP TABLE IF EXISTS `patient_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient_master` (
  `patient_id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `patient_name` varchar(64) NOT NULL,
  `gender` varchar(8) DEFAULT NULL,
  `contact_number` varchar(12) NOT NULL,
  `address` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `pin_code` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `fk_pat_user_id` (`user_id`),
  CONSTRAINT `fk_pat_user_id` FOREIGN KEY (`user_id`) REFERENCES `user_master` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient_master`
--

LOCK TABLES `patient_master` WRITE;
/*!40000 ALTER TABLE `patient_master` DISABLE KEYS */;
INSERT INTO `patient_master` VALUES (1,4,'patient','male','001100','add','city','state','con','12345'),(2,6,'Patient1','male','12345','jalgaon','jalgaon','MH','India','425001'),(3,8,'Patient 2','male','1234567890','Balaji Peth','Jalgaon','MH','India','425001');
/*!40000 ALTER TABLE `patient_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_master`
--

DROP TABLE IF EXISTS `user_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_master` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `user_type` varchar(1) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_master`
--

LOCK TABLES `user_master` WRITE;
/*!40000 ALTER TABLE `user_master` DISABLE KEYS */;
INSERT INTO `user_master` VALUES (3,'test@gmail.com','test','H'),(4,'hello@gmail.com','test','P'),(5,'godavari@gmail.com','password','H'),(6,'patient@gmail.com','password','P'),(7,'civil@gmail.com','civil','H'),(8,'patient2@gmail.com','password','P');
/*!40000 ALTER TABLE `user_master` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-04-02 18:30:19
