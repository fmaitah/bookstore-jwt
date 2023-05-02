package com.fin.fintechbookstore.RepoImplementations;

import com.fin.fintechbookstore.exceptions.RepositoryException;
import com.fin.fintechbookstore.model.Role;
import com.fin.fintechbookstore.repositories.RoleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
public class RoleRepoImpl {

    private final RoleRepository roleRepo;

    public RoleRepoImpl(RoleRepository repo) {
        this.roleRepo = repo;
    }

    //    @Override
    public Role get(int id) throws RepositoryException {

        if (!roleRepo.existsById(id)) {

            throw new RepositoryException("not found with id : " + id);
        }

        return roleRepo.findById(id).get();
    }

    public Page<Role> getAll(int id, int offset, int elementCount, String sort) throws RepositoryException {

        Page<Role> page = roleRepo.findAll(PageRequest.of(offset, elementCount));

        if (page.isEmpty()) {
            throw new RepositoryException("nothing found");

        }
        return page;
    }

    public Role create(Role created) throws RepositoryException {

        return roleRepo.save(created);
    }

    public Role update(Role updated) throws RepositoryException {

        if (!roleRepo.existsById(updated.getRoleId())) {

            throw new RepositoryException("not found with id : " + updated.getRoleId());
        }

        return roleRepo.save(updated);
    }

    public String delete(int id) throws RepositoryException {

        if (!roleRepo.existsById(id)) {

            throw new RepositoryException("not found with id : " + id);
        }

        roleRepo.deleteById(id);

        return "deleted : ID is : {" + id + "}";

    }

    public String deleteAll() {

        roleRepo.deleteAll();

        return "deleted all successfully";
    }

    public Page<Role> getAllRoles(int offset, int elementCount, String sort) throws RepositoryException {

        if (roleRepo.findAll().isEmpty()) {
            throw new RepositoryException("there are no Roles");
        }

        return roleRepo.findAll(PageRequest.of(offset, elementCount, Sort.by(sort)));

    }

}