package com.example.shop.service;

import com.example.shop.dto.CardDTO;
import java.util.List;

public interface CardService {

    List<CardDTO>  getListCardDTO();

    String saveCardDTO(CardDTO cardDTO);
}
