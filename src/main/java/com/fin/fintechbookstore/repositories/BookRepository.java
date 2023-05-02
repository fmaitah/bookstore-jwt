package com.fin.fintechbookstore.repositories;

import com.fin.fintechbookstore.model.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
