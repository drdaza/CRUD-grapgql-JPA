package com.drdaza.CRUDGraphqlJPA.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drdaza.CRUDGraphqlJPA.models.Author;
import com.drdaza.CRUDGraphqlJPA.models.Book;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesMutations.BookMutation;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries.AuthorQuery;
import com.drdaza.CRUDGraphqlJPA.resolver.entitiesQueries.BookQuery;

@Service
public class BookService {
    
    @Autowired
    private BookMutation bookMutation;
    private BookQuery bookQuery;
    private AuthorQuery authorQuery;
    public BookService(BookQuery bookQuery, AuthorQuery authorQuery) {
        this.bookQuery = bookQuery;
        this.authorQuery = authorQuery;
    }

    public List<Book> findAllBooks(){
        return bookQuery.findAll();
    }

    public Book findOneBook(Long bookId){
        return bookQuery.findOne(bookId);
    }

    public Book createBook(String title, String description, Long authorid){

        Author authorDB = authorQuery.findOne(authorid);
        List<Author> authors = new ArrayList<>();
        Book newBook = new Book(title, description, authors);
        authors.add(authorDB);
        newBook.setAuthors(authors);

        return bookMutation.create(newBook);
    }
}
