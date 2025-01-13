package service;

import bean.vo.GoodsVo;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<GoodsVo> getGoodsByPage(int pageNo);
    GoodsVo getGoodsById(Integer goodsId);
    int getPageCount();
    int saveGoods(GoodsVo newGoods);
    int modifyGoods(GoodsVo modifiedGoods);
    int deleteGoods(Integer goodsId);
}