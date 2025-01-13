package com.dao;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.MyUser;
@Repository("userDao")
@Mapper
/*使用Spring自动扫描MyBatis的接口并装配
（Spring将指定包中所有被@Mapper注解标注的接口自动装配为MyBatis的映射接口*/
public interface UserDao {
	/**
	 * 接口方法对应SQL映射文件UserMapper.xml中的id
	 */
	public MyUser selectUserById(Integer uid);
	public List<MyUser> selectAllUser();
	public int addUser(MyUser user);
	public int updateUser(MyUser user);
	public int deleteUser(Integer uid);
	public  List<MyUser> selectUserByIf(MyUser user);
	public List<MyUser> selectUserByChoose(MyUser user);
	public List<MyUser> selectUserByTrim(MyUser user);
	public List<MyUser> selectUserByWhere(MyUser user);
	public int updateUserBySet(MyUser user);
	public  List<MyUser> selectUserByForeach(List<Integer> listId);
	public  List<MyUser> selectUserByBind(MyUser user);
}
