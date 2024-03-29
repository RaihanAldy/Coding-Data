-- MariaDB dump 10.19  Distrib 10.4.28-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: penjualan
-- ------------------------------------------------------
-- Server version	10.4.28-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `barang`
--

DROP TABLE IF EXISTS `barang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `barang` (
  `kd_brg` char(10) NOT NULL,
  `nm_brg` char(25) DEFAULT NULL,
  `satuan` char(10) DEFAULT NULL,
  `harga` double NOT NULL,
  `stok` int(5) DEFAULT NULL,
  `stok_min` int(4) NOT NULL,
  PRIMARY KEY (`kd_brg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `barang`
--

LOCK TABLES `barang` WRITE;
/*!40000 ALTER TABLE `barang` DISABLE KEYS */;
INSERT INTO `barang` VALUES ('001','Sapu','Buah',35000,15,3),('002','Meja','Buah',80000,10,2),('003','Sendok','Buah',2500,37,20),('004','Tissue','Lembar',1000,1000,100),('005','Pensil','Buah',3000,25,5);
/*!40000 ALTER TABLE `barang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beli`
--

DROP TABLE IF EXISTS `beli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beli` (
  `no_beli` varchar(10) NOT NULL,
  `kd_pmsk` varchar(10) DEFAULT NULL,
  `tgl_beli` date DEFAULT NULL,
  PRIMARY KEY (`no_beli`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beli`
--

LOCK TABLES `beli` WRITE;
/*!40000 ALTER TABLE `beli` DISABLE KEYS */;
INSERT INTO `beli` VALUES ('2','2','2023-07-05'),('3','2','2023-07-06');
/*!40000 ALTER TABLE `beli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbeli`
--

DROP TABLE IF EXISTS `dbeli`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbeli` (
  `no_beli` varchar(6) NOT NULL,
  `kd_brg` varchar(6) NOT NULL,
  `harga_beli` float DEFAULT NULL,
  `jml_beli` int(4) DEFAULT NULL,
  PRIMARY KEY (`no_beli`,`kd_brg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbeli`
--

LOCK TABLES `dbeli` WRITE;
/*!40000 ALTER TABLE `dbeli` DISABLE KEYS */;
INSERT INTO `dbeli` VALUES ('2','001',35000,12),('2','002',80000,4),('3','002',80000,5);
/*!40000 ALTER TABLE `dbeli` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `djual`
--

DROP TABLE IF EXISTS `djual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `djual` (
  `no_jual` varchar(10) NOT NULL,
  `kd_brg` char(6) NOT NULL,
  `harga_jual` float DEFAULT NULL,
  `jml_jual` int(4) DEFAULT NULL,
  PRIMARY KEY (`no_jual`,`kd_brg`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `djual`
--

LOCK TABLES `djual` WRITE;
/*!40000 ALTER TABLE `djual` DISABLE KEYS */;
INSERT INTO `djual` VALUES ('1','002',80000,2),('1','003',2500,10),('1','004',1000,50),('2','001',35000,2),('2','002',80000,3),('3','001',35000,4),('3','002',80000,2),('3','004',1000,40),('4','001',35000,3),('4','002',80000,2),('4','003',2500,3);
/*!40000 ALTER TABLE `djual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jual`
--

DROP TABLE IF EXISTS `jual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jual` (
  `no_jual` varchar(10) NOT NULL,
  `kd_kons` char(6) DEFAULT NULL,
  `tgl_jual` date DEFAULT NULL,
  PRIMARY KEY (`no_jual`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jual`
--

LOCK TABLES `jual` WRITE;
/*!40000 ALTER TABLE `jual` DISABLE KEYS */;
INSERT INTO `jual` VALUES ('1','001','2023-07-03'),('2','002','2023-07-03'),('3','002','2023-07-03'),('4','2','2023-07-06');
/*!40000 ALTER TABLE `jual` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `konsumen`
--

DROP TABLE IF EXISTS `konsumen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `konsumen` (
  `kd_kons` varchar(6) NOT NULL,
  `nm_kons` varchar(30) DEFAULT NULL,
  `alm_kons` varchar(50) DEFAULT NULL,
  `kota_kons` varchar(20) DEFAULT NULL,
  `kd_pos` varchar(5) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`kd_kons`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `konsumen`
--

LOCK TABLES `konsumen` WRITE;
/*!40000 ALTER TABLE `konsumen` DISABLE KEYS */;
INSERT INTO `konsumen` VALUES ('1','Jafar','Jalan Kepodang Raya no 3','Semarang','54321','085671542311','Jafar12@gmail.com'),('2','Bayu','Jalan Banyubiru no.14,Kec.Kaliurang','Gorontalo','54455','081223564771','Bayu_22@gmail.com');
/*!40000 ALTER TABLE `konsumen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pemasok`
--

DROP TABLE IF EXISTS `pemasok`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pemasok` (
  `kd_pmsk` char(10) NOT NULL,
  `nm_pmsk` char(25) DEFAULT NULL,
  `nm_brg` char(25) DEFAULT NULL,
  `kd_brg` char(10) DEFAULT NULL,
  PRIMARY KEY (`kd_pmsk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pemasok`
--

LOCK TABLES `pemasok` WRITE;
/*!40000 ALTER TABLE `pemasok` DISABLE KEYS */;
INSERT INTO `pemasok` VALUES ('1','Home Cleaning','Sapu','001'),('2','Abel Furniture','Meja','002'),('3','Wooden Kitchen Set','Sendok','003'),('4','Home Cleaning','Tissue','004'),('5','Chizz Kitchen','Tissue','004');
/*!40000 ALTER TABLE `pemasok` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(4) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(254) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Admin','admin','addmin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-06 15:12:32
