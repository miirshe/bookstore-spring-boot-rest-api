package com.bookstore.bookstore.mapper;

import com.bookstore.bookstore.dto.BookDto;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Category;

public class BookMapper {

    public static BookDto toBookDto(Book book) {
        if (book == null)
            return null;
        return BookDto.builder().id(book.getId()).title(book.getTitle()).description(book.getDescription())
                .price(book.getPrice()).status(book.getStatus()).categoryName(book.getCategory().getName())
                .categoryId(book.getCategory().getId()).build();
    }

    public static Book toBook(BookDto bookDto){
        if(bookDto == null) return null;
        return Book.builder().title(bookDto.getTitle()).description(bookDto.getDescription()).price(bookDto.getPrice())
        .status(bookDto.getStatus()).category(bookDto.getCategoryId() != null ? Category.builder().id(bookDto.getCategoryId()).build() : null).build();
    }


    public static Book updateBook(Book entity, BookDto bookDto){
        entity.setTitle(bookDto.getTitle());
        entity.setDescription(bookDto.getDescription());
        entity.setPrice(bookDto.getPrice());
        entity.setStatus(bookDto.getStatus());
        entity.setCategory(bookDto.getCategoryId() != null ? Category.builder().id(bookDto.getCategoryId()).build() : null);
        return entity;
    }

}
