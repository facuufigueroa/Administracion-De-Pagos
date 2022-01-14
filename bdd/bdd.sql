-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mataderobragado
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `dia_turno`
--

DROP TABLE IF EXISTS `dia_turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dia_turno` (
  `iddia_turno` int NOT NULL AUTO_INCREMENT,
  `iddia` int DEFAULT NULL,
  `idturno` int DEFAULT NULL,
  PRIMARY KEY (`iddia_turno`),
  KEY `fk_iddia` (`iddia`),
  KEY `fk_idturno` (`idturno`),
  CONSTRAINT `fk_iddia` FOREIGN KEY (`iddia`) REFERENCES `dias` (`iddias`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idturno` FOREIGN KEY (`idturno`) REFERENCES `turno` (`idturno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dia_turno`
--

LOCK TABLES `dia_turno` WRITE;
/*!40000 ALTER TABLE `dia_turno` DISABLE KEYS */;
INSERT INTO `dia_turno` VALUES (1,1,1),(2,2,2),(3,3,3),(4,4,4),(5,5,5),(6,6,6),(7,8,7);
/*!40000 ALTER TABLE `dia_turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dias`
--

DROP TABLE IF EXISTS `dias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dias` (
  `iddias` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`iddias`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias`
--

LOCK TABLES `dias` WRITE;
/*!40000 ALTER TABLE `dias` DISABLE KEYS */;
INSERT INTO `dias` VALUES (1,'lunes'),(2,'martes'),(3,'miercoles'),(4,'jueves'),(5,'viernes'),(6,'sabado'),(7,'domingo'),(8,'extra');
/*!40000 ALTER TABLE `dias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_diaturno`
--

DROP TABLE IF EXISTS `empleado_diaturno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_diaturno` (
  `idempleado_diaTurno` int NOT NULL AUTO_INCREMENT,
  `idempleado` int DEFAULT NULL,
  `iddiaturno` int DEFAULT NULL,
  PRIMARY KEY (`idempleado_diaTurno`),
  UNIQUE KEY `idempleado_diaTurno_UNIQUE` (`idempleado_diaTurno`),
  KEY `fk_iddiaturno` (`iddiaturno`),
  KEY `fk_idempleado` (`idempleado`),
  CONSTRAINT `fk_iddiaturno` FOREIGN KEY (`iddiaturno`) REFERENCES `dia_turno` (`iddia_turno`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idempleado` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_diaturno`
--

LOCK TABLES `empleado_diaturno` WRITE;
/*!40000 ALTER TABLE `empleado_diaturno` DISABLE KEYS */;
INSERT INTO `empleado_diaturno` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(5,1,5),(6,1,6),(7,1,7);
/*!40000 ALTER TABLE `empleado_diaturno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_turno`
--

DROP TABLE IF EXISTS `empleado_turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_turno` (
  `idempleado_turno` int NOT NULL AUTO_INCREMENT,
  `idempleado` int NOT NULL,
  `idturno` int NOT NULL,
  `iddia` int NOT NULL,
  PRIMARY KEY (`idempleado_turno`),
  KEY `fkidturno_idx` (`idturno`),
  KEY `fkidempleado_idx` (`idempleado`),
  CONSTRAINT `fkidempleado` FOREIGN KEY (`idempleado`) REFERENCES `empleado_diaturno` (`idempleado`) ON DELETE CASCADE,
  CONSTRAINT `fkidturno` FOREIGN KEY (`idturno`) REFERENCES `turno` (`idturno`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_turno`
--

LOCK TABLES `empleado_turno` WRITE;
/*!40000 ALTER TABLE `empleado_turno` DISABLE KEYS */;
INSERT INTO `empleado_turno` VALUES (1,1,1,1),(2,1,2,2),(3,1,3,3),(4,1,4,4),(5,1,5,5),(6,1,6,6),(7,1,7,8);
/*!40000 ALTER TABLE `empleado_turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleados` (
  `idempleado` int NOT NULL AUTO_INCREMENT,
  `dni` bigint NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `telefono` bigint DEFAULT NULL,
  `sueldo` int DEFAULT NULL,
  `descuentos_totales` int DEFAULT '0',
  `subtotales_totales` int DEFAULT '0',
  PRIMARY KEY (`idempleado`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,36677186,'ANTEZANA V.LUCAS',505086,1800,100,1900),(2,26865850,'ASTUDILLO JUANI',461248,0,0,1000),(3,28239609,'ASTUDILLO MARIO',485103,0,0,100),(4,36021265,'BATAGLIA CLAUDIO',532020,0,0,0),(5,36283010,'CAMPAGNA JOSE',547328,0,0,0),(7,31526726,'CHAZARRETA JUAN',562281,0,NULL,NULL),(8,38553382,'COSTA SEBASTIAN',545626,0,NULL,NULL),(9,36259590,'FENOY JOSE',463954,0,NULL,NULL),(10,33951556,'FERREYRA ALEJANDRO',407510,0,NULL,NULL),(11,33951612,'GARCIA MARCELO',569213,0,NULL,NULL),(12,36259439,'GUERRERO MICAELA',459251,0,NULL,NULL),(13,37033011,'LOPEZ ERIC',485967,0,NULL,NULL),(14,29824902,'LUNA LEONARDO',458189,0,NULL,NULL),(15,95348387,'MARTINEZ RODRIGO',561735,0,NULL,NULL),(16,36625863,'MASA ALEJANDRO',51206,0,NULL,NULL),(17,26717462,'MINTEGUI JUAN',504823,0,NULL,NULL),(19,24181910,'MONTENEGRO GERMAN',512384,0,NULL,NULL),(20,42538545,'NICOLA C.DAVID ',402070,0,NULL,NULL),(21,29240327,'ORTELLADO JUAN PABLO',561462,0,NULL,NULL),(22,32098729,'PERON CARLOS',506081,0,NULL,NULL),(23,22894187,'NICOLA CRISTIAN PIRI',46485,0,NULL,NULL),(24,28365078,'QUIROGA JUAN JOSE',556206,0,0,0),(25,38553277,'RAFAEL BRAIAN',510925,0,NULL,NULL),(26,33335478,'REBECA MOSCOLINI',403059,0,0,0),(27,27776611,'ROMAGNOLI JOSE ',559312,0,0,0),(28,33641976,'SPADA NESTOR',409816,0,0,0),(29,26767669,'VEGA GISELA ',402894,0,0,0),(30,20352061,'VEGA VIVIANA',509783,0,0,0),(31,32098821,'VILLALBA HECTOR',546279,0,0,0),(32,34157763,'VILLANUEVA JUAN',1137774687,0,0,0),(33,35095767,'GOMEZ ESTEBAN F.',2342456302,0,0,0);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensualidad`
--

DROP TABLE IF EXISTS `mensualidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensualidad` (
  `idmensualidad` int NOT NULL AUTO_INCREMENT,
  `totalmensual` int DEFAULT NULL,
  PRIMARY KEY (`idmensualidad`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensualidad`
--

LOCK TABLES `mensualidad` WRITE;
/*!40000 ALTER TABLE `mensualidad` DISABLE KEYS */;
INSERT INTO `mensualidad` VALUES (1,1800);
/*!40000 ALTER TABLE `mensualidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `turno` (
  `idturno` int NOT NULL AUTO_INCREMENT,
  `t1` int DEFAULT NULL,
  `t2` int DEFAULT NULL,
  `t3` int DEFAULT NULL,
  `t4` int DEFAULT NULL,
  `descuento` int DEFAULT NULL,
  `total` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `idempleado` int NOT NULL,
  PRIMARY KEY (`idturno`),
  KEY `idempleado_idx` (`idempleado`),
  CONSTRAINT `fk_idempleado_1` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `idempleado` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,1900,0,0,0,0,1900,'2020-10-10',1),(2,0,0,0,0,0,0,'2020-10-10',1),(3,0,0,0,0,0,0,'2020-10-10',1),(4,0,0,0,0,0,0,'2020-10-10',1),(5,0,0,0,0,0,0,'2020-10-10',1),(6,0,0,0,0,0,0,'2020-10-10',1),(7,0,0,0,0,100,0,'2020-10-10',1);
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-14 11:33:10
