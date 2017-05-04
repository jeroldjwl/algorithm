package org.jerold.tree;

/**
 * Created by Jerold on 2017/4/26.
 */
public class ThreadTest {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("cores: " + cores);
        for (int i = 0; i < cores; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        ;
                    }
                }
            }).start();
        }
    }
}
