package com.po;

import java.util.List;

/**
 *springtest数据库中user表的持久化类
 */
public class MyUser {
	private Integer uid;//主键
	private String uname;
	private String usex;
	//一对多关联查询，用户关联的订单
	private List<Orders> ordersList;
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
	public List<Orders> getOrdersList() {
		return ordersList;
	}
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid +",uname=" + uname + ",usex=" + usex + ",ordersList=" + ordersList +"]";
	}
}
