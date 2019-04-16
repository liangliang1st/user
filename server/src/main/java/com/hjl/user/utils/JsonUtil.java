package com.hjl.user.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @ClassName JsonUtil
 * @AUthor hanjialiang
 * @Date 2019-04-14 10:44
 * @Version 1.0
 * @Description
 */
public class JsonUtil {
    private static ObjectMapper objectMapper=new ObjectMapper();

    public static String toJson(Object o){
        try {
            return objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
