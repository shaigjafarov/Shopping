package com.example.shop.service.impl;

import com.example.shop.dto.CardDTO;
import com.example.shop.entity.Card;
import com.example.shop.repository.CardRepository;
import com.example.shop.service.CardService;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    CardRepository cardRepository;

//    @Autowired(required = true)
//    public CardServiceImpl(CardRepository cardRepository) {
//        this.cardRepository = cardRepository;
//    }

    @Override
//    @Cacheable("cardDtoList")

//    @CacheEvict(allEntries = true, value = "cardDtoList")
//    @Scheduled(fixedDelay = 10* 1000 ,  initialDelay = 500)
//    @CacheEvict(value = "cardDtoList", allEntries = true)
//    @Scheduled(fixedDelay = 10000)
    public List<CardDTO> getListCardDTO() {
        return cardRepository.findCardDTOList();
    }


    @Override
    @CacheEvict(value = "getListCard", allEntries = true)
    public String saveCardDTO(CardDTO cardDTO) {
        Card pensiya_karti = Card.builder().expDate(LocalDate.now().plusYears(3))
                .cardNumber(cardDTO.getCardNum())
                .holderName(cardDTO.getHolderName())
                .build();
        cardRepository.save(pensiya_karti);



        return "Success";
    }

    @Override
    @Cacheable(value = "getListCard" )
    public Page<Card> getListCard(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("holderName").descending().and(Sort.by("expDate").ascending()));
        return cardRepository.findAll(pageable);
    }
}
