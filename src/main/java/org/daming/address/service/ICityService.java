package org.daming.address.service;

import org.daming.address.pojo.City;

import java.util.List;

public interface ICityService {

    List<City> listCities();

    City getCity(String code);

}
