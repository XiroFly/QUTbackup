package com.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.dao.OrdersDao;
import com.po.Orders;
@Controller("moreToMoreController")
public class MoreToMoreController {
	@Autowired
	private OrdersDao ordersDao;
	public void test() {
		List<Orders> os = ordersDao.selectallOrdersAndProducts();
		for (Orders orders : os) {
			System.out.println(orders);
		}
	}
}
