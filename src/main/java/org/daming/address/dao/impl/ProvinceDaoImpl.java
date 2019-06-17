package org.daming.address.dao.impl;

import org.daming.address.dao.IProvinceDao;
import org.daming.address.pojo.Province;
import org.daming.address.utils.DataLoader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProvinceDaoImpl implements IProvinceDao  {

    private DataLoader dataLoader;

    private List<Province> provinces;

    @Override
    public List<Province> listProvinces() {
        return this.provinces;
    }

    @Override
    public Province getProvince(String code) {
        return this.provinces.stream().filter(p -> p.getCode().equals(code)).findFirst().get();
    }

    public ProvinceDaoImpl(DataLoader dataLoader) {
        super();
        this.dataLoader = dataLoader;
        this.provinces = new ArrayList<>(31);
    }

    @PostConstruct
    private void init() throws Exception {
        this.provinces = this.dataLoader.load("provinces.json", Province.class);

    }

}
