package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.GoodsModel;
@Controller
@RequestMapping("/my")
public class ConverterController {
	@RequestMapping("/converter")
	/*使用@RequestParam("goods")接收请求参数，
	然后调用自定义类型转换器GoodsConverter将字符串值转换为GoodsModel的对象gm
	*/
	public String myConverter(@RequestParam("goods") GoodsModel gm, Model model){
		model.addAttribute("goods",gm);
		return "showGoods";
	}
}
