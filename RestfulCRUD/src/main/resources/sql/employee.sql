DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employeeId` int(10) NOT NULL AUTO_INCREMENT,
  `lastName` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `gender` tinyint(2) NOT NULL DEFAULT '1' COMMENT '0:男\r\n1：女',
  `birth` date NOT NULL,
  `department` int(10) DEFAULT NULL,
  PRIMARY KEY (`employeeID`),
  KEY `dept` (`department`),
  CONSTRAINT `dept` FOREIGN KEY (`department`) REFERENCES `department` (`departmentId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8;

INSERT INTO `employee` VALUES ('1001', 'AA01', '1001@j.com', '1', '2019-08-12', '101');
INSERT INTO `employee` VALUES ('1002', 'BB02', '1002@j.com', '1', '2019-08-17', '102');
INSERT INTO `employee` VALUES ('1003', 'CC03', '1003@j.com', '1', '2019-08-05', '103');
INSERT INTO `employee` VALUES ('1004', 'CC04', '1004@j.com', '0', '2019-08-12', '103');
INSERT INTO `employee` VALUES ('1005', 'DD05', '1066@qq.com', '1', '1997-10-07', '102');