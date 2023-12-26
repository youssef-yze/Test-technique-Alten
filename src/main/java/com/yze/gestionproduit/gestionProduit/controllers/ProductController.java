package com.yze.gestionproduit.gestionProduit.controllers;

import com.yze.gestionproduit.gestionProduit.dto.ProductDto;
import com.yze.gestionproduit.gestionProduit.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Tag(name = "product")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Integer> saveProduct(@RequestBody ProductDto product){
        return ResponseEntity.ok(productService.save(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> findAllProduct(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id-product}")
    public ResponseEntity<ProductDto> findProductById(@PathVariable("id-product") Integer id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @DeleteMapping("/{id-product}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id-product") Integer id){
        productService.delete(id);
        return ResponseEntity.accepted().build();
    }

    @PatchMapping("/{id-product}")
    public ResponseEntity<Integer> updateProduct(
            @PathVariable("id-product") Integer id,
            @RequestBody ProductDto product
    ){
        Integer rs = productService.update(id,product);
        if (rs == -1){
            return ResponseEntity.notFound().build();
        }else {
            return  ResponseEntity.ok(rs);
        }
    }
}
