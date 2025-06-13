package com.example.Inventory.Controller;

import com.example.Inventory.Entity.Product;
import com.example.Inventory.Repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins = "*")
public class Controller {

        @Autowired
        private Repository repo;

        @GetMapping("/all")
        public List<Product> getAll() {
            return repo.findAll();
        }

        @GetMapping("/{id}")
        public Product getOne(@PathVariable Long id) {
            return repo.findById(id).orElse(null);
        }

        @PostMapping("/add")
        public Product create(@RequestBody Product p) {
            return repo.save(p);
        }

        @PutMapping("/{id}/stock")
        public Product updateStock(@PathVariable Long id, @RequestParam int stock) {
            Product p = repo.findById(id).orElse(null);
            if (p != null) {
                p.setStock(stock);
                return repo.save(p);
            }
            return null;
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            repo.deleteById(id);
        }
    }


