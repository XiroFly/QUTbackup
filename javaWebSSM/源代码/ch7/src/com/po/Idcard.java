package com.po;
/**
 * springtest数据库中idcard表的持久化类
 */
public class Idcard {
	private Integer id;
	private String code;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 方便测试，重写了toString方法
	 */
	@Override
	public String toString() {
		return "Idcard [id=" + id + ",code="+ code + "]";
	}
}
