package com.bookstore.bookstore.dto;

import java.math.BigDecimal;

import com.bookstore.bookstore.entity.Book;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BookDto {

    private Long id;

    private String title;

    private String description;
    
    private BigDecimal price;

    private Book.BookStatus status;

    // private CategoryDto category;

    private String categoryName;
    private Long  categoryId;
    
    
}
