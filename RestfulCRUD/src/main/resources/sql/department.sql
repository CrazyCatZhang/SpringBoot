DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `departmentId` int(10) NOT NULL AUTO_INCREMENT,
  `departmentName` varchar(50) NOT NULL,
  PRIMARY KEY (`departmentId`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;

INSERT INTO `department` VALUES ('101', 'TechnicalDepartment');
INSERT INTO `department` VALUES ('102', 'PromotionDepartment');
INSERT INTO `department` VALUES ('103', 'CustomerServiceDepartment');
INSERT INTO `department` VALUES ('104', 'AdministrationDepartment');
INSERT INTO `department` VALUES ('105', 'FinanceDepartment');