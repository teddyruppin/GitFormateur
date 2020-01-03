-- MySQL dump 10.13  Distrib 5.6.45, for Linux (x86_64)
--
-- Host: localhost    Database: englishbattle
-- ------------------------------------------------------
-- Server version	5.6.45
set charset 'utf8';

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

--
-- Table structure for table `Joueur`
--

DROP TABLE IF EXISTS `Joueur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Joueur` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `motDePasse` varchar(255) DEFAULT NULL,
  `pseudo` varchar(255) DEFAULT NULL,
  `niveau_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lb1s5xv65691p62nrc5t5xgje` (`email`),
  KEY `FKcpjvo1jijb7r3lkfvstn8giv9` (`niveau_id`)
) ENGINE=MyISAM;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Joueur`
--

LOCK TABLES `Joueur` WRITE;
/*!40000 ALTER TABLE `Joueur` DISABLE KEYS */;
/*!40000 ALTER TABLE `Joueur` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Niveau`
--

DROP TABLE IF EXISTS `Niveau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Niveau` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Niveau`
--

LOCK TABLES `Niveau` WRITE;
/*!40000 ALTER TABLE `Niveau` DISABLE KEYS */;
INSERT INTO `Niveau` VALUES (1,'débutant');
/*!40000 ALTER TABLE `Niveau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Partie`
--

DROP TABLE IF EXISTS `Partie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Partie` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `joueur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt39vhifbvj2ods6y2yckro7bj` (`joueur_id`)
) ENGINE=MyISAM;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Partie`
--

LOCK TABLES `Partie` WRITE;
/*!40000 ALTER TABLE `Partie` DISABLE KEYS */;
/*!40000 ALTER TABLE `Partie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Question`
--

DROP TABLE IF EXISTS `Question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `affichePreterit` bit(1) DEFAULT NULL,
  `dateEnvoi` datetime DEFAULT NULL,
  `dateReponse` datetime DEFAULT NULL,
  `reponseParticipePasse` varchar(255) DEFAULT NULL,
  `reponsePreterit` varchar(255) DEFAULT NULL,
  `partie_id` bigint(20) DEFAULT NULL,
  `verbe_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ygknjb3g59ty3fqrpyh0dkue` (`partie_id`),
  KEY `FKhvqcqpbxbewcd19cnpec4iqlh` (`verbe_id`)
) ENGINE=MyISAM;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Question`
--

LOCK TABLES `Question` WRITE;
/*!40000 ALTER TABLE `Question` DISABLE KEYS */;
/*!40000 ALTER TABLE `Question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Verbe`
--

DROP TABLE IF EXISTS `Verbe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Verbe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `baseVerbale` varchar(255) DEFAULT NULL,
  `participePasse` varchar(255) DEFAULT NULL,
  `preterit` varchar(255) DEFAULT NULL,
  `traduction` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_h0dv0b7vku0d6p51xxn0af0is` (`baseVerbale`)
) ENGINE=MyISAM;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Verbe`
--

LOCK TABLES `Verbe` WRITE;
/*!40000 ALTER TABLE `Verbe` DISABLE KEYS */;
/*!40000 ALTER TABLE `Verbe` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
