package org.daming.address.service.impl;

import org.daming.address.dao.ICityDao;
import org.daming.address.pojo.City;
import org.daming.address.service.ICityService;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CityServiceImpl implements ICityService {

    private ICityDao cityDao;

    @Override
    public List<City> listCities() {
        return this.cityDao.listCities();
    }

    @Override
    public City getCity(String code) {
        Assert.hasText(code, () -> String.format("params '%s' is required", code));
        return this.cityDao.getCity(code);
    }

    public CityServiceImpl(ICityDao cityDao) {
        super();
        this.cityDao = cityDao;
    }
}
