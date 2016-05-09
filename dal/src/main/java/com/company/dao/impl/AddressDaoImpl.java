package com.company.dao.impl;

import com.company.dao.AddressDao;
import com.company.mapper.AddressMapperExt;
import com.company.model.Address;
import com.company.model.AddressExample;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/11.
 */
public class AddressDaoImpl implements AddressDao {

    @Resource
    private AddressMapperExt addressMapperExt;

    @Override
    public void insert(Address address) {
        addressMapperExt.insert(address);
    }

    @Override
    public List<Address> queryAll() {
        return addressMapperExt.selectByExample(new AddressExample());
    }
}
