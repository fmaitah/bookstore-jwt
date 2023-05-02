package com.fin.fintechbookstore.RepoImplementations;

import com.fin.fintechbookstore.exceptions.RepositoryException;
import com.fin.fintechbookstore.model.entities.Book;
import com.fin.fintechbookstore.repositories.BookRepository;
import com.fin.fintechbookstore.utilities.ImplInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class BookRepoImpl implements ImplInterface<Book> {


    BookRepository bookRepository;

    public BookRepoImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Page<Book> getAll(int pageNumber,int pageSize) throws RepositoryException {

        if (bookRepository.findAll().isEmpty()) {
            throw new RepositoryException("no data in database");
        }

        return bookRepository.findAll(PageRequest.of(pageNumber,pageSize));
    }

    @Override
    public Book get(int id) throws RepositoryException {
        if (!bookRepository.existsById(id)) {
            throw new RepositoryException("not found with id : " + id);
        }

        return bookRepository.findById(id).orElseThrow();
    }
}
