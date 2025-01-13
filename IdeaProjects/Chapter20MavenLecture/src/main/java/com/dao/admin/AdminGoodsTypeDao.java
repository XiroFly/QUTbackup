package com.dao.admin;

import com.po.GoodsType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminGoodsTypeDao {
    List<GoodsType> findAllGoodsTypes();
}
