package bean.service.impl;

import bean.dao.GoodsDAO;
import bean.service.GoodsService;
import bean.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
     @Autowired
    GoodsDAO goodsDAO;
    @Override
    public ArrayList<GoodsVo> getGoodsByPage(int pageNo ,int numPerPage) {
        int offset = (pageNo - 1)*numPerPage;
        //int endIndex = pageNo * 2;
        Object [] param={numPerPage,offset};//安装的是postgreSql,offset:跳过行数
        List<GoodsVo> goodsByPage = goodsDAO.getGoodsByPage(param);
        return (ArrayList<GoodsVo>) goodsByPage;
    }

    @Override
    public GoodsVo getGoodsById(int goodsId) {
       return goodsDAO.getGoodsById(goodsId);
    }

    @Override
    public int getPageCount() {
        return goodsDAO.getPageCount();
    }

    @Override
    public void add(GoodsVo single) {
        goodsDAO.add(single);
    }

    @Override
    public void delete(int goodsId) {
        goodsDAO.delete(goodsId);
    }

    @Override
    public void modify(GoodsVo single) {
       goodsDAO.modify(single);
    }

}
