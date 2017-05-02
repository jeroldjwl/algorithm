package org.jerold.test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by jerold on 2017/4/26.
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        Map map = new LinkedHashMap(10, 0.75f, true);
        map.put("5", "apple");
        map.put("2", "orange");
        map.put("4", "banana");
        Iterator itr = map.keySet().iterator();
        while (itr.hasNext()) {
            Object key = itr.next();
            System.out.println(key + ": " + map.get(key));
        }
    }
}
