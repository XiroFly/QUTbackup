package service;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

import pojo.Goods;
@Service
public class GoodsServiceImpl implements GoodsService{
	//使用静态集合变量users模拟数据库
	private static ArrayList<Goods> goods = new ArrayList<Goods>();
	@Override
	public boolean save(Goods g) {
		goods.add(g);
		return true;
	}
	@Override
	public ArrayList<Goods> getGoods() {
		return goods;
	}
}
