package com.example.shop.controller;

import com.example.shop.dto.CardDTO;
import com.example.shop.entity.Card;
import com.example.shop.repository.CardRepository;
import com.example.shop.service.CardService;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;

    @Autowired
    CardRepository cardRepository;



        @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/cards")
    List<CardDTO> getCardDTOList() {
        return cardService.getListCardDTO();
    }

    @PostMapping("/{id}")
    String saveCardDTO(@RequestBody CardDTO cardDTO, @PathVariable int id, @RequestParam String name, @RequestHeader String sd) {
        System.out.println(id);
        return cardService.saveCardDTO(cardDTO);

    }

    @GetMapping("/tt")
    Card getad(@RequestParam Long id ) {
        return cardRepository.findCardById(id);
    }

    @PostMapping("/save")
    ResponseEntity<String> saveCard(@RequestBody CardDTO cardDTO) {
      return   ResponseEntity.status(HttpStatus.CREATED).body(cardService.saveCardDTO(cardDTO));
    }


}
