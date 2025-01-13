package com.controller.admin;

import com.po.Goods;
import com.po.GoodsType;
import com.service.admin.AdminGoodsService;
import com.service.admin.AdminGoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/adminGoods")
public class AdminGoodsController {

    @Autowired
    AdminGoodsService adminGoodsService;

    @Autowired
    AdminGoodsTypeService adminGoodsTypeService;

    @RequestMapping("/selectGoods")
    public String selectGoods(Integer pageCur, Model model){
        if(pageCur == null)
            pageCur = 1;
        Integer pageSize = 2;

        List<Goods> goodsList =
                adminGoodsService.findGoodsByPage(pageSize,pageCur);

        Integer totalCount = adminGoodsService.findGoodsCount();
        Integer totalPage = (totalCount-1)/pageSize +1;//2-1,3-2,4-2

        model.addAttribute("totalCount",totalCount);
        model.addAttribute("totalPage",totalPage);
        model.addAttribute("allGoods",goodsList);
        model.addAttribute("pageCur",pageCur);

        return "admin/selectGoods";
    }

    @RequestMapping("/toAddGoods")
    public String toAddGoods(@ModelAttribute Goods goods,
                             Model model){
        List<GoodsType> goodsTypeList =
                adminGoodsTypeService.findAllGoodsTypes();

        model.addAttribute("goodsTypeList",goodsTypeList);
        return  "admin/addGoods";
    }

    @RequestMapping("/addGoods")
    public String addGoods(Goods goods,
            Integer goodstype_id,
                      MultipartFile logoImage){
        return "";
    }
}
