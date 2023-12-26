package com.yze.gestionproduit.gestionProduit.services;


import com.yze.gestionproduit.gestionProduit.dto.ProductDto;

import java.util.List;

public interface ProductService {
    Integer save(ProductDto dto);

    Integer update(Integer id,ProductDto productDto);

    List<ProductDto> findAll();

    ProductDto findById(Integer id);

    void delete(Integer id);


}
