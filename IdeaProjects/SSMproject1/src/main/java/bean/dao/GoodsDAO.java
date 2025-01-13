package bean.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.DBBean;
import bean.vo.GoodsVo;

public interface GoodsDAO {
	public List<GoodsVo> getGoodsByPage(Object param[]);

	
	public GoodsVo getGoodsById(int goodsId);

	public int getPageCount();
	public void add(GoodsVo single);
	public void delete(int goodsId);
	public void modify(GoodsVo single);

}
