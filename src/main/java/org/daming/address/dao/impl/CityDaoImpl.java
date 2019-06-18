package org.daming.address.dao.impl;

import org.daming.address.dao.ICityDao;
import org.daming.address.pojo.City;
import org.daming.address.pojo.Province;
import org.daming.address.utils.DataLoader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;

@Repository
public class CityDaoImpl implements ICityDao {

    private List<City> cities;

    private DataLoader dataLoader;

    @Override
    public List<City> listCities() {
        return this.cities;
    }

    @Override
    public City getCity(String code) {
        return this.cities.stream().filter(city -> city.getCode().equals(code)).findFirst().get();
    }

    public CityDaoImpl(DataLoader dataLoader) {
        super();
        this.dataLoader = dataLoader;
    }

    @PostConstruct
    private void init() throws Exception {
        this.cities = this.dataLoader.load("cities.json", City.class);

    }
}
