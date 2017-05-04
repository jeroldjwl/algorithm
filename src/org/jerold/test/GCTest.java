package org.jerold.test;

import org.jerold.list.ArrayList;
import org.jerold.list.List;

/**
 * Created by jerold on 2017/4/14.
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] bytes;
        List<Object> objectList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bytes = new byte[1 * 1024 * 1024];
            objectList.add(bytes);
        }
    }
}
