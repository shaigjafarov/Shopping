package com.example.shop.repository;

import com.example.shop.entity.Card;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {

    Card findCardById(Long id);

    List<Card> findByCvvAndAndExpDate(String sdjhb, LocalDate exp);

    @Override
     <S extends Card> S save(S entity);
}
