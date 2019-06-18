package org.daming.address.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.StringJoiner;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class City implements Serializable {

    private String code;

    private String name;

    private String provinceCode;

    public String getCode() {
        return code;
    }

    public City setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public City setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
        return this;
    }

    public City() {
        super();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", City.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("name='" + name + "'")
                .add("provinceCode='" + provinceCode + "'")
                .toString();
    }
}


