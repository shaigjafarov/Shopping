package com.example.shop.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
//
//@Configuration
//@EnableCaching
//@EnableScheduling
//public class CachingConfig {
//
//  public static final String GAMES = "cardDtoList";
//
//  @Bean
//  public CacheManager cacheManager() {
//    ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager(GAMES);
//    return cacheManager;
//
//  }
//
//
//
//
//}