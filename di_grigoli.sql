-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: di_grigoli
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
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categories` (
  `CAT_ID` int NOT NULL AUTO_INCREMENT,
  `CAT_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`CAT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Pizza'),(2,'Hamburger'),(3,'Fish'),(4,'Desserts & Shakes'),(5,'Fruit Salad'),(6,'Beverage');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food` (
  `FOOD_ID` int NOT NULL AUTO_INCREMENT,
  `CAT_ID` int DEFAULT NULL,
  `FOOD_NAME` varchar(50) DEFAULT NULL,
  `FOOD_DESCR` varchar(1000) DEFAULT NULL,
  `FOOD_PRICE` float DEFAULT NULL,
  PRIMARY KEY (`FOOD_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food`
--

LOCK TABLES `food` WRITE;
/*!40000 ALTER TABLE `food` DISABLE KEYS */;
INSERT INTO `food` VALUES (1,1,'Margherita','Tomato Sauce, Mozzarella',3.5),(3,1,'Funghi','Tomato Sauce, Mozzarella, Mushrooms',4),(4,1,'Capricciosa','Tomato Sauce, Mozzarella, Mushrooms, Mam, Eggs, Artichoke, Cocktail Sausages, Olives',4.5),(5,1,'Quattro Stagioni','Tomato Sauce, Mozzarella, Ham, Black Olives, Mushrooms, Artichoke, Eggs',5),(6,1,'Romana','Tomato, Mozzarella, Ham, Oregano, Oil',4),(7,2,'Cheeseburger','Regular Bun, 100% Beef Patty, American Cheese, Ketchup, Pickle Slices, Onions, Mustard',5),(8,2,'Double Cheeseburger','Regular Bun, 100% Beef Patty, American Cheese, Ketchup, Pickle Slices, Onions, Grill Seasoning',6),(9,2,'Quarter Pounder','Quarter Pound Bun, Quarter Pound 100% Beef Patty, American Cheese, Ketchup, Pickle Slices, Onions, Mustard, Grill Seasoning',8),(10,2,'Crispy Chicken','Buttermilk Crispy Chicken Fillet, Artisan Roll, Roma Tomato, Premium Lettuce, Mayonnaise',6.5),(11,3,'The Shellfish Tower','Maine Lobster, Shrimp (6), Oysters (6), Jumbo Lump Crab',20),(12,3,'Chilled Gulf Shrimp','Cocktail Style with Atomic Horseradish and Spicy Mustard',15),(13,3,'Bacon Wrapped Filets','\"Oscar\" Style with Alaskan King Crab, Grilled Asparagus and Béarnaise',18),(14,3,'Georges Bank Scallops','Sautéed with Citrus Fruit, Roasted Almonds and Brown Butter',16.5),(15,3,'Kung Pao Calamari','Wok-Fried Vegetables with Roasted Cashews',17.5),(16,3,'Jumbo Gulf Shrimp','Oven-roasted with Jumbo Lump Crab, Herbs and Garlic',16.5),(17,4,'Vanilla Cone','Enjoy a treat made with sweet, creamy vanilla soft serve in a crispy cone',2),(18,4,'Hot Fudge Sundae','A classic hot fudge sundae made with vanilla soft serve, smothered in chocolaty hot fudge topping',3),(19,4,'Hot Caramel Sundae','Our Hot Caramel Sundae combines cool and creamy vanilla soft serve with warm, rich, buttery caramel topping',3),(20,4,'Strawberry Sundae','A delicious Strawberry Sundae made with creamy vanilla soft serve topped with sliced strawberries in a sweet and tart strawberry topping',3.5),(21,4,'Chocolate Shake','A delicious chocolate dessert made with our creamy vanilla soft serve and chocolate syrup, topped with whipped topping',3.5),(22,5,'Hawaiian','Fresh Lime Juice, Honey, Finely Chopped Fresh Ginger or Ground Ginger, Bite-Sized Pieces Fruit',3),(23,5,'Mojito','Watermelon, Strawberries,  Raspberries, Blueberries, Mint, Fresh Lime Juic',3.5),(24,5,'Rainbow ','Strawberries, Pineapple, Blueberries, Red Grapes, Kiwis, Mandarin Oranges, Bananas',3.5),(25,5,'Winter','Fresh Lemon Juice, Granulated Sugar, Olive Oil, Vegetable Oil, Honey, Poppy Seeds',3),(26,5,'Skinny Ambrosia','Pineapple Chunks, Green Grapes, Strawberry, Blueberries, Mandarin Oranges, Greek Yogurt, Sugar, Vanilla',3.5),(27,6,'Coca-Cola','A cold and refreshing complement to all of our menu items.',2),(28,6,'Sprite','Fountain drink has a delicious lemon-lime taste',2),(29,6,'Fanta','Caffeine-free Fanta Orange full of bubbly, refreshing orange flavor',2),(30,6,'Acqua','0.5L bottle of water',1),(31,6,'Iced Tea','Freshly brewed with a brisk blend of orange pekoe and pekoe cut black tea, served ice cold.',2.5);
/*!40000 ALTER TABLE `food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `ORD_ID` int NOT NULL AUTO_INCREMENT,
  `ORD_DATE` date DEFAULT NULL,
  `ORD_TIME` time DEFAULT NULL,
  `USR_EMAIL` varchar(50) DEFAULT NULL,
  `ORD_TYPE` varchar(1) DEFAULT NULL,
  `ORD_BOOKINGDATE` date DEFAULT NULL,
  `ORD_DETAILS` varchar(1000) DEFAULT NULL,
  `ORD_TOTAL` float DEFAULT NULL,
  `ORD_NOTE` varchar(1000) DEFAULT 'none',
  `ORD_COMPLETED` varchar(1) DEFAULT 'N',
  PRIMARY KEY (`ORD_ID`),
  KEY `USR_EMAIL_idx` (`USR_EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2020-06-13','09:00:00','carlo@gmail.com','K','2020-06-13','Pizza Margherita',3.5,'Umbrella id 2','N'),(2,'2020-06-14','12:00:00','silvia@gmail.com','U','2020-06-15','1',15,'none','N'),(3,'2020-06-14','12:00:00','silvia@gmail.com','K','2020-06-14','Fruit salad',4.25,'Umbrella id 3','Y'),(4,'2020-06-15','13:00:00','carlo@gmail.com','K','2020-06-15','Ice Cream Chocolate',3.6,'Umbrella id 6','Y'),(5,'2020-06-16','11:00:00','carlo@gmail.com','K','2020-06-16','Ceres',5,'Umbrella ID 4','Y'),(6,'2020-06-16','11:00:00','carlo@gmail.com','K','2020-06-16','Ceres',15,'none','Y'),(7,'2020-06-16','15:00:00','silvia@gmail.com','K','2020-06-16','Pizza Margherita',12.2,'none','Y'),(8,'2020-06-16','11:00:00','carlo@gmail.com','K','2020-06-16','Fruit Salad',11,'none','N'),(9,'2020-06-16','11:05:00','carlo@gmail.com','K','2020-06-16','Fruit Salad',11,'none','N'),(10,'2020-06-16','12:05:00','reno@gmail.com','K','2020-06-16','Fruit Salad',11,'none','N'),(11,'2020-06-16','12:00:00','reno@gmail.com','U','2020-06-17','3',15,'none','N'),(12,'2020-06-18','16:00:00','reno@gmail.com','U','2020-06-20','1',15,'we will arrive at 10am','Y'),(14,'2020-10-10','17:57:42','carlo@gmail.com','U','2020-10-10','1',15,'','Y'),(15,'2020-06-18','18:05:58','carlo@gmail.com','U','2020-06-18','1',15,'','Y'),(16,'2020-06-18','18:06:38','carlo@gmail.com','U','2020-06-18','1',15,'','Y'),(28,'2020-06-20','11:04:17','carlo@gmail.com','K','2020-06-20','Quarter Pounder; ',23,'','N'),(29,'2020-06-20','11:05:29','carlo@gmail.com','K','2020-06-20','Margherita; Cheeseburger; Double Cheeseburger; Quarter Pounder; ',23,'','N'),(30,'2020-06-20','11:35:19','carlo@gmail.com','K','2020-06-20','Margherita; Cheeseburger; Double Cheeseburger; Quarter Pounder; ',22.5,'','N'),(31,'2020-06-20','11:59:44','carlo@gmail.com','K','2020-06-20','Margherita; Cheeseburger; Double Cheeseburger; Quarter Pounder; ',22.5,'','N'),(32,'2020-06-20','12:15:03','carlo@gmail.com','K','2020-06-20','Cheeseburger; Double Cheeseburger; ',22.5,'','N'),(33,'2020-06-20','12:30:31','carlo@gmail.com','K','2020-06-20','Romana; ',15.5,'','N'),(34,'2020-06-20','12:32:21','carlo@gmail.com','K','2020-06-20','Margherita; Funghi; Quattro Stagioni; Romana; Crispy Chicken; ',23,'','N'),(35,'2020-06-20','12:44:17','carlo@gmail.com','K','2020-06-20','Margherita; Capricciosa; ',8,'','N'),(36,'2020-06-23','12:47:55','carlo@gmail.com','U','2020-06-23','5',15,'','Y'),(37,'2020-06-23','15:00:02','carlo@gmail.com','U','2020-06-23','6',10,'','Y'),(38,'2020-06-23','17:41:08','carlo@gmail.com','U','2020-06-23','2',15,'','Y'),(39,'2020-06-23','18:17:21','admin@gmail.com','K','2020-06-23','Capricciosa; ',4.5,'','N'),(40,'2020-06-23','18:29:59','admin@gmail.com','K','2020-06-23','Margherita; Margherita; Margherita; Vanilla Cone; ',12.5,'','N'),(41,'2020-06-24','00:42:31','carlo@gmail.com','K','2020-06-24','Vanilla Cone; ',2,'','Y'),(42,'2020-06-24','00:44:28','carlo@gmail.com','K','2020-06-24','Margherita; ',3.5,'','N'),(43,'2020-06-24','00:45:24','carlo@gmail.com','K','2020-06-24','Margherita; ',3.5,'','N'),(44,'2020-06-24','00:46:21','carlo@gmail.com','K','2020-06-24','Margherita; ',3.5,'','N'),(46,'2020-06-25','13:10:07','carlo@gmail.com','U','2020-06-25','15',7,'','Y'),(47,'2020-06-25','15:30:09','salvo@gmail.com','U','2020-06-30','8',10,'','Y'),(48,'2020-06-25','15:38:26','salvo@gmail.com','K','2020-06-25','Vanilla Cone; Hot Fudge Sundae; Hot Caramel Sundae; ',8,'','Y'),(49,'2020-06-25','15:39:27','salvo@gmail.com','K','2020-06-25','Vanilla Cone; Hot Fudge Sundae; Hot Caramel Sundae; ',8,'','Y');
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `ROLE_ID` varchar(2) NOT NULL,
  `ROLE_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES ('A','Admin'),('C','Customer'),('K','Kitchen'),('LG','Lifeguard');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `umbrellas`
--

DROP TABLE IF EXISTS `umbrellas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `umbrellas` (
  `UMB_ID` int NOT NULL AUTO_INCREMENT,
  `UMB_ROW` int DEFAULT NULL,
  `UMB_PLACE` int DEFAULT NULL,
  `UMB_PRICE` float DEFAULT NULL,
  PRIMARY KEY (`UMB_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `umbrellas`
--

LOCK TABLES `umbrellas` WRITE;
/*!40000 ALTER TABLE `umbrellas` DISABLE KEYS */;
INSERT INTO `umbrellas` VALUES (1,1,1,15),(2,1,2,15),(3,1,3,15),(4,1,4,15),(5,1,5,15),(6,2,1,10),(7,2,2,10),(8,2,3,10),(9,2,4,10),(10,2,5,10),(11,3,1,7),(12,3,2,7),(13,3,3,7),(14,3,4,7),(15,3,5,7);
/*!40000 ALTER TABLE `umbrellas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `USR_EMAIL` varchar(100) NOT NULL,
  `USR_PASSWORD` varchar(50) DEFAULT NULL,
  `USR_FIRSTNAME` varchar(100) DEFAULT NULL,
  `USR_LASTNAME` varchar(100) DEFAULT NULL,
  `ROLE_ID` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`USR_EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin@gmail.com','adminpassword','Vito','Di Grigoli','A'),('carlo@gmail.com','carlopassword','Carlo','Insinna','C'),('danilo@gmail.com','danilopassword','Danilo','Sammartano','LG'),('gaspare@gmail.com','gasparepassword','Gaspare','Piazza','C'),('giovanni@gmail.com','giovannipassword','Giovanni','Lena','C'),('michele@gmail.com','michelepassword','Michele','Insinna','C'),('reno@gmail.com','renopassword','Reno','Maita','K'),('riccardo@gmail.com','riccardopassword','Riccardo','Prezioso','A'),('salvo@gmail.com','salvo','Salvo','Catanzaro','C'),('silvia@gmail.com','silviapassword','Silvia','Di Grigoli','U');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-25 16:19:12
