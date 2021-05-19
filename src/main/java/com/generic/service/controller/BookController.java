package com.generic.service.controller;

import com.generic.service.model.Book;
import com.generic.service.repo.BookRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/book")
class BookController extends GenericController<Book> {

    public BookController(BookRepository bookRepository) {
        super(bookRepository);
    }
}
