//package com.example.shop.config;
//
//import java.io.IOException;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.web.filter.OncePerRequestFilter;
//@Configuration
//public class PublicUrlFilter extends OncePerRequestFilter {
//
//    private final String[] publicUrls = new String[]{
//            "/api/car"
//    };
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
//                                    FilterChain filterChain) throws ServletException, IOException {
//        if (isPublicUrl(request)) {
//            filterChain.doFilter(request, response);
//        }
//    }
//
//    private boolean isPublicUrl(HttpServletRequest request) {
//        String requestUrl = request.getRequestURI();
//        for (String publicUrl : publicUrls) {
//            if (new AntPathMatcher().match(publicUrl, requestUrl)) {
//                return true;
//            }
//        }
//        return false;
//    }
//}