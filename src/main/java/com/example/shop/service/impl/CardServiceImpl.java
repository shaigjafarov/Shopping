package com.example.shop.service.impl;

import com.example.shop.dto.CardDTO;
import com.example.shop.service.CardService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CardServiceImpl implements CardService {
    @Override
    public List<CardDTO> getListCardDTO() {
        List<CardDTO> cardDTOList= new ArrayList<>();
        cardDTOList.add(CardDTO.builder()
                .expDate(LocalDate.now().plusDays(1L))
                .cardNum("123456789012345")
                .holderName("EXP 1313-HJBds")
                .build());
        return cardDTOList;
    }

    @Override
    public String saveCardDTO(CardDTO cardDTO) {
        System.out.println(cardDTO);
        return "Success";
    }
}
