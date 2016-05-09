package com.company.service.impl;

import com.company.dao.AddressDao;
import com.company.model.Address;
import com.company.service.AddressService;
import com.company.vo.AddressVo;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<AddressVo> queryAll() {
        List<Address> addresses = addressDao.queryAll();
        List<AddressVo> addressVos = new ArrayList<AddressVo>();
        for (Address address : addresses) {
            AddressVo addressVo = new AddressVo();
            addressVo.setAddress(address);
            addressVos.add(addressVo);
        }
        return addressVos;
    }
}
