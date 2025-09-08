package com.bookstore.bookstore.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.dto.BookDto;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.exception.ResourceSourceException;
import com.bookstore.bookstore.mapper.BookMapper;
import com.bookstore.bookstore.repository.BookRepository;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // create book

    public BookDto create(BookDto dto) {
        BookDto book = BookMapper.toBookDto(bookRepository.save(BookMapper.toBook(dto)));
        return book;
    }

    // update book

    public BookDto update(Long id, BookDto dto) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceSourceException("Book not found"));
        BookMapper.updateBook(book, dto);
        BookDto bookDto = BookMapper.toBookDto(bookRepository.save(book));
        return bookDto;
    }

    // find one book
    public BookDto findOne(Long id) {
        BookDto bookDto = BookMapper.toBookDto(
                bookRepository.findById(id).orElseThrow(() -> new ResourceSourceException("Book not found")));
        return bookDto;
    }

    // Find All books
    public List<BookDto> findAll() {
        List<BookDto> books = bookRepository.findAll().stream().map((book) -> BookMapper.toBookDto(book))
                .collect(Collectors.toList());
        return books;
    }

    public void delete(Long id){
        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceSourceException("Book not found"));
        bookRepository.delete(book);
    }

}
