package com.fin.fintechbookstore.model.entities;

import com.fin.fintechbookstore.model.enums.Type;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookstore")
@EqualsAndHashCode
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private int storeId;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "phone_number", unique = false, nullable = false)
    private int phoneNumber;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "location", unique = false, nullable = false)
    private String location;

    @Column(name = "type")
    private Type type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "bookstore_book", joinColumns = @JoinColumn(name = "store_id"), inverseJoinColumns = @JoinColumn(name = "book_id"))
    private List<Book> books;

}
