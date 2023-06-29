CREATE DATABASE  IF NOT EXISTS `unla` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `unla`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: unla
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `mail` varchar(255) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKr1e0j10i9v9i52l6tqfa69nj0` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `degree`
--

DROP TABLE IF EXISTS `degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `createdat` datetime(6) DEFAULT NULL,
  `institution` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `person_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKf2n49y1ac1ofxko5wukvqatrt` (`person_id`),
  CONSTRAINT `FKf2n49y1ac1ofxko5wukvqatrt` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `degree`
--

LOCK TABLES `degree` WRITE;
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'CamaraVigilancia',_binary ''),(2,'SensorEstacionamiento',_binary ''),(3,'SensorHumedad',_binary ''),(4,'SensorTemperaturaAula',_binary ''),(5,'SensorLuminosidad',_binary ''),(8,'otrofgg  ',_binary '\0'),(9,'DispositivoNuevo',_binary '\0');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `work_file` varchar(255) DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKt824vonkbw2cnqvtmscpuodj9` FOREIGN KEY (`id`) REFERENCES `person` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parking_sensor`
--

DROP TABLE IF EXISTS `parking_sensor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parking_sensor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `available` bit(1) DEFAULT NULL,
  `device_id` int NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_parking_sensor_device1_idx` (`device_id`),
  CONSTRAINT `FKc1tg7i2tmlmlt9y04k8bhm7ha` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parking_sensor`
--

LOCK TABLES `parking_sensor` WRITE;
/*!40000 ALTER TABLE `parking_sensor` DISABLE KEYS */;
INSERT INTO `parking_sensor` VALUES (1,_binary '',2,_binary ''),(2,_binary '\0',2,_binary ''),(3,_binary '',2,_binary ''),(4,_binary '\0',2,_binary ''),(5,_binary '',2,_binary '\0'),(6,_binary '',2,_binary ''),(7,_binary '\0',2,_binary ''),(8,_binary '\0',2,_binary ''),(9,_binary '',2,_binary ''),(10,_binary '',2,_binary ''),(11,_binary '',2,_binary ''),(12,_binary '\0',2,_binary ''),(13,_binary '',2,_binary ''),(14,_binary '\0',2,_binary ''),(21,_binary '\0',2,_binary ''),(22,_binary '\0',2,_binary ''),(23,_binary '\0',2,_binary '');
/*!40000 ALTER TABLE `parking_sensor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` int NOT NULL AUTO_INCREMENT,
  `birthdate` date DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spot`
--

DROP TABLE IF EXISTS `spot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `spot` (
  `id` int NOT NULL AUTO_INCREMENT,
  `number` int DEFAULT NULL,
  `sector` varchar(30) DEFAULT NULL,
  `reserved` int DEFAULT NULL,
  `last-domain` varchar(8) DEFAULT NULL,
  `parking_sensor_id` int DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `parking_sensor_id_UNIQUE` (`parking_sensor_id`),
  UNIQUE KEY `reserved_UNIQUE` (`reserved`),
  KEY `fk_plaza_user1_idx` (`reserved`),
  KEY `fk_spot_parking_sensor1_idx` (`parking_sensor_id`),
  CONSTRAINT `FK6sf6q2rcx4bng4fy77qy9umbg` FOREIGN KEY (`parking_sensor_id`) REFERENCES `parking_sensor` (`id`),
  CONSTRAINT `fk_plaza_user1` FOREIGN KEY (`reserved`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spot`
--

LOCK TABLES `spot` WRITE;
/*!40000 ALTER TABLE `spot` DISABLE KEYS */;
INSERT INTO `spot` VALUES (2,1,'A',NULL,NULL,1,_binary ''),(3,2,'A',NULL,NULL,2,_binary ''),(4,3,'A',NULL,NULL,3,_binary ''),(6,4,'A',NULL,NULL,4,_binary ''),(7,5,'A',NULL,NULL,5,_binary ''),(8,6,'A',NULL,NULL,NULL,_binary ''),(9,7,'A',NULL,NULL,NULL,_binary ''),(10,8,'A',NULL,NULL,NULL,_binary ''),(11,9,'A',NULL,NULL,NULL,_binary ''),(12,1,'B',NULL,NULL,6,_binary ''),(13,2,'B',NULL,NULL,7,_binary ''),(16,3,'B',NULL,NULL,NULL,_binary ''),(18,4,'B',NULL,NULL,NULL,_binary '\0'),(19,5,'B',NULL,NULL,NULL,_binary ''),(20,6,'B',NULL,NULL,NULL,_binary ''),(21,7,'B',NULL,NULL,NULL,_binary ''),(22,1,'C',NULL,NULL,8,_binary ''),(23,2,'C',NULL,NULL,9,_binary '\0'),(24,3,'C',NULL,NULL,12,_binary '\0'),(25,0,'',NULL,NULL,NULL,_binary '\0'),(26,1,'D',NULL,NULL,13,_binary ''),(27,0,'',NULL,NULL,NULL,_binary ''),(28,0,'',NULL,NULL,NULL,_binary '\0');
/*!40000 ALTER TABLE `spot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(60) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Pablo','$2a$10$3rUvlOwUByPmA8Uo1GesUeNpzo9tzL7cURstCfXagJmXNU2fS5fci',_binary '','2023-06-28 21:50:56.000000','2023-06-28 21:50:56.000000'),(2,'Admin','$2a$10$cOQuuWyVxfOKfjQwVR6il.iUnB1JmLVd7ri.iN2wZwDYjHBJwWvr.',_binary '','2023-06-28 21:50:56.000000','2023-06-28 21:50:56.000000'),(3,'Pepito','$2a$10$LFXVyjSCQsLQGwRTcyei6eBf1zKygU2Y5FfqeByXOzYM52fuLU5ty',_binary '','2023-06-28 21:50:56.000000','2023-06-28 21:50:56.000000');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(100) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `user_id` int NOT NULL,
  `createdat` datetime(6) DEFAULT NULL,
  `updatedat` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`),
  UNIQUE KEY `UKscfpive7aa0o9savdwmxmnaij` (`role`,`user_id`),
  KEY `fk_user_role_user_idx` (`user_id`),
  CONSTRAINT `fk_user_role_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,'ROLE_ADMIN',_binary '',2,'2023-06-28 21:54:25.000000','2023-06-28 21:54:25.000000'),(2,'ROLE_USER',_binary '',1,'2023-06-28 21:54:25.000000','2023-06-28 21:54:25.000000'),(3,'ROLE_STAFF',_binary '',3,'2023-06-28 21:54:25.000000','2023-06-28 21:54:25.000000');
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-29  1:02:55
