package org.daming.address.dao;

import org.daming.address.pojo.City;

import java.util.List;

public interface ICityDao {

    List<City> listCities();

    City getCity(String code);
}
