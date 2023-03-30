package com.example.shop.config;

import com.example.shop.dto.CarDTO;
import feign.HeaderMap;
import feign.RequestLine;
import java.util.Map;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "jplaceholder", url = "http://localhost:8080/shop/api")
public interface JSONPlaceHolderClient {

    @GetMapping( value = "/car")
    CarDTO getPosts( @RequestHeader(value = "Authorization") String authorizationHeader);
}