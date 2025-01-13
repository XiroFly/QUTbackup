package com.dao;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.po.Idcard;
@Repository("idCardDao")
@Mapper
public interface IdCardDao {
	public Idcard selectCodeById(Integer i);
}
