package com.ch5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
@Repository("transactionTemplateDao")
public class TransactionTemplateDao {
	@Autowired
	//使用配置文件中的JDBC模板
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private TransactionTemplate transactionTemplate;
	String message = "";
	public String test() {
		//以匿名内部类的方式实现TransactionCallback 接口，使用默认的事务提交和回滚规则，在业务代码中不需要显式调用任何事务处理的API
		transactionTemplate.execute(new TransactionCallback<Object>(){
			@Override
			public Object doInTransaction(TransactionStatus arg0) {
				//删除表中数据
				String sql = " delete from user  ";
				//添加数据
				String sql1 = " insert into user values(?,?,?) ";
				Object param[] = {
						1,
						"陈恒",
						"男"
				};
				try{
					//先删除数据
					jdbcTemplate.update(sql);
					//添加一条数据
					jdbcTemplate.update(sql1, param);
					//添加相同的一条数据，使主键重复
					jdbcTemplate.update(sql1, param);
					message = "执行成功，没有事务回滚！";
				}catch(Exception e){
					message = "主键重复，事务回滚！";
					e.printStackTrace();
				}
				return message;
			}
		});
		return message;
	}
}
