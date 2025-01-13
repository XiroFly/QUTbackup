package com.service.admin;

import com.dao.admin.AdminGoodsTypeDao;
import com.po.GoodsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminGoodsTypeServiceImpl implements AdminGoodsTypeService{
    @Autowired
    AdminGoodsTypeDao adminGoodsTypeDao;

    @Override
    public List<GoodsType> findAllGoodsTypes() {
        return adminGoodsTypeDao.findAllGoodsTypes();
    }
}
