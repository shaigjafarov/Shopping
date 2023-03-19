package com.example.shop.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CardDTO {


    String cardNum;
    LocalDate expDate;
    String holderName;




}
