package service.impl;

import bean.vo.GoodsVo;
import mapper.GoodsMapper;
import mapper.ItemMapper;
import mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.GoodsService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("goodsService")
@Transactional
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    ItemMapper itemMapper;
    @Autowired
    OrderMapper orderMapper;
    @Override
    public List<GoodsVo> getGoodsByPage(int pageNo) {

       return goodsMapper.getGoodsByPage(2*(pageNo-1),2);
    }

    @Override
    public GoodsVo getGoodsById(Integer goodsId) {

        return goodsMapper.getGoodsById(goodsId);
    }

    @Override
    public int getPageCount() {
      return (goodsMapper.getPageCount()+1)/2;
    }

    @Override
    public Integer saveGoods(GoodsVo newGoods){
        int rst = -1;
        rst = goodsMapper.saveGoods(newGoods);
        return  rst;
    }

    @Override
    public Integer modifyGoods(GoodsVo modifiedGoods){
        int rst = -1;
        rst = goodsMapper.modifyGoods(modifiedGoods);
        return  rst;
    }

    @Override
    public Integer deleteGoods(Integer goodsId) {
        int rst = -1;
        rst =goodsMapper.deleteGoods(goodsId);
        return  rst;
    }

    @Override
    public Map<Integer, Integer> getSalesByGoodsList(List<GoodsVo> goodsList) {
        Map<Integer,Integer> map=new HashMap<>();
         for(GoodsVo goodsVo:goodsList){
             Integer numInCart = itemMapper.selectQuantityById(goodsVo.getGoodsId());
             Integer numInOrder=orderMapper.selectQuantityByGoodsId(goodsVo.getGoodsId());
             if(numInOrder==null)numInOrder=0;
             if(numInCart==null)numInCart=0;
             map.put(goodsVo.getGoodsId(),numInCart+numInOrder);
         }
        return map;
    }
}
