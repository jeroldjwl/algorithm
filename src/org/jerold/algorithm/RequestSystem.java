package org.jerold.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jerold on 2017/5/3.
 */
public class RequestSystem {

    private static Map<String, Request> cache = new HashMap<>();
    private static Map<String, Long> disable = new HashMap<>();

    public RequestSystem() {

    }

    public void request(String ip) {
        if (disable.containsKey(ip)) {
            Long disableTime = disable.get(ip);
            long current = System.currentTimeMillis();
            if (((current - disableTime) / (1000 * 60)) >= 30) {
                disable.remove(ip);
            }
        } else {
            if (cache.get(ip) != null) {
                Request request = cache.get(ip);
                int count = request.getCount();
                count++;
                long cacheTime = request.getCacheTime();
                long current = System.currentTimeMillis();
                if (count > 30 && ((current - cacheTime) / (1000 * 60)) >= 30) {
                    cache.remove(ip);
                    long disableTime = System.currentTimeMillis();
                    disable.put(ip, disableTime);
                } else {
                    request.setCount(count);
                    cache.put(ip, request);
                }
            } else {
                Request request = new Request(ip, 1, System.currentTimeMillis());
                cache.put(ip, request);
            }
        }
    }

    class Request {
        private String ip;
        private int count;
        private long cacheTime;

        public Request(String ip, int count, long cacheTime) {
            this.ip = ip;
            this.count = count;
            this.cacheTime = cacheTime;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getCount() {
            return this.count;
        }

        public void setCacheTime(long cacheTime) {
            this.cacheTime = cacheTime;
        }

        public long getCacheTime() {
            return cacheTime;
        }
    }
}
