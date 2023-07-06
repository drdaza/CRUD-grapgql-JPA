package com.drdaza.CRUDGraphqlJPA.resolver.entitiesMutations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.drdaza.CRUDGraphqlJPA.models.Book;
import com.drdaza.CRUDGraphqlJPA.repositories.BookRepository;
import com.drdaza.CRUDGraphqlJPA.resolver.Mutation;

@Component
public class BookMutation implements Mutation<Book, Long>{

    @Autowired
    private BookRepository bookRepository;
    
    @Override
    public Book create(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public Book update(Book entity) {
        return bookRepository.save(entity);
    }

    @Override
    public List<Book> delete(Book entity) {
        bookRepository.delete(entity);

        return bookRepository.findAll();
    }
    
}
