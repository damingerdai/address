package org.daming.address.dao.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.daming.address.dao.IProvinceDao;
import org.daming.address.pojo.Province;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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

    @Override
    public Province getProvince(String code) {
        return this.provinces.stream().filter(p -> p.getCode().equals(code)).findFirst().get();
    }

    public ProvinceDaoImpl(ObjectMapper jsonMapper) {
        super();
        this.jsonMapper = jsonMapper;
        this.provinces = new ArrayList<>(31);
    }

    @PostConstruct
    private void init() throws Exception {
        Resource resource = new ClassPathResource("provinces.json");
        StringBuilder sb = new StringBuilder();
        try (InputStream is = resource.getInputStream();BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }

        String content = sb.toString();
        this.provinces = this.jsonMapper.readValue(content, new TypeReference<List<Province>>() {});
    }

}
