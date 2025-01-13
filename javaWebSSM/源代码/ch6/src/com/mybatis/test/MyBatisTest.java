package com.mybatis.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.mybatis.po.MyUser;
public class MyBatisTest {
	public static void main(String[] args) {
		try {
			//读取配置文件mybatis-config.xml
			InputStream config = Resources.getResourceAsStream("mybatis-config.xml");
			//根据配置文件构建SqlSessionFactory
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(config);
			//通过SqlSessionFactory创建SqlSession
			SqlSession ss = ssf.openSession();
			//SqlSession执行映射文件中定义的SQL，并返回映射结果
			//com.mybatis.mapper.UserMapper.selectUserById为UserMapper.xml中的命名空间+select的id
			//查询一个用户
			MyUser mu = ss.selectOne("com.mybatis.mapper.UserMapper.selectUserById", 1);
			System.out.println(mu);
			//添加一个用户
			MyUser addmu = new MyUser();
			addmu.setUname("陈恒");
			addmu.setUsex("男");
			ss.insert("com.mybatis.mapper.UserMapper.addUser",addmu);
			//修改一个用户
			MyUser updatemu = new MyUser();
			updatemu.setUid(1);
			updatemu.setUname("张三");
			updatemu.setUsex("女");
			ss.update("com.mybatis.mapper.UserMapper.updateUser", updatemu);
			//删除一个用户
			ss.delete("com.mybatis.mapper.UserMapper.deleteUser", 3);
			//查询所有用户
			List<MyUser> listMu = ss.selectList("com.mybatis.mapper.UserMapper.selectAllUser");
			for (MyUser myUser : listMu) {
				System.out.println(myUser);
			}
			//提交事务
			ss.commit();
			//关闭SqlSession
			ss.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
