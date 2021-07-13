package com.example.cookies.repository;

import com.example.cookies.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * pooya mahmoodi 7/13/2021
 **/
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
