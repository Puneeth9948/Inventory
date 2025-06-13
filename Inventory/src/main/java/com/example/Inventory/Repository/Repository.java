package com.example.Inventory.Repository;

import com.example.Inventory.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Product, Long> {
}
