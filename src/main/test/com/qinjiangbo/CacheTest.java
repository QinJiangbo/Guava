package com.qinjiangbo;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

/**
 * Date: 16/10/2016
 * Author: qinjiangbo@github.io
 */
public class CacheTest {

    @Test
    public void testLoadingCache() {
        LoadingCache<String, String> cache = CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return null;
                    }
                });

    }
}
