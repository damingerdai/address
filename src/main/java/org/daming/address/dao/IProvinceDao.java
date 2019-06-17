package org.daming.address.dao;

import org.daming.address.pojo.Province;

import java.util.List;

public interface IProvinceDao {

    List<Province> listProvinces();

    Province getProvince(String code);
}
