package com.softtech.bootcamp.case3.repository;

import com.softtech.bootcamp.case3.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdcutRepository extends JpaRepository<Product, Long> {
}
