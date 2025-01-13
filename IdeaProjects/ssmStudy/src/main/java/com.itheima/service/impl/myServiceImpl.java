package com.itheima.service.impl;
import com.itheima.dao.myDao;
import com.itheima.service.myService;
public class myServiceImpl implements myService{
    public void test1() {
        System.out.println("Service print");
        mydao.test1();
    }
    private myDao mydao;

    public void setMydao(myDao mydao) {
        this.mydao = mydao;
    }
}
