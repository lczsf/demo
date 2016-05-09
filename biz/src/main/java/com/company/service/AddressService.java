package com.company.service;

import com.company.model.Address;
import com.company.vo.AddressVo;

import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/11.
 */
public interface AddressService {
    void save(Address address);

    List<AddressVo> queryAll();
}
