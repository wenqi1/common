package com.learn.common.exception;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.HashMap;

/**
 * 错误集合
 */
public class ErrorMap {
    private static HashMap<String, String> errorMap = new HashMap<>();

    static{
        ClassPathResource classPathResource = new ClassPathResource("error.properties");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(classPathResource.getFile()));
            String line;
            while((line = bufferedReader.readLine()) != null){
                if(line != ""){
                    String[] errorInfo = line.split("=");
                    errorMap.put(errorInfo[0],errorInfo[1]);
                }

            }
        } catch (IOException e) {
            throw new CommonException("1001", e);
        }

    }

    public static String getMessage(String code){
        return errorMap.get(code);
    }
}
