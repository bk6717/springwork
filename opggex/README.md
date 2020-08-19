#reply 테이블생성

REATE TABLE `opgg`.`reply` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `postid` INT NULL,
  `userid` INT NULL,
  `reply` VARCHAR(100) NULL,
  `createDate` TIMESTAMP NULL,
  PRIMARY KEY (`id`));

  
#post 테이블생성

  CREATE TABLE `post` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `content` blob,
  `title` varchar(100) DEFAULT NULL,
  `createDate` timestamp NULL DEFAULT NULL,
  `likecount` int(11) DEFAULT NULL,
  `viewcount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8
 
 
 #user 테이블생성
 CREATE TABLE `opgg`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `createDate` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;