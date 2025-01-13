package com.service.admin;

import com.dao.admin.AdminDao;
import com.po.AUser;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AdminServiceImpl implements AdminService{

    @Resource(name="adminDao")
    AdminDao adminDao;

    @Override
    public boolean isLogined(AUser aUser) {
        Integer rst = adminDao.findAUserCount(aUser);
        if(rst == 1){
            return  true;
        }else{
            return false;
        }
    }
}
