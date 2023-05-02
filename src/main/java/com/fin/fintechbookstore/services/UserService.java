package com.fin.fintechbookstore.services;

import com.fin.fintechbookstore.RepoImplementations.UserRepoImpl;
import com.fin.fintechbookstore.exceptions.ServiceException;
import com.fin.fintechbookstore.model.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    private final UserRepoImpl repoImpl;

    public UserService(UserRepoImpl impl) {
        this.repoImpl = impl;

    }

    public User get(int id) throws ServiceException {

        return repoImpl.get(id);
    }

    public Page<User> getAll(int id, int offset, int elementCount, String sort) throws ServiceException {

        return repoImpl.getAll(id, offset, elementCount, sort);
    }

    public User create(User created) throws ServiceException {

        return repoImpl.create(created);
    }

    public String delete(int id) throws ServiceException {

        return repoImpl.delete(id);

    }

    public User update(User updated) throws ServiceException {

        return repoImpl.update(updated);
    }

    public String deleteAll(int id) throws ServiceException {

        return repoImpl.deleteAll(id);
    }

    public Page<User> getAllOrdersPaginated(int offset, int elementCount, String sort) throws ServiceException {
        return repoImpl.getAllUsers(offset, elementCount, sort);
    }

    public User getByUserName(String userName) throws ServiceException {

        return repoImpl.getByUserName(userName);
    }

}
