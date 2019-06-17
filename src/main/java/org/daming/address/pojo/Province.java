package org.daming.address.pojo;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;
import java.util.StringJoiner;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, isGetterVisibility = JsonAutoDetect.Visibility.NONE)
public class Province implements Serializable {

    private String code;

    private String name;

    public String getCode() {
        return code;
    }

    public Province setCode(String code) {
        this.code = code;
        return this;
    }

    public String getName() {
        return name;
    }

    public Province setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Province.class.getSimpleName() + "[", "]")
                .add("code='" + code + "'")
                .add("name='" + name + "'")
                .toString();
    }
}
