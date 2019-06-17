package org.daming.address.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Component
public class DataLoader {

    private ObjectMapper jsonMapper;

    public <T> List<T> load(String path, Class<T> clazz) throws Exception {
        Resource resource = new ClassPathResource(path);
        StringBuilder sb = new StringBuilder();
        try (InputStream is = resource.getInputStream(); BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }

        String content = sb.toString();
        JavaType javaType = getCollectionType(List.class, clazz);
        return this.jsonMapper.readValue(content, javaType);
    }

    public JavaType getCollectionType(Class<?> collectionClass, Class<?>... elementClasses) {
        return jsonMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }

    public DataLoader(ObjectMapper jsonMapper) {
        super();
        this.jsonMapper = jsonMapper;
    }
}
