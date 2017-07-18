package com.practice;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by nakul on 18/7/17.
 *
 * class to show how to iterate on map
 */
public class HashmapIterate {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("2","2");
        map.put("3","3");
        map.put("4","4");
        map.put("5","5");

        // using for loop
        for (Map.Entry<String,String> e : map.entrySet()){
            System.out.print(e.getKey()+" : "+e.getValue()+"\n");
        }

        // using while loop
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey()+", "+next.getValue());
        }
    }
}
