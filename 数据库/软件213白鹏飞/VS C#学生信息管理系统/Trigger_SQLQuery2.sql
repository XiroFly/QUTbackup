--在SC表中如果修改学号会对应修改姓名
IF(OBJECT_ID('show_Sname') is not null)        -- 判断名为 show_Sname 的触发器是否存在
DROP TRIGGER show_Sname        -- 删除触发器
GO

CREATE TRIGGER show_Sname
ON SC  	         
FOR UPDATE
AS 
	declare @NEWSno NCHAR(10),
			@Sname NCHAR(10);
IF(UPDATE(学号))
	BEGIN
	SELECT @NEWSno =学号 FROM INSERTED
	SELECT @Sname =姓名 FROM Student WHERE 学号=@NEWSno
	UPDATE SC SET 姓名=@Sname WHERE 学号=@NEWSno

END;

--在SC表中如果修改课程号会对应修改课程名
IF(OBJECT_ID('show_Cname') is not null)        -- 判断名为 show_Cname 的触发器是否存在
DROP TRIGGER show_Cname        -- 删除触发器
GO

CREATE TRIGGER show_Cname
ON SC  	         
FOR UPDATE
AS 
	declare @NEWCno NCHAR(10),
			@Cname NCHAR(10),
			@credit SMALLINT;
IF(UPDATE(课程号))
	BEGIN
	SELECT @NEWCno =课程号 FROM INSERTED
	SELECT @Cname =课程名 FROM Course WHERE 课程号=@NEWCno
	SELECT @credit = 学分 FROM Course WHERE 课程号=@NEWCno
	UPDATE SC SET 课程名=@Cname WHERE 课程号=@NEWCno
	UPDATE SC SET 学分=@credit WHERE 课程号=@NEWCno AND 成绩>=60
	UPDATE SC SET 学分=0 WHERE 课程号=@NEWCno AND 成绩<60

END;

--在SC表中如果修改成绩，成绩大于60时，学分获得，否则为0
IF(OBJECT_ID('show_credit') is not null)        -- 判断名为 show_credit 的触发器是否存在
DROP TRIGGER show_credit        -- 删除触发器
GO

CREATE TRIGGER show_credit
ON SC  	         
FOR UPDATE
AS 
	declare @NEWgrade SMALLINT,
			@Sno NCHAR(10),
			@Cno NCHAR(10),
			@credit SMALLINT;
IF(UPDATE(成绩))
	BEGIN
	SELECT @NEWgrade = 成绩 FROM INSERTED
	SELECT @Sno = 学号 FROM DELETED
	SELECT @Cno = 课程号 FROM DELETED 
	SELECT @credit  =学分 FROM Course WHERE 课程号=@Cno
	UPDATE SC SET 学分=0 WHERE 课程号=@Cno AND 成绩<60
	UPDATE SC SET 学分=@credit WHERE 课程号=@Cno AND 成绩>=60

END;

--在Course表中如果修改学分，SC表中的对应学分也要修改
IF(OBJECT_ID('change_credit') is not null)        -- 判断名为 change_credit 的触发器是否存在
DROP TRIGGER change_credit        -- 删除触发器
GO
CREATE TRIGGER change_credit
ON Course  	         
FOR UPDATE
AS 
	declare @Cno NCHAR(10),
			@credit SMALLINT;
IF(UPDATE(学分))
	BEGIN
	SELECT @Cno = 课程号 FROM DELETED 
	SELECT @credit  =学分 FROM INSERTED
	UPDATE SC SET 学分=0 WHERE 课程号=@Cno AND 成绩<60
	UPDATE SC SET 学分=@credit WHERE 课程号=@Cno AND 成绩>=60

END;