package com.yze.gestionproduit.gestionProduit.repositories;

import com.yze.gestionproduit.gestionProduit.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}