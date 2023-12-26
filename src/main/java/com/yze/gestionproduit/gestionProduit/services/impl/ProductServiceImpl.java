package com.yze.gestionproduit.gestionProduit.services.impl;

import com.yze.gestionproduit.gestionProduit.dto.ProductDto;
import com.yze.gestionproduit.gestionProduit.models.Product;
import com.yze.gestionproduit.gestionProduit.repositories.ProductRepository;
import com.yze.gestionproduit.gestionProduit.services.ProductService;

import com.yze.gestionproduit.gestionProduit.validators.ObjectsValidator;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ObjectsValidator<ProductDto> validator;
    @Override
    public Integer save(ProductDto dto) {
        validator.validate(dto);
        Product product = ProductDto.ToEntity(dto);
        return productRepository.save(product).getId();
    }

    @Override
    public Integer update(Integer id,ProductDto productDto) {
        if (!productRepository.existsById(id)){
            throw new EntityNotFoundException("Product not fount with provider ID " + id);
        }
        Product product = ProductDto.ToEntity(productDto);
        product.setId(id);
        return productRepository.save(product).getId();
    }

    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductDto::fromEntity)
                .collect(Collectors.toList())
                ;
    }

    @Override
    public ProductDto findById(Integer id) {
        return productRepository.findById(id)
                .map(ProductDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("not found product with provider id " + id));
    }

    @Override
    public void delete(Integer id) {
        if (productRepository.existsById(id)){
            productRepository.deleteById(id);
        }else {
            throw new EntityNotFoundException("Product not fount with provider ID " + id);
        }
    }
}
