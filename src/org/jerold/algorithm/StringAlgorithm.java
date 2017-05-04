package org.jerold.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Jerold on 2016/11/4.
 */
public class StringAlgorithm {

    // 1. 将字符串中的字符按出现的次数多数排序
    //  example: Input: Tree, Output: eerT
    //           Input: asaccc Output: cccaas
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                int frequency = map.get(chars[i]);
                frequency++;
                map.put(chars[i], frequency);
            }
        }
        Map<Integer, Character> tmp = new HashMap<Integer, Character>();
        Set<Map.Entry<Character, Integer>> set = map.entrySet();
        return null;
    }

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, 'c');
        map.put(1, 'd');
        Set<Map.Entry> set = map.entrySet();
        for (Map.Entry e : set) {
            System.out.println(e.getKey() + ", " + e.getValue());
        }
    }
}
