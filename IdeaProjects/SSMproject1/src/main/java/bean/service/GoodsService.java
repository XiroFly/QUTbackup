package bean.service;

import bean.vo.GoodsVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
public interface GoodsService {
    public ArrayList getGoodsByPage(int pageNo ,int numPerPage);


    public GoodsVo getGoodsById(int goodsId);

    public int getPageCount();
    public void add( GoodsVo single);
    public void delete(int goodsId);
    public void modify(GoodsVo single);

}
