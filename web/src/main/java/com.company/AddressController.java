package com.company;

import com.company.model.Address;
import com.company.service.AddressService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by wb-lichao.x on 2016/4/12.
 * http://localhost:8080/web/address/add
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController {
    @Resource
    private AddressService addressService;

    @RequestMapping("/add")
    public String addressAdd(@Param("content") String content) {
        System.out.print("=====enter======");
        Address address = new Address();
        address.setContent(content);
        addressService.save(address);
        return "addres";
    }
}
