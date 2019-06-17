package org.daming.address.service.impl;

import org.daming.address.dao.IProvinceDao;
import org.daming.address.pojo.Province;
import org.daming.address.service.IProvinceService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProvinceServiceImpl implements IProvinceService {

    private IProvinceDao provinceDao;

    @Override
    public List<Province> listProvinces() {
        return this.provinceDao.listProvinces();
    }

    @Override
    public Province getProvince(String code) {
        Assert.hasText(code, () -> String.format("params '%s' is required", code));
        return this.provinceDao.getProvince(code);
    }

    public ProvinceServiceImpl(IProvinceDao provinceDao) {
        super();
        this.provinceDao = provinceDao;
    }
}
