package com.fin.fintechbookstore.services;

import com.fin.fintechbookstore.RepoImplementations.StoreRepoImpl;
import com.fin.fintechbookstore.exceptions.ServiceException;
import com.fin.fintechbookstore.model.entities.Book;
import com.fin.fintechbookstore.model.entities.Store;
import com.fin.fintechbookstore.utilities.ImplInterface;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StoreService implements ImplInterface<Store> {

    StoreRepoImpl storeRepo;

    public StoreService(StoreRepoImpl storeRepo) {
        this.storeRepo = storeRepo;
    }


    @Override
    public Page<Store> getAll(int pageNumber, int pageSize) throws ServiceException {

        if(pageSize <=0){
            throw new ServiceException("page size must be more than 0");
        }

        return storeRepo.getAll(pageNumber, pageSize);
    }

    @Override
    public Store get(int id) throws ServiceException {
        return storeRepo.get(id);
    }

    public Page<Book> getAllBooksByStoreId(int pageNumber, int pageSize,int id) throws ServiceException {

        if(pageSize <=0){
            throw new ServiceException("page size must be more than 0");
        }

        return storeRepo.getAllBooksByStoreId(pageNumber,pageSize,id);
    }
}
