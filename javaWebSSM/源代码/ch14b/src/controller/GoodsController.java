package controller;
import javax.validation.Valid;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import pojo.Goods;
import service.GoodsService;
@Controller
@RequestMapping("/goods")
public class GoodsController {
	// 得到一个用来记录日志的对象，这样打印信息的时候能够标记打印的是那个类的信息
	private static final Log logger = LogFactory.getLog(GoodsController.class);
	@Autowired
	private GoodsService goodsService;
	@RequestMapping("/input")
	public String input(Model model){
		// 如果model中没有goods属性，addGoods.jsp会抛出异常，因为表单标签无法找到modelAttribute属性指定的form
		// backing object
		model.addAttribute("goods", new Goods());
		return "addGoods";
	}
	@RequestMapping("/save")
	public String save(@Valid @ModelAttribute Goods goods, BindingResult result, Model model){
		if(result.hasErrors()){
			return "addGoods";
		} 
		goodsService.save(goods);
		logger.info("添加成功");
		model.addAttribute("goodsList", goodsService.getGoods());
		return "goodsList";
	}
	
}
