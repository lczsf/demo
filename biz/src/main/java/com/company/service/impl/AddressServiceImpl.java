package com.company.service.impl;

import com.company.dao.AddressDao;
import com.company.model.Address;
import com.company.service.AddressService;

import javax.annotation.Resource;

/**
 * Created by wb-lichao.x on 2016/4/11.
 */
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDao addressDao;

    @Override
    public void save(Address address) {
        if (addressDao != null) {
            addressDao.insert(address);
        } else {
            System.out.print("fail");
        }
    }
}
