package com.fin.fintechbookstore.RepoImplementations;

import com.fin.fintechbookstore.exceptions.RepositoryException;
import com.fin.fintechbookstore.model.entities.Book;
import com.fin.fintechbookstore.model.entities.Store;
import com.fin.fintechbookstore.repositories.StoreRepository;
import com.fin.fintechbookstore.utilities.ImplInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class StoreRepoImpl implements ImplInterface<Store> {

    StoreRepository storeRepository;

    public StoreRepoImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Page<Store> getAll(int pageNumber, int pageSize) throws RepositoryException {

        if (storeRepository.findAll().isEmpty()) {
            throw new RepositoryException("no data in database");
        }

        return storeRepository.findAll(PageRequest.of(pageNumber, pageSize));
    }

    @Override
    public Store get(int id) throws RepositoryException {

        if (!storeRepository.existsById(id)) {
            throw new RepositoryException("not found with id : " + id);
        }
        return storeRepository.findById(id).orElseThrow();
    }

    public Page<Book> getAllBooksByStoreId(int pageNumber, int pageSize,int id) throws RepositoryException {
        if (!storeRepository.existsById(id)) {
            throw new RepositoryException("not found with id : " + id);
        }
return storeRepository.findAllBooksByStoreId(PageRequest.of(pageNumber, pageSize),id);
    }
}
