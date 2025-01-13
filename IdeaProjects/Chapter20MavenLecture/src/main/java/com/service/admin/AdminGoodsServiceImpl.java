package com.service.admin;

import com.dao.admin.AdminGoodsDao;
import com.po.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminGoodsServiceImpl implements AdminGoodsService{
    @Resource(name="adminGoodsDao")
    AdminGoodsDao adminGoodsDao;

    @Override
    public List<Goods> findGoodsByPage(Integer pageSize, Integer pageCur) {
        //SELECT * FROM TABLE limit BEGIN,PAGESIZE
        Integer begin = (pageCur - 1)* pageSize;//1-0,2-2

        Map params = new HashMap();
        params.put("begin",begin);
        params.put("pageSize",pageSize);

        return adminGoodsDao.findGoodsByPage(params);
    }

    @Override
    public Integer findGoodsCount() {
        return adminGoodsDao.findGoodsCount();
    }
}
