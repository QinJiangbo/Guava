package com.qinjiangbo;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * Date: 16/10/2016
 * Author: qinjiangbo@github.io
 */
public class CacheTest {

    @Test
    public void testLoadingCache() throws ExecutionException {
        Map<String, String> database = Maps.newHashMap();
        database.put("qinjiangbo", "That's my way!");
        database.put("amy", "I love you!");
        database.put("nike", "Just do it!");
        LoadingCache<String, String> cache = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return database.get(key);
                    }
                });
        cache.put("whu", "WuHan University");
        System.out.println(cache.get("whu"));
    }

    @Test
    public void testCallableCache() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder
                .newBuilder()
                .maximumSize(1000)
                .build();
        String retriValue = cache.get("name", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "name ==> qinjiangbo";
            }
        });
        System.out.println(retriValue);
        cache.put("whu", "WuHan University");
        String retriValue2 = cache.get("whu", new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "name ==> whu";
            }
        });
        System.out.println(retriValue2);
    }
}
