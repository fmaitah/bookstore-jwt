package com.fin.fintechbookstore.controllers;

import com.fin.fintechbookstore.exceptions.CustomException;
import com.fin.fintechbookstore.model.entities.Book;
import com.fin.fintechbookstore.model.entities.Store;
import com.fin.fintechbookstore.services.StoreService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/stores")
public class StoreController {

    StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("")
    public Page<Store> getAll(@PathParam(value = "pageNumber") int pageNumber,@PathParam(value = "pageSize") int pageSize) throws CustomException {
        return storeService.getAll(pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public Store get(@PathVariable(name = "id") int id) throws CustomException {
        return storeService.get(id);
    }

    @GetMapping("/{id}/books")
    public Page<Book> getAllBooks(@PathParam(value = "pageNumber") int pageNumber,@PathParam(value = "pageSize") int pageSize,@PathVariable(name = "id") int id) throws CustomException {
        return storeService.getAllBooksByStoreId(pageNumber, pageSize,id);
    }
}
