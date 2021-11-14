package com.yitu.algorithms._10映射;

import com.yitu.algorithms.Map;

public class Main {
    public static void main(String[] args) {
        Map<String,String> map=new TreeMap<>();
        map.put("key1","value1");
        map.put("key1","value2");
        map.put("key1","value3");
        map.traversal(new Map.Visitor<String, String>() {
            @Override
            public boolean visit(String key, String value) {
                System.out.println(key+"_"+value);
                return false;
            }
        });
    }
}
