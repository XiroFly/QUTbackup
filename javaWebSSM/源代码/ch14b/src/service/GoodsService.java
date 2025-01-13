package service;
import java.util.ArrayList;

import pojo.Goods;
public interface GoodsService {
	boolean save(Goods g);
	ArrayList<Goods> getGoods();
}
