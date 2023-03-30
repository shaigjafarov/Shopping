package com.example.shop.controller;

import com.example.shop.config.JSONPlaceHolderClient;
//import com.example.shop.config.JwtUtils;
import com.example.shop.config.JwtUtils;
import com.example.shop.config.aoplog.LoggingAspect;
import com.example.shop.dto.CarDTO;
import com.example.shop.dto.LoginRequestDTO;
import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import java.util.HashMap;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class AuthController {
    private static final Logger LOGGER = LogManager.getLogger(AuthController.class);


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    JSONPlaceHolderClient jsonPlaceHolderClient;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            String token = jwtUtils.generateJwtToken(userDetails);
            return ResponseEntity.ok(token);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                    "Invalid username or password");
        }
    }

    @PostMapping("/save/user")
    public String login(@RequestBody User user) {
        try {
//            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return "ResponseEntity.ok(token)";
        } catch (AuthenticationException e) {
            return "sdfs";
        }
    }


    @GetMapping("/getir")
    public CarDTO login(@RequestHeader(value = "Authorization") String authorizationHeader) {

//        CarDTO posts = jsonPlaceHolderClient.getPosts(authorizationHeader);

//        HashMap<String, String> header = new HashMap<>();
//        header.put("Authorization", authorizationHeader);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", authorizationHeader);

        HttpEntity http = new HttpEntity<>(headers);

        ResponseEntity<CarDTO> exchange = restTemplate.exchange("http://localhost:8080/shop/api/car", HttpMethod.GET, http, CarDTO.class);
        return exchange.getBody();
    }

    @GetMapping("/car")
    public CarDTO car() {

        return CarDTO.builder()
                .color("Red")
                .name("Corolla")
                .engine("1400")
                .build();
    }
}