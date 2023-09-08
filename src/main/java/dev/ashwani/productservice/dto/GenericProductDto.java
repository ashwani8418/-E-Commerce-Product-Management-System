package dev.ashwani.productservice.dto;

import dev.ashwani.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericProductDto {
    private Long id;
    private String title;
    private Double price;
    private String category;
    private String description;
    private String image;

}
