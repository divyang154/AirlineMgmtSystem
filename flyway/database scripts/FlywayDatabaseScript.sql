CREATE SCHEMA flywaydb;
USE flywaydb;
CREATE TABLE `airline_tb` (
  `airlineId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  PRIMARY KEY (`airlineId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `place_tb` (
  `placeId` int(11) NOT NULL AUTO_INCREMENT,
  `placeName` varchar(200) DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  PRIMARY KEY (`placeId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `user_tb` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) DEFAULT NULL,
  `userEmail` varchar(200) DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedBy` varchar(45) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `userRole` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `flight_tb` (
  `flightId` int(11) NOT NULL AUTO_INCREMENT,
  `sourcePlaceId` int(11) DEFAULT NULL,
  `airlineId` int(11) DEFAULT NULL,
  `price` varchar(200) DEFAULT NULL,
  `arrivalDate` date DEFAULT NULL,
  `destinationPlaceId` int(11) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  `placeId` int(11) DEFAULT NULL,
  PRIMARY KEY (`flightId`),
  KEY `sourcePlace_idx` (`sourcePlaceId`),
  KEY `airline_idx` (`airlineId`),
  KEY `destinationPlace_idx` (`destinationPlaceId`),
  KEY `FKcmba8wkwh8r12yt9h6oldpr5l` (`placeId`),
  CONSTRAINT `FKcmba8wkwh8r12yt9h6oldpr5l` FOREIGN KEY (`placeId`) REFERENCES `place_tb` (`placeid`),
  CONSTRAINT `airline` FOREIGN KEY (`airlineId`) REFERENCES `airline_tb` (`airlineid`),
  CONSTRAINT `destinationPlace` FOREIGN KEY (`destinationPlaceId`) REFERENCES `place_tb` (`placeid`),
  CONSTRAINT `sourcePlace` FOREIGN KEY (`sourcePlaceId`) REFERENCES `place_tb` (`placeid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `bookingdetail_tb` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `paymentStatus` varchar(200) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `noOfPerson` int(11) DEFAULT NULL,
  `createdOn` datetime DEFAULT NULL,
  `updatedOn` datetime DEFAULT NULL,
  `createdBy` int(11) DEFAULT NULL,
  `updatedBy` int(11) DEFAULT NULL,
  `sourcePlaceId` int(11) DEFAULT NULL,
  `flightId` int(11) DEFAULT NULL,
  `destinationPlaceId` int(11) DEFAULT NULL,
  PRIMARY KEY (`bookingId`),
  KEY `destination_key` (`sourcePlaceId`),
  KEY `flight_key` (`flightId`),
  KEY `source_key` (`destinationPlaceId`),
  KEY `bookflight_key_idx` (`userId`),
  CONSTRAINT `bookflight_key` FOREIGN KEY (`userId`) REFERENCES `user_tb` (`userid`),
  CONSTRAINT `destination_key` FOREIGN KEY (`sourcePlaceId`) REFERENCES `place_tb` (`placeid`),
  CONSTRAINT `flight_key` FOREIGN KEY (`flightId`) REFERENCES `flight_tb` (`flightid`),
  CONSTRAINT `source_key` FOREIGN KEY (`destinationPlaceId`) REFERENCES `place_tb` (`placeid`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `user_tb` (`userId`,`username`,`password`,`userEmail`,`createdBy`,`updatedBy`,`createdOn`,`updatedOn`,`userRole`) VALUES (1,'flyadmin','flyadmin@12345','flyadmin123@gmail.com',1,'1',now(),now(),'Administrator');


