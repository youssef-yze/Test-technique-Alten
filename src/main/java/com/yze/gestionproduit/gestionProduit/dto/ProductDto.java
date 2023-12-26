package com.yze.gestionproduit.gestionProduit.dto;

import com.yze.gestionproduit.gestionProduit.models.Product;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@AllArgsConstructor
@Builder
public class ProductDto {

    private Integer id;

    @NotNull(message = "le code ne doit pas etre vide")
    @NotEmpty(message = "le code ne doit pas etre vide")
    @NotBlank(message = "le code ne doit pas etre vide")
    private String code;

    @NotNull(message = "le nom ne doit pas etre vide")
    @NotEmpty(message = "le nom ne doit pas etre vide")
    @NotBlank(message = "le nom ne doit pas etre vide")
    private String name;

    @NotNull(message = "la description ne doit pas etre vide")
    @NotEmpty(message = "la description ne doit pas etre vide")
    @NotBlank(message = "la description ne doit pas etre vide")
    private String description;

    @NotNull(message = "le prix ne doit pas etre vide")
    @Positive
    private BigDecimal price;

    @NotNull(message = "la quantité ne doit pas etre vide")
    @PositiveOrZero
    private Integer quantity;

    private String inventoryStatus;

    @NotNull(message = "la catégorie ne doit pas etre vide")
    @NotEmpty(message = "la catégorie ne doit pas etre vide")
    @NotBlank(message = "la catégorie ne doit pas etre vide")
    private String category;
    private String image;
    private Integer rating;

    public static ProductDto fromEntity(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .code(product.getCode())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .inventoryStatus(product.getInventoryStatus())
                .category(product.getCategory())
                .image(product.getImage())
                .rating(product.getRating())
                .build();
    }

    public static Product ToEntity(ProductDto productDto){
        return Product.builder()
                .id(productDto.getId())
                .code(productDto.getCode())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .quantity(productDto.getQuantity())
                .inventoryStatus(productDto.getInventoryStatus())
                .category(productDto.getCategory())
                .image(productDto.getImage())
                .rating(productDto.getRating())
                .build();
    }

}
