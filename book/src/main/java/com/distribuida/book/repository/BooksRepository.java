package com.distribuida.book.repository;


import com.distribuida.book.db.Book;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class BooksRepository  implements PanacheRepositoryBase<Book, Integer> {
}

