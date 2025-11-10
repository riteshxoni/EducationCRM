-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: localhost    Database: educationcrm
-- ------------------------------------------------------
-- Server version	8.0.44

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `created_date` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKc0r9atamxvbhjjvy5j8da1kam` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'2025-11-02','superadmin@gmail.com','Super Admin','Ritesh@123','ADMIN'),(2,'2025-11-02','anisha@gmail.com','Anisha','Anisha@123','ADMIN');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `discounted_price` varchar(255) DEFAULT NULL,
  `image_url` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `orignal_price` varchar(255) DEFAULT NULL,
  `updated_on` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'Learn (JavaEE) advanced Java concepts with real-world examples.','499','images/advanced-java.jpg','Advanced Java','999','2025-10-27 20:19:38'),(2,'Become a complete Java full stack developer.','499','images/fullstack.png','Full Stack Java Developer','1299','2025-10-27 20:19:38'),(3,'Master Hibernate and JPA for Java database applications.','299','images/hibernate_jpa.png','Hibernate & JPA','899','2025-10-27 20:19:38'),(5,'Build enterprise-grade apps using Java EE.','349','images/java_ee.png','Java EE','899','2025-10-27 20:19:38'),(7,'Learn complete Java Full Stack Development roadmap.','599','images/Java-full-stack.png','Java Full Stack Mastery','1499','2025-10-27 20:19:38'),(8,'Build microservices architecture using Java & Spring Boot.','449','images/microservices.png','Java Microservices','999','2025-10-27 20:19:38'),(9,'Develop RESTful APIs using Java and Spring Boot.','399','images/restful_java.png','RESTful Java APIs','899','2025-10-27 20:19:38'),(10,'Learn rapid backend development using Spring Boot.','349','images/spring_boot.png','Spring Boot','899','2025-10-27 20:19:38'),(11,'Master Spring Framework from scratch to advanced.','399','images/spring_framework.png','Spring Framework','999','2025-10-27 20:19:38');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `phoneno` varchar(15) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKfopic1oh5oln2khj8eat6ino0` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Delhi NCR','ravi.kumar@gmail.com','Ravi Kumar Soni','9876543210',NULL),(3,'Bangalore','aman.verma@gmail.com','Aman Verma','9988776655',NULL),(4,'Kolkata','sneha.singh@gmail.com','Sneha Singh','9090909090',NULL),(5,'Pune','rahul.mehta@gmail.com','Rahul Mehta','9812345678',NULL),(6,'Chennai','neha.gupta@gmail.com','Neha Gupta','9823456789',NULL),(7,'Lucknow','arjun.yadav@gmail.com','Arjun Yadav','9834567890',NULL),(8,'Ahmedabad','divya.patel@gmail.com','Divya Patel','9845678901',NULL),(9,'Jaipur','sahil.khan@gmail.com','Sahil Khan','9856789012',NULL),(10,'Hyderabad','pooja.rani@gmail.com','Pooja Rani','9867890123',NULL),(11,'Patna','ramesh.sinha@gmail.com','Ramesh Sinha','9878901234',NULL),(12,'Bhubaneswar','anjali.das@gmail.com','Anjali Das','9889012345',NULL),(13,'Surat','karan.malhotra@gmail.com','Karan Malhotra','9890123456',NULL),(14,'Indore','meena.joshi@gmail.com','Meena Joshi','9901234567',NULL),(15,'Nagpur','vikram.rao@gmail.com','Vikram Rao','9912345678',NULL),(16,'RANCHI','anishasingh5666@gmail.com','Anisha Kumari','8102881984','Anisha@123'),(20,'RANCHI','ritesh@gmail.com','RITESH KUMAR SONI','07004270485','Ritesh@123'),(21,'RANCHI','puja@gmail.com','Puja Kumari','6299521928','Puja@123');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedback` (
  `id` int NOT NULL AUTO_INCREMENT,
  `date` date DEFAULT NULL,
  `std_course` varchar(255) DEFAULT NULL,
  `std_email` varchar(255) DEFAULT NULL,
  `std_message` varchar(255) DEFAULT NULL,
  `std_name` varchar(255) DEFAULT NULL,
  `time` time(6) DEFAULT NULL,
  `status` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'2025-11-04','Full Stack Java','ritesh@gmail.com','Java full stack course bahut achha hai, practice ke liye examples helpful hain.','Ritesh Kumar Soni','12:00:00.000000',1),(2,'2025-11-04','Full Stack Java','rahul.sharma@gmail.com','Course material updated hai aur industry relevant topics cover karta hai.','Rahul Sharma','12:05:00.000000',0),(3,'2025-11-04','Full Stack Java','priya.kapoor@gmail.com','Course structure beginners ke liye perfect hai.','Priya Kapoor','12:10:00.000000',0),(4,'2025-11-04','Full Stack Java','amit.verma@gmail.com','Teaching style engaging hai, boring topics bhi easy lagte hain.','Amit Verma','12:15:00.000000',0),(5,'2025-11-04','Full Stack Java','sneha.patil@gmail.com','Real-time examples se topic clear ho gaya.','Sneha Patil','12:20:00.000000',0),(6,'2025-11-04','Full Stack Java','arjun.iyer@gmail.com','JavaScript aur React module useful raha.','Arjun Iyer','12:25:00.000000',1),(7,'2025-11-04','Full Stack Java','ravi.das@gmail.com','Class recording dekh kar revise karna easy hota hai.','Ravi Das','12:30:00.000000',1),(8,'2025-11-04','Full Stack Java','neha.singh@gmail.com','Instructor ka explanation bahut clear hai.','Neha Singh','12:35:00.000000',1),(9,'2025-11-04','Full Stack Java','vikram.reddy@gmail.com','Course pace balanced hai, na zyada fast na slow.','Vikram Reddy','12:40:00.000000',1),(10,'2025-11-04','Full Stack Java','meena.patel@gmail.com','Mentorship aur guidance regular milti hai.','Meena Patel','12:45:00.000000',1),(11,'2025-11-04','Full Stack Java','anil.yadav@gmail.com','Course affordable aur worth it hai.','Anil Yadav','12:50:00.000000',1),(12,'2025-11-04','Full Stack Java','divya.mishra@gmail.com','Step-by-step guidance milti hai.','Divya Mishra','12:55:00.000000',1),(13,'2025-11-04','Full Stack Java','rohan.desai@gmail.com','Practical exposure mila har concept par.','Rohan Desai','13:00:00.000000',1),(14,'2025-11-04','Full Stack Java','tanya.jain@gmail.com','Instructor friendly aur knowledgeable hain.','Tanya Jain','13:05:00.000000',1),(15,'2025-11-04','Full Stack Java','sahil.khan@gmail.com','Real-world project experience valuable tha.','Sahil Khan','13:10:00.000000',1),(16,'2025-11-04','Full Stack Java','isha.gupta@gmail.com','Java course structured aur well-organized hai.','Isha Gupta','13:15:00.000000',1),(17,'2025-11-04','Full Stack Java','gagan@gmail.com','Course ke through full stack ka overall idea mila.','Gagan','13:20:00.000000',1);
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow_ups`
--

DROP TABLE IF EXISTS `follow_ups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow_ups` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `employee_email` varchar(255) NOT NULL,
  `follow_up_date` varchar(255) NOT NULL,
  `phoneno` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKpbpjc3fcq6p6tewc2kwajc8e7` (`phoneno`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow_ups`
--

LOCK TABLES `follow_ups` WRITE;
/*!40000 ALTER TABLE `follow_ups` DISABLE KEYS */;
INSERT INTO `follow_ups` VALUES (1,'ritesh@gmail.com','2025-11-02','9898123456'),(2,'ritesh@gmail.com','2025-11-03','9765432109'),(3,'ritesh@gmail.com','2025-11-04','9823456789'),(4,'ritesh@gmail.com','2025-11-05','9789012345'),(5,'ritesh@gmail.com','2025-11-06','9912345678'),(6,'ritesh@gmail.com','2025-11-07','9845678901'),(7,'ritesh@gmail.com','2025-11-08','9897654321'),(8,'ritesh@gmail.com','2025-11-09','9798123456'),(9,'ritesh@gmail.com','2025-11-10','9823098765'),(10,'ritesh@gmail.com','2025-11-11','9876012345'),(11,'ritesh@gmail.com','2025-11-12','9801234567'),(12,'ritesh@gmail.com','2025-11-13','9832012345'),(13,'ritesh@gmail.com','2025-11-14','9856789012'),(14,'ritesh@gmail.com','2025-11-15','07004270485'),(15,'ritesh@gmail.com','2025-11-16','9823012345'),(16,'ritesh@gmail.com','2025-11-17','9812340987'),(17,'ritesh@gmail.com','2025-11-18','9819988776'),(18,'ritesh@gmail.com','2025-11-19','9801122334'),(19,'ritesh@gmail.com','2025-11-20','9805566778');
/*!40000 ALTER TABLE `follow_ups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquery`
--

DROP TABLE IF EXISTS `inquery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inquery` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `call_type` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `discussion` varchar(255) NOT NULL,
  `employee_email` varchar(255) NOT NULL,
  `inquery_date` datetime(6) NOT NULL,
  `inquery_type` varchar(255) NOT NULL,
  `interested_course` varchar(255) NOT NULL,
  `phoneno` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquery`
--

LOCK TABLES `inquery` WRITE;
/*!40000 ALTER TABLE `inquery` DISABLE KEYS */;
INSERT INTO `inquery` VALUES (1,'Inbound Call','Rohan Desai','abc','ritesh@gmail.com','2025-10-31 14:26:16.695000','Call','Full Stack Java Developer','9876543210','Intrested-(Follow Up)'),(2,'Inbound Call','Rohan Desai','wo bola paise km kr dijiye so i discounted 500','ritesh@gmail.com','2025-10-31 23:29:53.732000','Social Media','Full Stack Java Developer','9876543210','Intrested-(Follow Up)'),(3,'Inbound Call','Rohan Desai','course purchased','ritesh@gmail.com','2025-10-31 23:30:54.593000','Call','Full Stack Java Developer','9876543210','Purchased-(Closed)'),(4,'Inbound Call','Rohan Desai','Asked about full stack course','ritesh@gmail.com','2025-10-31 14:26:16.000000','Call','Full Stack Java Developer','9876543210','Interested-(Follow Up)'),(5,'Inbound Call','Priya Kapoor','Requested syllabus details','ritesh@gmail.com','2025-10-31 15:22:10.000000','Social Media','Java Developer','9898123456','Interested-(Follow Up)'),(6,'Inbound Call','Amit Verma','Asked about placement support','ritesh@gmail.com','2025-10-31 16:10:44.000000','Call','Spring Boot Developer','9765432109','Not Responding'),(7,'Inbound Call','Sneha Patil','Discussed fees and batches','ritesh@gmail.com','2025-11-01 09:12:25.000000','Call','React + Java Full Stack','9823456789','Interested-(Follow Up)'),(8,'Inbound Call','Arjun Iyer','Asked for weekend batch','ritesh@gmail.com','2025-11-01 11:05:12.000000','Social Media','Backend Developer (Java)','9789012345','Interested-(Follow Up)'),(9,'Inbound Call','Neha Singh','Confirmed registration pending','ritesh@gmail.com','2025-11-02 10:15:54.000000','Call','Frontend Developer','9912345678','Interested-(Follow Up)'),(10,'Inbound Call','Vikram Reddy','Paid advance 500 Rs','ritesh@gmail.com','2025-11-02 18:40:21.000000','Call','Full Stack Java Developer','9845678901','Partially Paid'),(11,'Inbound Call','Meena Patel','Asked about online class timings','ritesh@gmail.com','2025-11-03 10:12:33.000000','Social Media','Spring Boot Developer','9897654321','Interested-(Follow Up)'),(12,'Inbound Call','Anil Yadav','Requested recorded lectures info','ritesh@gmail.com','2025-11-03 12:34:55.000000','Call','Java Developer','9798123456','Not Interested'),(13,'Inbound Call','Divya Mishra','Joined demo session','ritesh@gmail.com','2025-11-03 14:22:43.000000','Call','Full Stack Java Developer','9823098765','Interested-(Follow Up)'),(14,'Inbound Call','Tanya Jain','Asked discount for student','ritesh@gmail.com','2025-11-04 10:33:22.000000','Social Media','Spring Boot Developer','9876012345','Interested-(Follow Up)'),(15,'Inbound Call','Sahil Khan','Asked about internship opportunity','ritesh@gmail.com','2025-11-04 11:25:43.000000','Call','Full Stack Java Developer','9801234567','Interested-(Follow Up)'),(16,'Inbound Call','Rahul Sharma','Confirmed admission soon','ritesh@gmail.com','2025-11-05 09:55:13.000000','Call','Backend Developer (Java)','9876543210','Interested-(Follow Up)'),(17,'Inbound Call','Ravi Das','Inquired about online vs offline','ritesh@gmail.com','2025-11-05 11:22:09.000000','Call','Frontend Developer','9832012345','Interested-(Follow Up)'),(18,'Inbound Call','Isha Gupta','Requested schedule after 6pm','ritesh@gmail.com','2025-11-06 17:44:16.000000','Call','React Developer','9856789012','Interested-(Follow Up)'),(19,'Inbound Call','Ritesh Kumar','Requested certificate info','ritesh@gmail.com','2025-11-07 10:16:11.000000','Social Media','Java Developer','07004270485','Interested-(Follow Up)'),(20,'Inbound Call','Rohan Desai','Course purchased fully','ritesh@gmail.com','2025-11-08 10:10:54.000000','Call','Full Stack Java Developer','9876543210','Purchased-(Closed)'),(21,'Inbound Call','Sneha Patil','Requested receipt confirmation','ritesh@gmail.com','2025-11-09 11:30:20.000000','Social Media','React + Java Full Stack','9823456789','Purchased-(Closed)'),(22,'Inbound Call','Divya Mishra','Requested certificate issue date','ritesh@gmail.com','2025-11-10 09:45:13.000000','Call','Full Stack Java Developer','9823098765','Purchased-(Closed)'),(23,'Inbound Call','Amit Verma','Requested next advanced course info','ritesh@gmail.com','2025-11-11 09:10:00.000000','Call','Spring Boot Advanced','9765432109','Interested-(Follow Up)'),(24,'Inbound Call','Rohan Desai','Course Purchased','ritesh@gmail.com','2025-11-01 21:48:12.416000','Call','Full Stack Java Developer','9876543210','Purchased-(Closed)');
/*!40000 ALTER TABLE `inquery` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) DEFAULT NULL,
  `course_price` varchar(255) DEFAULT NULL,
  `date_of_purchase` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `rzp_payment_id` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `employee_email` varchar(255) DEFAULT 'Website',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Full Stack Java Developer','499','29/10/2025, 22:15:22 pm','order_RZMLGSU06jYkxy','pay_RZML185i17xMxd','ritesh@gmail.com',NULL),(2,'Advanced Java','499','30/10/2025, 12:33:57 pm','64c61e63-372e-4992-b8d4-e427af9c0df2','123456789','rahul.sharma@gmail.com','ritesh@gmail.com'),(3,'Hibernate & JPA','299','30/10/2025, 12:33:57 pm','order_RZayCRlCv8HTZi','pay_RZaxx4c29GNksg','ritesh@gmail.com',NULL),(4,'Java Full Stack Mastery','599','30/10/2025, 1:00:09 pm','256b94d2-432f-4449-adac-5a002f32eed5','Cash','ritesh@gmail.com','ritesh@gmail.com'),(5,'Spring Boot','349','02/11/2025, 12:50:18 pm','b1be2c21-9b5f-444c-95b5-cda1d6e899a3','Phone TXN','amit.verma@gmail.com','anishasingh5666@gmail.com'),(6,'Java Full Stack Mastery','599','02/11/2025, 12:51:01 pm','d7887a0c-7dc0-44fd-bae3-02ea44a8c45c','Google TXN','neha.singh@gmail.com','anishasingh5666@gmail.com');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `city` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phoneno` varchar(255) DEFAULT NULL,
  `ban_status` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'RANCHI','ritesh@gmail.com','RITESH KUMAR SONI','Ritesh@123','07004270485',_binary '\0'),(2,'Delhi','rahul.sharma@gmail.com','Rahul Sharma','rahul123','9876543210',_binary '\0'),(3,'Mumbai','priya.kapoor@gmail.com','Priya Kapoor','priya123','9898123456',_binary '\0'),(4,'Bangalore','amit.verma@gmail.com','Amit Verma','amit123','9765432109',_binary '\0'),(5,'Pune','sneha.patil@gmail.com','Sneha Patil','sneha123','9823456789',_binary '\0'),(6,'Chennai','arjun.iyer@gmail.com','Arjun Iyer','arjun123','9789012345',_binary '\0'),(7,'Kolkata','ravi.das@gmail.com','Ravi Das','ravi123','9832012345',_binary '\0'),(8,'Jaipur','neha.singh@gmail.com','Neha Singh','neha123','9912345678',_binary '\0'),(9,'Hyderabad','vikram.reddy@gmail.com','Vikram Reddy','vikram123','9845678901',_binary '\0'),(10,'Ahmedabad','meena.patel@gmail.com','Meena Patel','meena123','9897654321',_binary '\0'),(11,'Lucknow','anil.yadav@gmail.com','Anil Yadav','anil123','9798123456',_binary '\0'),(12,'Bhopal','divya.mishra@gmail.com','Divya Mishra','divya123','9823098765',_binary '\0'),(13,'Surat','rohan.desai@gmail.com','Rohan Desai','rohan123','9812340987',_binary '\0'),(14,'Indore','tanya.jain@gmail.com','Tanya Jain','tanya123','9876012345',_binary '\0'),(15,'Noida','sahil.khan@gmail.com','Sahil Khan','sahil123','9801234567',_binary '\0'),(16,'Chandigarh','isha.gupta@gmail.com','Isha Gupta','isha123','9856789012',_binary '\0'),(17,'RANCHI','gagan@gmail.com','Gagan','Gagan@123','6205824474',_binary '\0');
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

-- Dump completed on 2025-11-10 23:56:31
