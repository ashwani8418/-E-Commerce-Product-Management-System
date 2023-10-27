package dev.ashwani.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product extends BaseModel{

    private String title;
    private String description;
    private String image;
    @ManyToOne
    private Category Category;
    private double price;
}
