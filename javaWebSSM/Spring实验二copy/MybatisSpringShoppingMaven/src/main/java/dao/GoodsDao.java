package dao;

import bean.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface GoodsDao {
    List<GoodsVo> getGoodsByPage(@Param("beginIndex")int beginIndex, @Param("pageSize")int pageSize);
    GoodsVo getGoodsById(Integer goodsId);
    int getPageCount();
    int saveGoods(GoodsVo newGoods);
    int modifyGoods(GoodsVo modifiedGoods);
    int deleteGoods(Integer goodsId);
}
