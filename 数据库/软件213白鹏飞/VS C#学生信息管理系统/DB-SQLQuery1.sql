DROP DATABASE IF EXISTS student_information_management_system;  

CREATE DATABASE student_information_management_system;  

USE student_information_management_system;

DROP TABLE IF EXISTS Student
DROP TABLE IF EXISTS Manage
DROP TABLE IF EXISTS Course
DROP TABLE IF EXISTS SC

CREATE TABLE Student          
 (	
 学号 NCHAR(10) PRIMARY KEY NOT NULL,        /* 列级完整性约束条件,学号是主码*/                  
 姓名 NCHAR(10) NOT NULL,          
 性别 NCHAR(2) CHECK(性别 IN ('男','女')) NOT NULL,
 出生日期 CHAR(10),
 民族 NCHAR(10),
 专业 NCHAR(20) NOT NULL,
 年级 NCHAR(4) NOT NULL,
 籍贯 NCHAR(25),
 手机号码 CHAR(11)NOT NULL,
 密码 NCHAR(35) NOT NULL,
 ); 

 CREATE TABLE Manage          
 (	
 工号 NCHAR(10) PRIMARY KEY NOT NULL,        /* 列级完整性约束条件,学号是主码*/                  
 姓名 NCHAR(10) NOT NULL,          
 性别 NCHAR(2) CHECK(性别 IN ('男','女'))NOT NULL,
 出生日期 NCHAR(10),
 籍贯 NCHAR(25),
 手机号码 CHAR(11)NOT NULL,
 民族 NCHAR(10),
 密码 NCHAR(35) NOT NULL,
 ); 

 CREATE TABLE  Course
 (	
 课程号 NCHAR(10) PRIMARY KEY NOT NULL,
 课程名 NCHAR(10) NOT NULL,            
 学分 SMALLINT NOT NULL,               	                      
 上课地点 NCHAR(20) NOT NULL,
 上课时间 NCHAR(20)NOT NULL 
 ); 

 CREATE TABLE  SC
 (
 学号 NCHAR(10) NOT NULL, 
 姓名 NCHAR(10),
 课程号 NCHAR(10)NOT NULL,
 课程名 NCHAR(10),
 成绩 SMALLINT CHECK(成绩>=0 AND 成绩<=100),
 学分 SMALLINT ,
 PRIMARY KEY (学号,课程号),                     /* 主码由两个属性构成，必须作为表级完整性进行定义*/
 FOREIGN KEY (学号) REFERENCES Student(学号),  /* 表级完整性约束条件，学号是外码，被参照表是Student */
 FOREIGN KEY (课程号)REFERENCES Course(课程号),     /* 表级完整性约束条件， 工号是外码，被参照表是Course*/
 ); 

INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115121','李勇','男','2003-11-03','汉族','数学信息专业','18','北京市','123123213','41b2e380f4ee72d92e4e1b61672d07ed');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115122','刘晨','男','2001-01-03','汉族','网络安全专业','18','上海市','1231232222','4fe3a5afd4d66bc2768870421bef6d80');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115123','佟露露','女','1998-02-13','汉族','生命科学专业','16','福建省','1231239873','aed333517421ba701dcfeaf3ee0da619');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115124','王敏','女','1999-07-30','汉族','通信专业','17','河北省','1231239803','5c15d3390d851205843a7e2c3a3a3d12');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115125','张丽','女','2001-04-21','汉族','航空航天专业','19','江西省','1231234563','f5579fdd1b92e1cecbe534a5e74cecfd');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115126','张扉','男','2000-06-30','汉族','计算机科学与技术专业','18','北京市','1232342213','9f83c11348a0a3a6259963823be1870f');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115127','顾依凉','男','2000-08-20','汉族','生命科学专业','18','贵州省','1231276513','b98a4565eb67c24a9481eb96d202d0e5');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115128','白雪','女','2001-03-23','汉族','通信专业','19','黑龙江省','1311232213','206111b43716ab18328809c64bef1fff');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115129','赵岑','男','2001-04-19','汉族','计算机科学与技术专业','19','吉林省','1345232213','cfb159592100391fce3640ce840dcd3d');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115120','林琳','女','2000-03-09','汉族','生命科学专业','18','四川省','1239802213','4c81c88cd7709d8b28d558c8f8af22d2');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115130','宋言','男','2002-07-03','汉族','航空航天专业','19','安徽','1234562213','415dfeb3e03aa46004ba95342897e702');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115131','卫琬','女','2000-11-03','汉族','通信专业','18','江西省','1231098713','039552cd56eb9fb800416d384052a0b0');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115132','韩晓梦','女','2000-12-09','汉族','数学信息专业','18','黑龙江省','1231342313','a2f5e908f5e96a9e44fea614fc3c0837');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115133','李祁','男','2000-08-17','汉族','计算机科学与技术专业','18','北京市','1239872213','40325844eaa57b823e4cc8f524ac43e7');
INSERT  INTO  Student(学号,姓名,性别,出生日期,民族,专业,年级,籍贯,手机号码,密码) VALUES ('202115134','郑颂雨','男','2002-06-12','汉族','生命科学专业','18','四川省','1231000213','6a9a16592c30de3aed9cb898886b2a6c');

