package com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.drdaza.CRUDGraphqlJPA.models.Book;
import com.drdaza.CRUDGraphqlJPA.repositories.BookRepository;
import com.drdaza.CRUDGraphqlJPA.resolver.Query;

@Component
public class BookQuery implements Query<Book, Long>{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findOne(Long entity) {
        return bookRepository.findById(entity).orElseThrow(() -> new RuntimeException("Book not found :("));
    }
    
}
