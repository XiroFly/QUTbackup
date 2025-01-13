package com.po;

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

	@Override
	public String toString() {//为了方便查看结果，重写了toString方法
		return "User [uid=" + uid +",uname=" + uname + ",usex=" + usex +"]";
	}

}
