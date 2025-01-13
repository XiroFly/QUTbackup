package service.impl;

import bean.vo.GoodsVo;
import dao.GoodsDAO;
import org.springframework.stereotype.Service;
import service.GoodsService;

import javax.annotation.Resource;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {

    @Resource(name="goodsDao")
    GoodsDAO goodsDAO;

    @Override
    public List<GoodsVo> getGoodsByPage(int pageNo) {
        return goodsDAO.getGoodsByPage(pageNo);
    }

    @Override
    public GoodsVo getGoodsById(Integer goodsId) {
        return goodsDAO.getGoodsById(goodsId);
    }

    @Override
    public int getPageCount() {
        return goodsDAO.getPageCount();
    }

    @Override
    public Integer saveGoods(GoodsVo newGoods){
        int rst = -1;
        rst = goodsDAO.saveGoods(newGoods);
        return  rst;
    }

    @Override
    public Integer modifyGoods(GoodsVo modifiedGoods){
        int rst = -1;
        rst = goodsDAO.modifyGoods(modifiedGoods);
        return  rst;
    }

    @Override
    public Integer deleteGoods(Integer goodsId) {
        int rst = -1;
        rst = goodsDAO.deleteGoods(goodsId);
        return  rst;
    }
}
