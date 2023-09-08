package dev.ashwani.productservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends BaseModel{
    private Long id;
    private String title;
    private String description;
    private String image;
    private Category Category;
    private double price;
}
