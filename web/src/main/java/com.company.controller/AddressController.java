package com.company.controller;

import com.company.model.Address;
import com.company.service.AddressService;
import com.company.vo.AddressVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/12.
 * http://localhost:8080/web/address/add
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @RequestMapping(value = "/add")
    public String addressAdd(@Param("content") String content) {
        System.out.print("=====enter======");
        Address address = new Address();
        address.setContent(content);
        addressService.save(address);
        return "addrees/add";
    }

    @RequestMapping(value = "/list")
    public String queryAll(@ModelAttribute("addressVo") AddressVo addressVo, @ModelAttribute("addressVos") ArrayList<AddressVo> addressVos
    ,@ModelAttribute("address") Address address,@ModelAttribute("content") String content) {
        addressVos = (ArrayList)addressService.queryAll();
        addressVo = addressVos.get(0);
        address=addressVo.getAddress();
        content=address.getContent();
        return "address/list";
    }

    @RequestMapping(value = "/bind")
    public String modelAutoBind(HttpServletRequest request, Model model, Address address){
        address=addressService.queryAll().get(0).getAddress();
        model.addAttribute("address", address);
        return "address/bind";
    }
}
