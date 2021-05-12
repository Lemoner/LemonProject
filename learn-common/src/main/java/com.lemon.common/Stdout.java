package com.lemon.common;


import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author lemon
 * @since 2021-05-07
 */
public class Stdout {

    public static void printlnJson(Object obj) {
        try {
            System.out.println(JacksonProvider.objectMapper.writeValueAsString(obj));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public static void println(){
        System.out.println();
    }

    public static void println(String str){
        System.out.println(str);
    }
}
