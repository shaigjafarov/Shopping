//package com.example.shop.config;
//
//import org.springframework.cache.Cache;
//import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CacheConfig {
//
//    @Bean
//    public ConcurrentMapCacheManager cacheManager() {
//        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager("myCache");
//        Cache myCache = cacheManager.getCache("myCache");
////        myCache.getNativeCache().put("key1", "value1"); // populate cache with an initial value
////        cacheManager.setDefaultExpiration(60); // set TTL to 60 seconds
//        return cacheManager;
//    }
//}