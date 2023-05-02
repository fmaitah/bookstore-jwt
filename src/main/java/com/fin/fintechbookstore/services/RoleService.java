package com.fin.fintechbookstore.services;


import com.fin.fintechbookstore.RepoImplementations.RoleRepoImpl;
import com.fin.fintechbookstore.exceptions.ServiceException;
import com.fin.fintechbookstore.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService {

    private final RoleRepoImpl impl;

    public RoleService(RoleRepoImpl impl) {
        this.impl = impl;

    }

    public Role get(int id) throws ServiceException {

        return impl.get(id);
    }

    public Page<Role> getAll(int id, int offset, int elementCount, String sort) throws ServiceException {

        return impl.getAll(id, offset, elementCount, sort);
    }

    public Role create(Role created) throws ServiceException {

        return impl.create(created);
    }

    public String delete(int id) throws ServiceException {

        return impl.delete(id);

    }

    public Role update(Role updated) throws ServiceException {

        return impl.update(updated);
    }

    public String deleteAll() throws ServiceException {

        return impl.deleteAll();
    }

}

