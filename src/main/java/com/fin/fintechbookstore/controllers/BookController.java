package com.fin.fintechbookstore.controllers;

import com.fin.fintechbookstore.exceptions.CustomException;
import com.fin.fintechbookstore.model.entities.Book;
import com.fin.fintechbookstore.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/books")
public class BookController {

    BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @GetMapping("")
    public Page<Book> getAll(@PathParam(value = "pageNumber") int pageNumber, @PathParam(value = "pageSize") int pageSize) throws CustomException {
        return bookService.getAll(pageNumber,pageSize);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable(name = "id") int id) throws CustomException {
        return bookService.get(id);
    }
}
