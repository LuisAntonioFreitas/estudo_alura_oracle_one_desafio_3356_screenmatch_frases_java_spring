package net.lanet.screenmatchfrases.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConvertsDataUtil {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ObjectMapper objectMapper;

    public <T> T getDataJsonToClass(String json, Class<T> modelTarget) {
        try {
            return objectMapper.readValue(json, modelTarget);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> List<T> getDataListJsonToClass(String json, Class<T> modelTarget) {
        CollectionType listModel = objectMapper.getTypeFactory()
                .constructCollectionType(List.class, modelTarget);
        try {
            return objectMapper.readValue(json, listModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <T> String setDataClassToJson(Class<T> modelSource) {
        try {
            String json = objectMapper.writeValueAsString(modelSource);
            return json;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public <S, T> T mapDataClassToClass(S modelSource, Class<T> modelTarget) {
        try {
            return modelMapper.map(modelSource, modelTarget);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
