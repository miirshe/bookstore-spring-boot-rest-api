package com.bookstore.bookstore.mapper;

import com.bookstore.bookstore.dto.CategoryDto;
import com.bookstore.bookstore.entity.Category;

public class CategoryMapper {

    public static CategoryDto toCategoryDto(Category category) {
        if (category == null) {
            return null;
        }
        return CategoryDto.builder().id(category.getId()).name(category.getName()).description(category.getDescription()).type(category.getType()).status(category.getStatus()).build();
    }

    public static Category toCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        return Category.builder().name(categoryDto.getName()).description(categoryDto.getDescription()).type(categoryDto.getType()).status(categoryDto.getStatus()).build();
    }


    public static Category updateCategory(Category entity, CategoryDto categoryDto){
        entity.setName(categoryDto.getName());
        entity.setDescription(categoryDto.getDescription());
        entity.setType(categoryDto.getType());
        entity.setStatus(categoryDto.getStatus());
        return entity;
    }

}
