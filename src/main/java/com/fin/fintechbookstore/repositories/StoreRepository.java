package com.fin.fintechbookstore.repositories;

import com.fin.fintechbookstore.model.entities.Book;
import com.fin.fintechbookstore.model.entities.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface StoreRepository extends JpaRepository<Store, Integer> {
    @Query("SELECT DISTINCT b FROM Store s JOIN s.books b WHERE s.storeId = :storeId")
    Page<Book> findAllBooksByStoreId(PageRequest pageRequest, @Param("storeId") int storeId);
}
