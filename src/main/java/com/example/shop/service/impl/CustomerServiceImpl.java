package com.example.shop.service.impl;

import com.example.shop.service.CustomerService;
import com.example.shop.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Qualifier("paypal")
    @Autowired
    PaymentService paymentService;

//    public CustomerServiceImpl(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }

//    @Autowired
//    public void setPaymentService(PaymentService paymentService) {
//        this.paymentService = paymentService;
//    }
}
