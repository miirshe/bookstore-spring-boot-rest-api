package com.bookstore.bookstore.dto;

import java.lang.String;
import com.bookstore.bookstore.entity.Category;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto {

    private Long id;

    private String name;

    private String description;

    private Category.CategoryType type;

    private Category.CategoryStatus status;
}



