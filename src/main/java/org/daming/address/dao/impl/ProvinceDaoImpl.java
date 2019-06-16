package org.daming.address.dao.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.daming.address.dao.IProvinceDao;
import org.daming.address.pojo.Province;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.apache.commons.io.FileUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProvinceDaoImpl implements IProvinceDao  {

    private ObjectMapper jsonMapper;

    private List<Province> provinces;

    @Override
    public List<Province> listProvinces() {
        return this.provinces;
    }

    public ProvinceDaoImpl(ObjectMapper jsonMapper) {
        super();
        this.jsonMapper = jsonMapper;
        this.provinces = new ArrayList<>(31);
    }

    @PostConstruct
    private void init() throws Exception {
        File jsonFile = ResourceUtils.getFile("classpath:provinces.json");
        String content = FileUtils.readFileToString(jsonFile, Charset.defaultCharset());

        this.provinces = this.jsonMapper.readValue(content, List.class);
    }

}
