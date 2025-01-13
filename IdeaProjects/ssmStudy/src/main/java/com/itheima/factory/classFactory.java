package com.itheima.factory;

import com.itheima.dao.impl.myDaoimpl;
import com.itheima.dao.myDao;
import org.springframework.beans.factory.FactoryBean;

public class classFactory implements FactoryBean<myDao>{

    @Override
    public myDao getObject() throws Exception {
        return new myDaoimpl();
    }

    @Override
    public Class<?> getObjectType() {
        return myDao.class;
    }

}
