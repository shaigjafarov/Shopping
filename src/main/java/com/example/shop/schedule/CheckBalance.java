package com.example.shop.schedule;

import com.example.shop.config.AuthTokenFilter;
import com.example.shop.service.Messaging;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckBalance {
    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
    @Autowired
    Messaging messaging;

    @Scheduled(cron = "*/10 * * * * ?")
    void dailyCheck() {
        System.out.println("Isleyir");
       messaging.sendEmail("sahilnecefov123@gmail.com", "Dogrulama", "12347");
    }
}
