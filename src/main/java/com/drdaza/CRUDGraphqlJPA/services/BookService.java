package com.drdaza.CRUDGraphqlJPA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drdaza.CRUDGraphqlJPA.models.Book;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesMutations.BookMutation;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries.BookQuery;

@Service
public class BookService {
    
    @Autowired
    private BookMutation bookMutation;
    private BookQuery bookQuery;
    public BookService(BookQuery bookQuery) {
        this.bookQuery = bookQuery;
    }

    public List<Book> findAllBooks(){
        return bookQuery.findAll();
    }

    public Book findOneBook(Long bookId){
        return bookQuery.findOne(bookId);
    }

    public Book createBook(String title, String description){
        Book newBook = new Book(title, description, null);

        return bookMutation.create(newBook);
    }
}
