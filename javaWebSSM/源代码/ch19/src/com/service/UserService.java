package com.service;
import java.util.List;
import com.po.MyUser;
public interface UserService {
	public List<MyUser> selectUserByUname(MyUser user);
}
