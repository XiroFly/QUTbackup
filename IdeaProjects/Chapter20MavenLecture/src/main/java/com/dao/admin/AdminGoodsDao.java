package com.dao.admin;

import com.po.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminGoodsDao {
    List<Goods> findGoodsByPage(Map params);

    Integer findGoodsCount();
}
