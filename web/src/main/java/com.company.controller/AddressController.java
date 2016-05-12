package com.company.controller;

import com.company.model.Address;
import com.company.service.AddressService;
import com.company.vo.AddressVo;
import net.sf.json.util.JSONUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    public String addressAdd(@Param("address") Address address, Model model) {
        addressService.save(address);
        //queryAll(model);
        return "address/list";
    }

    @RequestMapping(value = "/list")
    @ResponseBody
    public List<AddressVo> queryAll(@RequestParam("content") String content) {
        List<AddressVo> addressVos = addressService.queryAll();
        return addressVos;
    }

    @RequestMapping(value = "/bind")
    public String modelAutoBind(HttpServletRequest request, Model model, Address address) {
        address = addressService.queryAll().get(0).getAddress();
        model.addAttribute("address", address);
        return "address/bind";
    }
}
