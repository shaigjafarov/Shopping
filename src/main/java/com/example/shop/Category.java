package com.example.shop;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Category {


    private String name;
    private   Category subCategory;


}

class   Nese{

    public static void main(String[] args) {
        Category engine= Category.builder().name("engine").build();
        engine.setSubCategory(Category.builder().name("cooling_system").build());
        engine.getSubCategory().setSubCategory(Category.builder().name("cooling_water").build());




    }
}