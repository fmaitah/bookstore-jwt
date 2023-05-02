package com.fin.fintechbookstore.utilities;

import com.fin.fintechbookstore.exceptions.CustomException;
import com.fin.fintechbookstore.exceptions.RepositoryException;
import com.fin.fintechbookstore.exceptions.ServiceException;
import org.springframework.data.domain.Page;

public interface ImplInterface<T> {

    public Page<T> getAll(int pageNumber, int pageSize) throws RepositoryException, ServiceException;

    public T get(int id) throws CustomException;

}