SELECT * FROM Student

INSERT  INTO  Manage(工号,姓名,性别,出生日期,籍贯,手机号码,民族,密码) VALUES ('202103','张珊','女','1982-01-01','四川省','13812345678','汉族','9365f8127adaa91c6ed8433cd9f32c24');
INSERT  INTO  Manage(工号,姓名,性别,出生日期,籍贯,手机号码,民族,密码) VALUES ('202104','李姒','女','1993-11-01','江西省','13898762312','汉族','d01bb7551d54d9c0806d79233b6fe10b');
INSERT  INTO  Manage(工号,姓名,性别,出生日期,籍贯,手机号码,民族,密码) VALUES ('202105','王武','男','1989-02-01','黑龙江省','13154342378','汉族','205ded2984e1daf6e3b9373767e8bf6e');
INSERT  INTO  Manage(工号,姓名,性别,出生日期,籍贯,手机号码,民族,密码) VALUES ('202106','钱珥','女','1982-01-01','安徽','13819334328','汉族','2d0cac1b87699da50b07937dcee15a05');
INSERT  INTO  Manage(工号,姓名,性别,出生日期,籍贯,手机号码,民族,密码) VALUES ('202107','赵依','女','1993-11-01','江西省','13898762312','汉族','28689f39401b4eaa9fc79efde978ca11');
INSERT  INTO  Manage(工号,姓名,性别,出生日期,籍贯,手机号码,民族,密码) VALUES ('202108','孙柳','男','1987-05-16','上海市','13159877348','汉族','bef90937301f701a5c39280d255e9e86');
SELECT * FROM Manage

INSERT  INTO Course(课程号,课程名,学分,上课地点,上课时间)VALUES ('1','数据库',4,'一教101','周二7-9节');
INSERT  INTO Course(课程号,课程名,学分,上课地点,上课时间)VALUES ('2','高等数学',2,'三教212','周一1-4节');
INSERT  INTO Course(课程号,课程名,学分,上课地点,上课时间)VALUES ('3','信息系统',2,'二教103','周三7-9节');
INSERT  INTO Course(课程号,课程名,学分,上课地点,上课时间)VALUES ('4','操作系统',1,'一教601','周二1-2节');
INSERT  INTO Course(课程号,课程名,学分,上课地点,上课时间)VALUES ('5','数据结构',3,'三教101','周五5-6节');
INSERT  INTO Course(课程号,课程名,学分,上课地点,上课时间)VALUES ('6','数据处理',2,'二教211','周四2-4节');
INSERT  INTO Course(课程号,课程名,学分,上课地点,上课时间)VALUES ('7','Pascal语言',4,'一教101','周三3-4节');
SELECT * FROM Course


INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115122 ','刘晨','1','数据库',80,4);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115123 ','佟露露','1','数据库',60,4);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115126 ','张扉','1','数据库',70,4);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115129 ','赵岑','1','数据库',97,4);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115131 ','卫琬','1','数据库',84,4);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115134 ','郑颂雨','2','高等数学',88,2);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115121 ','李勇','2','高等数学',56,0);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115125 ','张丽','2','高等数学',70,2);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115127 ','顾依凉','2','高等数学',77,2);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115133 ','李祁','2','高等数学',84,2);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115124 ','王敏','3','信息系统',88,2);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115128 ','白雪','4','操作系统',56,0);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115120 ','林琳','5','数据结构',70,3);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115130 ','宋言','6','数据处理',77,2);
INSERT  INTO SC(学号,姓名,课程号,课程名,成绩,学分) VALUES ('202115132 ','白鹏飞','7','Pascal语言',84,4);
UPDATE SC SET 学分=0 WHERE 成绩<60
SELECT * FROM SC
