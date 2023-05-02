package com.fin.fintechbookstore.model.entities;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "book")
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int bookId;

    @Column(name = "title", unique = false, nullable = false)
    private String title;

    @Column(name = "author", unique = false, nullable = false)
    private String author;

    @Column(name = "price", unique = false, nullable = false)
    private Double price;



}
