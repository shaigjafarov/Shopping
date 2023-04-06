package com.example.shop.repository;

import com.example.shop.dto.CarDTO;
import com.example.shop.dto.CardDTO;
import com.example.shop.entity.Card;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findCardById(Long id);

    List<Card> findByCvvAndExpDate(String sdjhb, LocalDate exp);


    @Query("SELECT new com.example.shop.dto.CardDTO(a.cardNumber, a.expDate, a.holderName) FROM Card a")
    List<CardDTO> findCardDTOList();

    Page<Card> findAll(Pageable pageable);





}
