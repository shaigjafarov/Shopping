package com.example.shop.controller;

import com.example.shop.dto.CardDTO;
import com.example.shop.service.CardService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    CardService cardService;


    //    @RequestMapping(method = RequestMethod.GET)
    @GetMapping("/cards")
    List<CardDTO> getCardDTOList() {
        return cardService.getListCardDTO();
    }

    @ResponseBody
    @PostMapping("/{id}")
    String saveCardDTO(@RequestBody CardDTO cardDTO, @PathVariable int id) {
        System.out.println(id);
        return cardService.saveCardDTO(cardDTO);

    }


}
