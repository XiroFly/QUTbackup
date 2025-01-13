package com.statement.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.statement.service.TestService;
@Controller("statementController")
public class StatementController {
	@Autowired
	private TestService testService;
	public String test() {
		String message = "";
		String deleteSql ="delete from user";
		String saveSql = "insert into user values(?,?,?)";
		Object param[] = {1,"chenheng","男"};
		try{
			testService.delete(deleteSql, null);
			testService.save(saveSql, param);
			//插入两条主键重复的数据
			testService.save(saveSql, param);
		}catch(Exception e){
			message = "主键重复，事务回滚！";
			e.printStackTrace();
		}
		return message;
	}
}
