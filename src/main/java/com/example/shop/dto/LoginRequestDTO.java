package com.example.shop.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class LoginRequestDTO {

    @NotBlank
    String username;

    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$", message="the value must duzgun")
    String password;
}
