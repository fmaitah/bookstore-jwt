package com.fin.fintechbookstore.services;

import com.fin.fintechbookstore.RepoImplementations.BookRepoImpl;
import com.fin.fintechbookstore.exceptions.ServiceException;
import com.fin.fintechbookstore.model.entities.Book;
import com.fin.fintechbookstore.utilities.ImplInterface;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookService implements ImplInterface<Book> {

    BookRepoImpl bookRepo;

    public BookService(BookRepoImpl bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Page<Book> getAll(int pageNumber, int pageSize) throws ServiceException {

        if(pageSize <=0){
            throw new ServiceException("page size must be more than 0");
        }

        return bookRepo.getAll(pageNumber,pageSize);
    }

    @Override
    public Book get(int id) throws ServiceException {
        return bookRepo.get(id);
    }
}
