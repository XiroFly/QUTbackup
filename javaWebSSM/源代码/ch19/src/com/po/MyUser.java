package com.po;
/**
 *springtest数据库中user表的持久化类，与持久层关联
 */
public class MyUser {
	private Integer uid;//主键
	private String uname;
	private String usex;
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUsex() {
		return usex;
	}
	public void setUsex(String usex) {
		this.usex = usex;
	}
}
