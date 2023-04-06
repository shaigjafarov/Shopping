package com.example.shop.service;

import com.example.shop.dto.CardDTO;
import com.example.shop.entity.Card;
import java.util.List;
import org.springframework.data.domain.Page;

public interface CardService {

    List<CardDTO>  getListCardDTO();

    String saveCardDTO(CardDTO cardDTO);


    Page<Card> getListCard(int pageNum, int pageSize);
}
