package service;

import bean.vo.GoodsVo;

import java.util.List;
import java.util.Map;

public interface GoodsService {
    List<GoodsVo> getGoodsByPage(int pageNo);
    GoodsVo getGoodsById(Integer goodsId);
    int getPageCount();
    Integer saveGoods(GoodsVo newGoods);
    Integer modifyGoods(GoodsVo modifiedGoods);
    Integer deleteGoods(Integer goodsId);

    Map<Integer, Integer> getSalesByGoodsList(List<GoodsVo> goodsList);

}
