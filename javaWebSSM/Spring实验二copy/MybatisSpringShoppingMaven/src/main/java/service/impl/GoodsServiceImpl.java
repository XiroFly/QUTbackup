package service.impl;

import bean.vo.GoodsVo;
import bean.vo.Item;
import dao.GoodsDao;
import dao.ItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.GoodsService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<GoodsVo> getGoodsByPage(int pageNo) {
        int pageSize = 2;
        int beginIndex = (pageNo - 1) * 2;
        return goodsDao.getGoodsByPage(beginIndex, pageSize);
    }

    @Override
    public GoodsVo getGoodsById(Integer goodsId) {
        return goodsDao.getGoodsById(goodsId);
    }

    @Override
    public int getPageCount() {
        return (goodsDao.getPageCount() + 1) / 2;
    }

    @Override
    public int saveGoods(GoodsVo newGoods){
        int rst = -1;
        rst = goodsDao.saveGoods(newGoods);
        return  rst;
    }

    @Override
    public int modifyGoods(GoodsVo modifiedGoods){
        int rst = -1;
        rst = goodsDao.modifyGoods(modifiedGoods);
        return  rst;
    }

    @Override
    public int deleteGoods(Integer goodsId) {
        int rst = -1;
        rst = goodsDao.deleteGoods(goodsId);
        return  rst;
    }
}
