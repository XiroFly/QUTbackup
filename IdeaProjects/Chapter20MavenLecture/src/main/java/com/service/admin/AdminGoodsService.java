package com.service.admin;

import com.po.Goods;

import java.util.List;

public interface AdminGoodsService {
    List<Goods> findGoodsByPage(Integer pageSize, Integer pageCur);

    Integer findGoodsCount();
}
