package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.bookstore.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
