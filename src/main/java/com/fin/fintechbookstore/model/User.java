package com.fin.fintechbookstore.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity(name = "book_user")
@EqualsAndHashCode
public class User {

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public User(String username, String password,Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_user")
    private int userId;

    @Column(name = "username", unique = false, nullable = false)
    private String username;

    @Column(name = "password", unique = false, nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


}
