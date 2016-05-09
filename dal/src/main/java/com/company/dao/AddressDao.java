package com.company.dao;

import com.company.model.Address;

import java.util.List;

/**
 * Created by wb-lichao.x on 2016/4/11.
 */
public interface AddressDao {
    void insert(Address address);

    List<Address> queryAll();
}
