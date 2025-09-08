package com.bookstore.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dto.CategoryDto;
import com.bookstore.bookstore.entity.Category;
import com.bookstore.bookstore.exception.ResourceSourceException;
import com.bookstore.bookstore.mapper.CategoryMapper;
import com.bookstore.bookstore.repository.CategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryDto create(CategoryDto categoryDto) {
        CategoryDto category = CategoryMapper
                .toCategoryDto(categoryRepository.save(CategoryMapper.toCategory(categoryDto)));
        return category;
    }

    public CategoryDto update(Long id, CategoryDto updateDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceSourceException("Category not found"));
        CategoryMapper.updateCategory(category, updateDto);
        return CategoryMapper.toCategoryDto(categoryRepository.save(category));
    }

    public CategoryDto findOne(Long id) {
        CategoryDto category = CategoryMapper.toCategoryDto(
                categoryRepository.findById(id).orElseThrow(() -> new ResourceSourceException("Category not found")));
        return category;
    }

    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceSourceException("Category not found"));
        categoryRepository.delete(category);
    }

    public List<CategoryDto> findAll() {
        List<CategoryDto> categories = categoryRepository.findAll().stream()
                .map((category) -> CategoryMapper.toCategoryDto(category)).collect(Collectors.toList());
        return categories;
    }

}
