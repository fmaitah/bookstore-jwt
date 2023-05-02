package com.fin.fintechbookstore.configurations.startup;

import com.fin.fintechbookstore.model.Role;
import com.fin.fintechbookstore.model.User;
import com.fin.fintechbookstore.repositories.RoleRepository;
import com.fin.fintechbookstore.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class Initializer implements CommandLineRunner {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepo;
    private final RoleRepository roleRepo;



    public Initializer(PasswordEncoder passwordEncoder, UserRepository userRepo, RoleRepository roleRepo) {
        this.passwordEncoder = passwordEncoder;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("initializing Roles if not exists");
        initRoles();
        System.out.println("initializing Users if not exists");
        initUsers();

    }


    private void initUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("root1", passwordEncoder.encode("root1"), Set.of(roleRepo.findByName("ROLE_storeAdmin"))));
        users.add(new User("root2", passwordEncoder.encode("root2"), Set.of(roleRepo.findByName("ROLE_storeAdmin"))));

        users.add(new User("normal1", passwordEncoder.encode("normal1"), Set.of(roleRepo.findByName("ROLE_normalUser"))));
        users.add(new User("normal2", passwordEncoder.encode("normal2"), Set.of(roleRepo.findByName("ROLE_normalUser"))));

        users.add(new User("user1", passwordEncoder.encode("user1")));
        users.add(new User("user2", passwordEncoder.encode("user2")));

        userRepo.saveAll(users);

    }

    private void initRoles() {

        Role storeAdmin = new Role();
        storeAdmin.setName("ROLE_storeAdmin");

        Role normalUser = new Role();
        normalUser.setName("ROLE_normalUser");

        if (!roleRepo.existsByName("ROLE_storeAdmin") && !roleRepo.existsByName("ROLE_normalUser")) {
            System.out.println("doesn't exist : creating");
            roleRepo.save(storeAdmin);
            roleRepo.save(normalUser);
            System.out.println("done with roles");
        } else {
            System.out.println("roles already exist");
        }
    }
}
