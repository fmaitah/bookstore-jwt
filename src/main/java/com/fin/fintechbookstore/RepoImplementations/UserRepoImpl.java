package com.fin.fintechbookstore.RepoImplementations;

import com.fin.fintechbookstore.exceptions.RepositoryException;
import com.fin.fintechbookstore.model.Role;
import com.fin.fintechbookstore.model.User;
import com.fin.fintechbookstore.repositories.RoleRepository;
import com.fin.fintechbookstore.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@Transactional
public class UserRepoImpl {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;

    public UserRepoImpl(UserRepository repo, RoleRepository rolesRepo) {
        super();
        this.userRepo = repo;
        this.roleRepo = rolesRepo;
    }

    public User get(int id) throws RepositoryException {

        if (!userRepo.existsById(id)) {

            throw new RepositoryException("not found with id : " + id);
        }

        return userRepo.findById(id).get();
    }

    public Page<User> getAll(int id, int offset, int elementCount, String sort) throws RepositoryException {

        Page<User> page = userRepo.findAll(PageRequest.of(offset, elementCount));

        if (page.isEmpty()) {
            throw new RepositoryException("nothing found");

        }
        return page;
    }

    public User create(User created) throws RepositoryException {

        return userRepo.save(created);
    }

    public User update(User updated) throws RepositoryException {

        if (!userRepo.existsById(updated.getUserId())) {

            throw new RepositoryException("not found with id : " + updated.getUserId());
        }

        return userRepo.save(updated);
    }

    public String delete(int id) throws RepositoryException {

        if (!userRepo.existsById(id)) {

            throw new RepositoryException("not found with id : " + id);
        }

        userRepo.deleteById(id);

        return "deleted : ID is : {" + id + "}";

    }

    public String deleteAll(int id) throws RepositoryException {

        userRepo.deleteAll();

        return "deleted all successfully";
    }

    public Page<User> getAllUsers(int offset, int elementCount, String sort) throws RepositoryException {

        if (userRepo.findAll().isEmpty()) {
            throw new RepositoryException("there are no Users");
        }

        Page<User> allUsers = userRepo.findAll(PageRequest.of(offset, elementCount, Sort.by(sort)));

        return allUsers;

    }

    public void addRoleToUser(String username, String roleName) {
        User user = userRepo.findByUsername(username).get();
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
        userRepo.save(user);
    }

    public void removeRoleFromUser(String username, String roleName) {
        User user = userRepo.findByUsername(username).get();
        Role role = roleRepo.findByName(roleName);
        user.getRoles().remove(role);
        userRepo.save(user);
    }

    public User getByUserName(String userName) {
        // TODO Auto-generated method stub
        return userRepo.findByUsername(userName).get();
    }
}
